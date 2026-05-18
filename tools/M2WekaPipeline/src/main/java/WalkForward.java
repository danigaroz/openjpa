import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.lazy.IBk;
import weka.classifiers.meta.FilteredClassifier;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.filters.supervised.instance.SMOTE;
import weka.filters.supervised.instance.SpreadSubsample;
import weka.filters.supervised.instance.Resample;
import java.io.PrintWriter;

public class WalkForward {
    static final String[] RELEASES = {
        "0_9_6","0_9_7","1_0_0","1_0_1","1_0_2","1_1_0",
        "1_0_3","1_2_0","2_0_0_M1","1_2_1","2_0_0_M2","2_0_0_M3","1_2_2"
    };
    static final String ARFF_DIR = "/workspaces/analysis/arff";
    static final String OUTPUT_CSV = "/workspaces/analysis/m2_results.csv";

    public static void main(String[] args) throws Exception {
        Instances[] ds = new Instances[RELEASES.length];
        for (int i = 0; i < RELEASES.length; i++) {
            ds[i] = new DataSource(ARFF_DIR + "/" + RELEASES[i] + ".arff").getDataSet();
            ds[i].setClassIndex(ds[i].numAttributes() - 1);
        }

        PrintWriter out = new PrintWriter(OUTPUT_CSV);
        out.println("Iteration,TestRelease,Classifier,FS,Balancing,TrainSize,TestSize,BuggyTrain,BuggyTest,Precision,Recall,F1,AUC,Kappa");

        String[] clfs = {"RandomForest","NaiveBayes","IBk"};
        String[] fss = {"None","CFS"};
        String[] bals = {"None","Undersampling","Oversampling","SMOTE"};

        for (int i = 1; i < RELEASES.length; i++) {
            Instances train = new Instances(ds[0]);
            for (int j = 1; j < i; j++) train.addAll(ds[j]);
            Instances test = ds[i];

            int buggyTr = 0, buggyTe = 0;
            for (int k = 0; k < train.numInstances(); k++)
                if (train.instance(k).stringValue(train.classIndex()).equals("Yes")) buggyTr++;
            for (int k = 0; k < test.numInstances(); k++)
                if (test.instance(k).stringValue(test.classIndex()).equals("Yes")) buggyTe++;

            System.out.println("Iter " + i + " -> test=" + RELEASES[i] + " (train=" + train.numInstances() + ", test=" + test.numInstances() + ")");

            for (String c : clfs) for (String f : fss) for (String b : bals) {
                try {
                    double[] m = evaluate(train, test, c, f, b);
                    out.printf("%d,%s,%s,%s,%s,%d,%d,%d,%d,%.4f,%.4f,%.4f,%.4f,%.4f%n",
                        i, RELEASES[i], c, f, b, train.numInstances(), test.numInstances(),
                        buggyTr, buggyTe, m[0], m[1], m[2], m[3], m[4]);
                } catch (Exception e) {
                    System.err.println("  err " + c + "/" + f + "/" + b + ": " + e.getMessage());
                }
            }
        }
        out.close();
        System.out.println("DONE. Results: " + OUTPUT_CSV);
    }

    static double[] evaluate(Instances tr, Instances te, String c, String f, String b) throws Exception {
        Instances trP = tr, teP = te;
        if (f.equals("CFS")) {
            AttributeSelection sel = new AttributeSelection();
            sel.setEvaluator(new CfsSubsetEval());
            GreedyStepwise gs = new GreedyStepwise();
            gs.setSearchBackwards(true);
            sel.setSearch(gs);
            sel.setInputFormat(tr);
            trP = Filter.useFilter(tr, sel);
            teP = Filter.useFilter(te, sel);
            trP.setClassIndex(trP.numAttributes() - 1);
            teP.setClassIndex(teP.numAttributes() - 1);
        }

        AbstractClassifier base = getClf(c);
        AbstractClassifier finalClf;
        if (b.equals("None")) finalClf = base;
        else {
            FilteredClassifier fc = new FilteredClassifier();
            fc.setClassifier(base);
            Filter bf = getBal(b);
            bf.setInputFormat(trP);
            fc.setFilter(bf);
            finalClf = fc;
        }
        finalClf.buildClassifier(trP);
        Evaluation ev = new Evaluation(trP);
        ev.evaluateModel(finalClf, teP);
        return new double[]{ev.precision(0), ev.recall(0), ev.fMeasure(0), ev.areaUnderROC(0), ev.kappa()};
    }

    static AbstractClassifier getClf(String n) {
        switch (n) {
            case "RandomForest": return new RandomForest();
            case "NaiveBayes":   return new NaiveBayes();
            case "IBk":          return new IBk();
        }
        throw new RuntimeException("?");
    }

    static Filter getBal(String n) throws Exception {
        switch (n) {
            case "Undersampling":
                SpreadSubsample ss = new SpreadSubsample();
                ss.setOptions(new String[]{"-M","1.0"});
                return ss;
            case "Oversampling":
                Resample rs = new Resample();
                rs.setOptions(new String[]{"-B","1.0","-S","1","-Z","100.0"});
                return rs;
            case "SMOTE":
                return new SMOTE();
        }
        throw new RuntimeException("?");
    }
}
