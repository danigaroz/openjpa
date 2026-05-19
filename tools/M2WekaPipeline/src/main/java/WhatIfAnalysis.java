import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.meta.FilteredClassifier;
import weka.filters.supervised.instance.SMOTE;

public class WhatIfAnalysis {
    public static void main(String[] args) throws Exception {
        String dir = "/workspaces/analysis/arff_v2";
        
        Instances A     = new DataSource(dir + "/A.arff").getDataSet();
        Instances Bplus = new DataSource(dir + "/Bplus.arff").getDataSet();
        Instances B     = new DataSource(dir + "/B.arff").getDataSet();
        Instances C     = new DataSource(dir + "/C.arff").getDataSet();
        
        for (Instances ds : new Instances[]{A, Bplus, B, C})
            ds.setClassIndex(ds.numAttributes() - 1);
        
        // BClassifierA = RandomForest + SMOTE entrenado en A
        FilteredClassifier bclf = new FilteredClassifier();
        bclf.setClassifier(new RandomForest());
        SMOTE smote = new SMOTE();
        smote.setInputFormat(A);
        bclf.setFilter(smote);
        bclf.buildClassifier(A);
        System.out.println("BClassifierA entrenado.");
        
        int[] predA     = predict(bclf, A);
        int[] predBplus = predict(bclf, Bplus);
        int[] predB     = predict(bclf, B);
        int[] predC     = predict(bclf, C);
        
        printSummary("A",     A,     predA);
        printSummary("B+",    Bplus, predBplus);
        printSummary("B",     B,     predB);
        printSummary("C",     C,     predC);
        
        // Counterfactual B+ vs B (mismas filas, NSmells distinto)
        int preventable = 0, newBuggy = 0, stableYes = 0, stableNo = 0;
        for (int i = 0; i < Bplus.numInstances(); i++) {
            boolean yBplus = (predBplus[i] == 0);
            boolean yB     = (predB[i] == 0);
            if (yBplus && !yB) preventable++;
            else if (!yBplus && yB) newBuggy++;
            else if (yBplus && yB) stableYes++;
            else stableNo++;
        }
        
        int actualBuggyBplus = 0;
        for (int i = 0; i < Bplus.numInstances(); i++)
            if (Bplus.instance(i).stringValue(Bplus.classIndex()).equals("Yes")) actualBuggyBplus++;
        int predBuggyBplus = stableYes + preventable;
        
        System.out.println("\n=== COUNTERFACTUAL B+ vs B ===");
        System.out.println("Preventable (B+ Yes -> B No):    " + preventable);
        System.out.println("New buggy   (B+ No  -> B Yes):   " + newBuggy);
        System.out.println("Stable Yes:                       " + stableYes);
        System.out.println("Stable No:                        " + stableNo);
        
        System.out.println("\n=== TOTALES ===");
        System.out.println("Actual buggy en B+:    " + actualBuggyBplus);
        System.out.println("Predicted buggy en B+: " + predBuggyBplus);
        if (predBuggyBplus > 0) {
            double pct = 100.0 * preventable / predBuggyBplus;
            System.out.printf("Preventable %% (de predicted buggy en B+): %.1f%%%n", pct);
        }
        double pctTotal = 100.0 * preventable / Bplus.numInstances();
        System.out.printf("Preventable %% (del total B+): %.2f%%%n", pctTotal);
    }
    
    static int[] predict(AbstractClassifier clf, Instances ds) throws Exception {
        int[] p = new int[ds.numInstances()];
        for (int i = 0; i < ds.numInstances(); i++) p[i] = (int) clf.classifyInstance(ds.instance(i));
        return p;
    }
    
    static void printSummary(String name, Instances ds, int[] preds) {
        int actualY = 0, predY = 0;
        for (int i = 0; i < ds.numInstances(); i++) {
            if (ds.instance(i).stringValue(ds.classIndex()).equals("Yes")) actualY++;
            if (preds[i] == 0) predY++;
        }
        System.out.printf("%-4s: n=%-5d actual_Yes=%-5d predicted_Yes=%-5d%n", name, ds.numInstances(), actualY, predY);
    }
}
