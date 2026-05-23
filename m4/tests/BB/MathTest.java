package org.apache.openjpa.jdbc.kernel.exps;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Black-Box tests for org.apache.openjpa.jdbc.kernel.exps.Math.
 * Derived from the public API (constructor, getters, setters, constants).
 */
public class MathTest {

    @Test
    public void testGetOperationReturnsConstructorValue() {
        Math m = new Math(null, null, "+");
        assertEquals("+", m.getOperation());
    }

    @Test
    public void testGetVal1ReturnsFirstConstructorArgument() {
        Math m = new Math(null, null, Math.ADD);
        assertNull(m.getVal1());
    }

    @Test
    public void testGetVal2ReturnsSecondConstructorArgument() {
        Math m = new Math(null, null, Math.SUBTRACT);
        assertNull(m.getVal2());
    }

    @Test
    public void testGetMetaDataNullByDefault() {
        Math m = new Math(null, null, Math.MULTIPLY);
        assertNull(m.getMetaData());
    }

    @Test
    public void testLengthIsAlwaysOne() {
        Math m = new Math(null, null, Math.MOD);
        assertEquals(1, m.length(null, null, null));
    }

    @Test
    public void testGetIdReturnsMathValConstant() {
        Math m = new Math(null, null, Math.ADD);
        assertEquals(Val.MATH_VAL, m.getId());
    }

    @Test
    public void testAddConstant()     { assertEquals("+",   Math.ADD); }
    @Test
    public void testSubtractConstant(){ assertEquals("-",   Math.SUBTRACT); }
    @Test
    public void testMultiplyConstant(){ assertEquals("*",   Math.MULTIPLY); }
    @Test
    public void testDivideConstant()  { assertEquals("/",   Math.DIVIDE); }
    @Test
    public void testModConstant()     { assertEquals("MOD", Math.MOD); }
}
