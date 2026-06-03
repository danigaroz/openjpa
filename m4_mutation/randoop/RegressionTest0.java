import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    public void assertBooleanArrayEquals(boolean[] expectedArray, boolean[] actualArray) {
        if (expectedArray.length != actualArray.length) {
            throw new AssertionError("Array lengths differ: " + expectedArray.length + " != " + actualArray.length);
        }
        for (int i = 0; i < expectedArray.length; i++) {
            if (expectedArray[i] != actualArray[i]) {
                throw new AssertionError("Arrays differ at index " + i + ": " + expectedArray[i] + " != " + actualArray[i]);
            }
        }
    }

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test01");
        java.lang.String str0 = org.apache.openjpa.jdbc.kernel.exps.Math.MULTIPLY;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "*" + "'", str0, "*");
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test02");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.MATH_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test03");
        java.lang.String str0 = org.apache.openjpa.jdbc.kernel.exps.Math.MOD;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "MOD" + "'", str0, "MOD");
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test04");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.select(select4, expContext5, expState6, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test05");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        org.apache.openjpa.jdbc.sql.SQLBuffer sQLBuffer7 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.appendTo(select4, expContext5, expState6, sQLBuffer7, (int) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test06");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.TRIM_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 6 + "'", int0 == 6);
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test07");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState5 = null;
        org.apache.openjpa.jdbc.sql.Result result6 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj7 = math3.load(expContext4, expState5, result6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test08");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.selectColumns(select4, expContext5, expState6, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test09");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.INDEXOF_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 10 + "'", int0 == 10);
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test10");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.JOIN_REL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test11");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.SIMPLECASE_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 13 + "'", int0 == 13);
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test12");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.openjpa.jdbc.kernel.exps.ExpState expState7 = math3.initialize(select4, expContext5, 4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test13");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.FORCE_OUTER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8 + "'", int0 == 8);
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test14");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        org.apache.openjpa.jdbc.sql.SQLBuffer sQLBuffer7 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.appendType(select4, expContext5, expState6, sQLBuffer7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test15");
        java.lang.String str0 = org.apache.openjpa.jdbc.kernel.exps.Math.DIVIDE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "/" + "'", str0, "/");
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test16");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class class4 = math3.getType();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test17");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.kernel.exps.Path path4 = math3.getPath();
        org.apache.openjpa.jdbc.sql.Select select5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState7 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.select(select5, expContext6, expState7, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(path4);
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test18");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.LOCATE_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8 + "'", int0 == 8);
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test19");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.WHENCONDITION_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 15 + "'", int0 == 15);
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test20");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test21() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test21");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.jdbc.sql.Select select9 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext10 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState11 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val12 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val13 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math15 = new org.apache.openjpa.jdbc.kernel.exps.Math(val12, val13, "MOD");
        org.apache.openjpa.jdbc.sql.Select select16 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext17 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState18 = null;
        java.lang.Object obj20 = math15.toDataStoreValue(select16, expContext17, expState18, (java.lang.Object) (byte) 0);
        org.apache.openjpa.kernel.exps.Value value21 = math15.getSelectAs();
        org.apache.openjpa.jdbc.sql.Select select22 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext23 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState24 = null;
        java.lang.Object obj26 = math15.toDataStoreValue(select22, expContext23, expState24, (java.lang.Object) 'a');
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState27 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.calculateValue(select9, expContext10, expState11, (org.apache.openjpa.jdbc.kernel.exps.Val) math15, expState27);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertEquals("'" + obj20 + "' != '" + (byte) 0 + "'", obj20, (byte) 0);
        org.junit.Assert.assertNull(value21);
        org.junit.Assert.assertEquals("'" + obj26 + "' != '" + 'a' + "'", obj26, 'a');
    }

    @Test
    public void test22() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test22");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        int int4 = math3.getId();
        java.lang.String str5 = math3.getOperation();
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "MOD" + "'", str5, "MOD");
    }

    @Test
    public void test23() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test23");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        int int4 = math3.getId();
        org.apache.openjpa.jdbc.sql.Select select5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState7 = null;
        org.apache.openjpa.jdbc.sql.SQLBuffer sQLBuffer8 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.appendIndex(select5, expContext6, expState7, sQLBuffer8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
    }

    @Test
    public void test24() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test24");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.kernel.exps.Path path4 = math3.getPath();
        org.apache.openjpa.jdbc.sql.Select select5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState7 = null;
        org.apache.openjpa.jdbc.sql.SQLBuffer sQLBuffer8 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.appendIsNotEmpty(select5, expContext6, expState7, sQLBuffer8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(path4);
    }

    @Test
    public void test25() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test25");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.ABS_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 11 + "'", int0 == 11);
    }

    @Test
    public void test26() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test26");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        java.lang.Class class4 = null;
        math3.setImplicitType(class4);
        boolean boolean6 = math3.isXPath();
        org.apache.openjpa.jdbc.sql.Select select7 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext8 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState9 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.select(select7, expContext8, expState9, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test27() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test27");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.SQRT_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 12 + "'", int0 == 12);
    }

    @Test
    public void test28() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test28");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.LENGTH_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 7 + "'", int0 == 7);
    }

    @Test
    public void test29() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test29");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.COALESCE_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 17 + "'", int0 == 17);
    }

    @Test
    public void test30() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test30");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.selectColumns(select4, expContext5, expState6, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test31() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test31");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        int int4 = math3.getId();
        boolean boolean5 = math3.isVariable();
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test32() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test32");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        int int4 = math3.getId();
        java.lang.String str5 = math3.getName();
        boolean boolean6 = math3.isAggregate();
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test33() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test33");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.kernel.exps.Path path4 = math3.getPath();
        org.apache.openjpa.jdbc.sql.Select select5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState7 = null;
        java.lang.Object obj9 = math3.toDataStoreValue(select5, expContext6, expState7, (java.lang.Object) 100);
        math3.setAlias("");
        org.apache.openjpa.jdbc.kernel.exps.Val val12 = math3.getVal1();
        org.junit.Assert.assertNull(path4);
        org.junit.Assert.assertEquals("'" + obj9 + "' != '" + 100 + "'", obj9, 100);
        org.junit.Assert.assertNull(val12);
    }

    @Test
    public void test34() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test34");
        java.lang.String str0 = org.apache.openjpa.jdbc.kernel.exps.Math.SUBTRACT;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "-" + "'", str0, "-");
    }

    @Test
    public void test35() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test35");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        java.lang.Class class4 = null;
        math3.setImplicitType(class4);
        org.apache.openjpa.kernel.exps.ExpressionVisitor expressionVisitor6 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.acceptVisit(expressionVisitor6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test36() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test36");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        math3.setAlias("hi!");
        boolean boolean11 = math3.isVariable();
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test37() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test37");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.CONCAT_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test38() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test38");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.GENERALCASE_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 14 + "'", int0 == 14);
    }

    @Test
    public void test39() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test39");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.UPPER_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test40() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test40");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        java.lang.Class class4 = null;
        math3.setImplicitType(class4);
        org.apache.openjpa.jdbc.sql.Select select6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext7 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState8 = null;
        java.lang.Object obj10 = math3.toDataStoreValue(select6, expContext7, expState8, (java.lang.Object) 1);
        org.apache.openjpa.meta.ClassMetaData classMetaData11 = null;
        math3.setMetaData(classMetaData11);
        org.junit.Assert.assertEquals("'" + obj10 + "' != '" + 1 + "'", obj10, 1);
    }

    @Test
    public void test41() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test41");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.kernel.exps.Value value9 = math3.getSelectAs();
        boolean boolean10 = math3.isXPath();
        org.apache.openjpa.jdbc.sql.Select select11 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext12 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState13 = null;
        org.apache.openjpa.jdbc.sql.SQLBuffer sQLBuffer14 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.appendType(select11, expContext12, expState13, sQLBuffer14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertNull(value9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test42() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test42");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.WHENSCALAR_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 16 + "'", int0 == 16);
    }

    @Test
    public void test43() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test43");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.jdbc.sql.Select select9 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext10 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState11 = null;
        int int12 = math3.length(select9, expContext10, expState11);
        org.apache.openjpa.jdbc.kernel.exps.Val val13 = math3.getVal2();
        org.apache.openjpa.kernel.exps.ExpressionVisitor expressionVisitor14 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.acceptVisit(expressionVisitor14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 1 + "'", int12 == 1);
        org.junit.Assert.assertNull(val13);
    }

    @Test
    public void test44() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test44");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.jdbc.sql.Select select9 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext10 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState11 = null;
        int int12 = math3.length(select9, expContext10, expState11);
        org.apache.openjpa.kernel.exps.Value value13 = math3.getSelectAs();
        org.apache.openjpa.jdbc.sql.Select select14 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext15 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState16 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val17 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val18 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math20 = new org.apache.openjpa.jdbc.kernel.exps.Math(val17, val18, "MOD");
        org.apache.openjpa.jdbc.sql.Select select21 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext22 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState23 = null;
        java.lang.Object obj25 = math20.toDataStoreValue(select21, expContext22, expState23, (java.lang.Object) (byte) 0);
        org.apache.openjpa.kernel.exps.Value value26 = math20.getSelectAs();
        boolean boolean27 = math20.isXPath();
        org.apache.openjpa.meta.ClassMetaData classMetaData28 = null;
        math20.setMetaData(classMetaData28);
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState30 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.calculateValue(select14, expContext15, expState16, (org.apache.openjpa.jdbc.kernel.exps.Val) math20, expState30);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 1 + "'", int12 == 1);
        org.junit.Assert.assertNull(value13);
        org.junit.Assert.assertEquals("'" + obj25 + "' != '" + (byte) 0 + "'", obj25, (byte) 0);
        org.junit.Assert.assertNull(value26);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
    }

    @Test
    public void test45() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test45");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.jdbc.sql.Select select9 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext10 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState11 = null;
        int int12 = math3.length(select9, expContext10, expState11);
        org.apache.openjpa.jdbc.kernel.exps.Val val13 = math3.getVal2();
        org.apache.openjpa.jdbc.sql.Select select14 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext15 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState16 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.orderBy(select14, expContext15, expState16, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 1 + "'", int12 == 1);
        org.junit.Assert.assertNull(val13);
    }

    @Test
    public void test46() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test46");
        java.lang.String str0 = org.apache.openjpa.jdbc.kernel.exps.Math.ADD;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "+" + "'", str0, "+");
    }

    @Test
    public void test47() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test47");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.kernel.exps.Value value9 = math3.getSelectAs();
        org.apache.openjpa.jdbc.sql.Select select10 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext11 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState12 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.selectColumns(select10, expContext11, expState12, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertNull(value9);
    }

    @Test
    public void test48() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test48");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.jdbc.sql.Select select9 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext10 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState11 = null;
        int int12 = math3.length(select9, expContext10, expState11);
        org.apache.openjpa.jdbc.kernel.exps.Val val13 = math3.getVal2();
        org.apache.openjpa.jdbc.sql.Select select14 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext15 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState16 = null;
        org.apache.openjpa.jdbc.sql.SQLBuffer sQLBuffer17 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.appendIsNotNull(select14, expContext15, expState16, sQLBuffer17);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 1 + "'", int12 == 1);
        org.junit.Assert.assertNull(val13);
    }

    @Test
    public void test49() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test49");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.jdbc.sql.Select select9 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext10 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.openjpa.jdbc.kernel.exps.ExpState expState12 = math3.initialize(select9, expContext10, 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
    }

    @Test
    public void test50() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test50");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        math3.setAlias("hi!");
        org.apache.openjpa.jdbc.sql.Select select11 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext12 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState13 = null;
        org.apache.openjpa.jdbc.sql.SQLBuffer sQLBuffer14 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.appendSize(select11, expContext12, expState13, sQLBuffer14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
    }

    @Test
    public void test51() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test51");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        java.lang.Class class9 = null;
        math3.setImplicitType(class9);
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext11 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState12 = null;
        org.apache.openjpa.jdbc.sql.Result result13 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj14 = math3.load(expContext11, expState12, result13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
    }

    @Test
    public void test52() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test52");
        int int0 = org.apache.openjpa.jdbc.kernel.exps.Val.LOWER_VAL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 5 + "'", int0 == 5);
    }

    @Test
    public void test53() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test53");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        int int4 = math3.getId();
        java.lang.String str5 = math3.getName();
        boolean boolean6 = math3.isXPath();
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNull(str5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test54() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test54");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.openjpa.jdbc.kernel.exps.ExpState expState7 = math3.initialize(select4, expContext5, 7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test55() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test55");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.jdbc.sql.Select select9 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext10 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState11 = null;
        int int12 = math3.length(select9, expContext10, expState11);
        org.apache.openjpa.kernel.exps.Value value13 = math3.getSelectAs();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class class14 = math3.getType();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 1 + "'", int12 == 1);
        org.junit.Assert.assertNull(value13);
    }

    @Test
    public void test56() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test56");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.kernel.exps.Value value9 = math3.getSelectAs();
        java.lang.String str10 = math3.getAlias();
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertNull(value9);
        org.junit.Assert.assertNull(str10);
    }

    @Test
    public void test57() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test57");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.meta.ClassMetaData classMetaData4 = math3.getMetaData();
        org.apache.openjpa.jdbc.sql.Select select5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState7 = null;
        java.lang.Object obj9 = math3.toDataStoreValue(select5, expContext6, expState7, (java.lang.Object) 2);
        org.junit.Assert.assertNull(classMetaData4);
        org.junit.Assert.assertEquals("'" + obj9 + "' != '" + 2 + "'", obj9, 2);
    }

    @Test
    public void test58() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test58");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.kernel.exps.Path path4 = math3.getPath();
        org.apache.openjpa.jdbc.sql.Select select5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState7 = null;
        java.lang.Object obj9 = math3.toDataStoreValue(select5, expContext6, expState7, (java.lang.Object) 100);
        math3.setAlias("");
        org.apache.openjpa.jdbc.sql.Select select12 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext13 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState14 = null;
        org.apache.openjpa.jdbc.sql.SQLBuffer sQLBuffer15 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.appendIsEmpty(select12, expContext13, expState14, sQLBuffer15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(path4);
        org.junit.Assert.assertEquals("'" + obj9 + "' != '" + 100 + "'", obj9, 100);
    }

    @Test
    public void test59() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test59");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.meta.ClassMetaData classMetaData4 = math3.getMetaData();
        org.apache.openjpa.jdbc.sql.Select select5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext6 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.openjpa.jdbc.kernel.exps.ExpState expState8 = math3.initialize(select5, expContext6, 15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(classMetaData4);
    }

    @Test
    public void test60() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test60");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        int int4 = math3.getId();
        java.lang.String str5 = math3.getName();
        org.apache.openjpa.jdbc.sql.Select select6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext7 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState8 = null;
        org.apache.openjpa.jdbc.sql.SQLBuffer sQLBuffer9 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.appendTo(select6, expContext7, expState8, sQLBuffer9, 17);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test61() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test61");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.kernel.exps.Value value9 = math3.getSelectAs();
        boolean boolean10 = math3.isXPath();
        org.apache.openjpa.jdbc.sql.Select select11 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext12 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState13 = null;
        org.apache.openjpa.jdbc.sql.SQLBuffer sQLBuffer14 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.appendIsNotEmpty(select11, expContext12, expState13, sQLBuffer14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertNull(value9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test62() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test62");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.kernel.exps.Value value9 = math3.getSelectAs();
        org.apache.openjpa.jdbc.sql.Select select10 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext11 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState12 = null;
        java.lang.Object obj14 = math3.toDataStoreValue(select10, expContext11, expState12, (java.lang.Object) 'a');
        org.apache.openjpa.jdbc.sql.Select select15 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext16 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState17 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.selectColumns(select15, expContext16, expState17, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertNull(value9);
        org.junit.Assert.assertEquals("'" + obj14 + "' != '" + 'a' + "'", obj14, 'a');
    }

    @Test
    public void test63() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test63");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.kernel.exps.Path path4 = math3.getPath();
        org.apache.openjpa.jdbc.sql.Select select5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState7 = null;
        java.lang.Object obj9 = math3.toDataStoreValue(select5, expContext6, expState7, (java.lang.Object) 100);
        org.apache.openjpa.jdbc.sql.Select select10 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext11 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState12 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.groupBy(select10, expContext11, expState12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(path4);
        org.junit.Assert.assertEquals("'" + obj9 + "' != '" + 100 + "'", obj9, 100);
    }

    @Test
    public void test64() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test64");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.kernel.exps.Val val4 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val5 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math7 = new org.apache.openjpa.jdbc.kernel.exps.Math(val4, val5, "MOD");
        org.apache.openjpa.jdbc.sql.Select select8 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext9 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState10 = null;
        java.lang.Object obj12 = math7.toDataStoreValue(select8, expContext9, expState10, (java.lang.Object) (byte) 0);
        org.apache.openjpa.jdbc.sql.Select select13 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext14 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState15 = null;
        int int16 = math7.length(select13, expContext14, expState15);
        org.apache.openjpa.jdbc.kernel.exps.Val val17 = math7.getVal2();
        org.apache.openjpa.jdbc.kernel.exps.Math math19 = new org.apache.openjpa.jdbc.kernel.exps.Math((org.apache.openjpa.jdbc.kernel.exps.Val) math3, val17, "+");
        java.lang.String str20 = math19.getName();
        org.junit.Assert.assertEquals("'" + obj12 + "' != '" + (byte) 0 + "'", obj12, (byte) 0);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 1 + "'", int16 == 1);
        org.junit.Assert.assertNull(val17);
        org.junit.Assert.assertNull(str20);
    }

    @Test
    public void test65() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test65");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.kernel.exps.Path path4 = math3.getPath();
        org.apache.openjpa.jdbc.sql.Select select5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState7 = null;
        java.lang.Object obj9 = math3.toDataStoreValue(select5, expContext6, expState7, (java.lang.Object) 100);
        boolean boolean10 = math3.isXPath();
        org.apache.openjpa.jdbc.sql.Select select11 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext12 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState13 = null;
        java.lang.Object obj15 = math3.toDataStoreValue(select11, expContext12, expState13, (java.lang.Object) 1);
        org.junit.Assert.assertNull(path4);
        org.junit.Assert.assertEquals("'" + obj9 + "' != '" + 100 + "'", obj9, 100);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertEquals("'" + obj15 + "' != '" + 1 + "'", obj15, 1);
    }

    @Test
    public void test66() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test66");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.sql.Select select4 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState6 = null;
        java.lang.Object obj8 = math3.toDataStoreValue(select4, expContext5, expState6, (java.lang.Object) (byte) 0);
        org.apache.openjpa.kernel.exps.Value value9 = math3.getSelectAs();
        org.apache.openjpa.kernel.exps.Path path10 = math3.getPath();
        org.junit.Assert.assertEquals("'" + obj8 + "' != '" + (byte) 0 + "'", obj8, (byte) 0);
        org.junit.Assert.assertNull(value9);
        org.junit.Assert.assertNull(path10);
    }

    @Test
    public void test67() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test67");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.kernel.exps.Path path4 = math3.getPath();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Class class5 = math3.getType();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(path4);
    }

    @Test
    public void test68() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test68");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.kernel.exps.Path path4 = math3.getPath();
        int int5 = math3.getId();
        org.apache.openjpa.kernel.exps.Path path6 = math3.getPath();
        org.junit.Assert.assertNull(path4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNull(path6);
    }

    @Test
    public void test69() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test69");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.kernel.exps.Path path4 = math3.getPath();
        org.apache.openjpa.jdbc.sql.Select select5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState7 = null;
        java.lang.Object obj9 = math3.toDataStoreValue(select5, expContext6, expState7, (java.lang.Object) 100);
        java.lang.String str10 = math3.getAlias();
        org.apache.openjpa.kernel.exps.Value value11 = math3.getSelectAs();
        org.junit.Assert.assertNull(path4);
        org.junit.Assert.assertEquals("'" + obj9 + "' != '" + 100 + "'", obj9, 100);
        org.junit.Assert.assertNull(str10);
        org.junit.Assert.assertNull(value11);
    }

    @Test
    public void test70() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test70");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.kernel.exps.Path path4 = math3.getPath();
        org.apache.openjpa.jdbc.sql.Select select5 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState7 = null;
        java.lang.Object obj9 = math3.toDataStoreValue(select5, expContext6, expState7, (java.lang.Object) 100);
        math3.setAlias("");
        org.apache.openjpa.meta.ClassMetaData classMetaData12 = math3.getMetaData();
        org.apache.openjpa.jdbc.kernel.exps.Val val13 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val14 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math16 = new org.apache.openjpa.jdbc.kernel.exps.Math(val13, val14, "MOD");
        org.apache.openjpa.jdbc.sql.Select select17 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext18 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState19 = null;
        java.lang.Object obj21 = math16.toDataStoreValue(select17, expContext18, expState19, (java.lang.Object) (byte) 0);
        org.apache.openjpa.kernel.exps.Path path22 = math16.getPath();
        boolean boolean23 = math16.isAggregate();
        org.apache.openjpa.jdbc.kernel.exps.Math math25 = new org.apache.openjpa.jdbc.kernel.exps.Math((org.apache.openjpa.jdbc.kernel.exps.Val) math3, (org.apache.openjpa.jdbc.kernel.exps.Val) math16, "");
        org.junit.Assert.assertNull(path4);
        org.junit.Assert.assertEquals("'" + obj9 + "' != '" + 100 + "'", obj9, 100);
        org.junit.Assert.assertNull(classMetaData12);
        org.junit.Assert.assertEquals("'" + obj21 + "' != '" + (byte) 0 + "'", obj21, (byte) 0);
        org.junit.Assert.assertNull(path22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
    }

    @Test
    public void test71() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test71");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.jdbc.kernel.exps.Val val4 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val5 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math7 = new org.apache.openjpa.jdbc.kernel.exps.Math(val4, val5, "MOD");
        org.apache.openjpa.jdbc.sql.Select select8 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext9 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState10 = null;
        java.lang.Object obj12 = math7.toDataStoreValue(select8, expContext9, expState10, (java.lang.Object) (byte) 0);
        org.apache.openjpa.jdbc.sql.Select select13 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext14 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState15 = null;
        int int16 = math7.length(select13, expContext14, expState15);
        org.apache.openjpa.jdbc.kernel.exps.Val val17 = math7.getVal2();
        org.apache.openjpa.jdbc.kernel.exps.Math math19 = new org.apache.openjpa.jdbc.kernel.exps.Math((org.apache.openjpa.jdbc.kernel.exps.Val) math3, val17, "+");
        java.lang.Class class20 = null;
        math19.setImplicitType(class20);
        org.junit.Assert.assertEquals("'" + obj12 + "' != '" + (byte) 0 + "'", obj12, (byte) 0);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 1 + "'", int16 == 1);
        org.junit.Assert.assertNull(val17);
    }

    @Test
    public void test72() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test72");
        org.apache.openjpa.jdbc.kernel.exps.Val val0 = null;
        org.apache.openjpa.jdbc.kernel.exps.Val val1 = null;
        org.apache.openjpa.jdbc.kernel.exps.Math math3 = new org.apache.openjpa.jdbc.kernel.exps.Math(val0, val1, "MOD");
        org.apache.openjpa.kernel.exps.Path path4 = math3.getPath();
        int int5 = math3.getId();
        org.apache.openjpa.jdbc.sql.Select select6 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext7 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState8 = null;
        int int9 = math3.length(select6, expContext7, expState8);
        org.apache.openjpa.jdbc.sql.Select select10 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpContext expContext11 = null;
        org.apache.openjpa.jdbc.kernel.exps.ExpState expState12 = null;
        org.apache.openjpa.jdbc.sql.SQLBuffer sQLBuffer13 = null;
        // The following exception was thrown during execution in test generation
        try {
            math3.appendIsNotEmpty(select10, expContext11, expState12, sQLBuffer13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(path4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 1 + "'", int9 == 1);
    }
}

