package org.apache.openjpa.jdbc.kernel.exps;
import org.apache.openjpa.meta.ClassMetaData;
import org.junit.Test;
import static org.junit.Assert.*;
public class MathTestLLM {
    private static class StubVal implements Val {
        private final Class<?> type;
        StubVal(Class<?> type) {
            this.type = type;
        }
        @Override
        public Class getType() {
            return type;
        }
        @Override
        public ExpState initialize(org.apache.openjpa.jdbc.sql.Select sel, ExpContext ctx, int flags) {
            return null;
        }
        @Override
        public void select(org.apache.openjpa.jdbc.sql.Select sel, ExpContext ctx, ExpState state, boolean pks) {
        }
        @Override
        public void selectColumns(org.apache.openjpa.jdbc.sql.Select sel, ExpContext ctx, ExpState state, boolean pks) {
        }
        @Override
        public void groupBy(org.apache.openjpa.jdbc.sql.Select sel, ExpContext ctx, ExpState state) {
        }
        @Override
        public void orderBy(org.apache.openjpa.jdbc.sql.Select sel, ExpContext ctx, ExpState state, boolean asc) {
        }
        @Override
        public Object load(ExpContext ctx, ExpState state, org.apache.openjpa.jdbc.sql.Result res) {
            return null;
        }
        @Override
        public void calculateValue(org.apache.openjpa.jdbc.sql.Select sel, ExpContext ctx, ExpState state, Val other, ExpState otherState) {
        }
        @Override
        public int length(org.apache.openjpa.jdbc.sql.Select sel, ExpContext ctx, ExpState state) {
            return 0;
        }
        @Override
        public void appendTo(org.apache.openjpa.jdbc.sql.Select sel, ExpContext ctx, ExpState state,
                             org.apache.openjpa.jdbc.sql.SQLBuffer sql, int index) {
        }
        @Override
        public void acceptVisit(org.apache.openjpa.kernel.exps.ExpressionVisitor visitor) {
        }
        @Override
        public int getId() {
            return 0;
        }
    }
    @Test
    public void testConstants() {
        assertEquals("+", Math.ADD);
        assertEquals("-", Math.SUBTRACT);
        assertEquals("*", Math.MULTIPLY);
        assertEquals("/", Math.DIVIDE);
        assertEquals("MOD", Math.MOD);
    }
    @Test
    public void testConstructorAndGetters() {
        Val v1 = new StubVal(Integer.class);
        Val v2 = new StubVal(Double.class);
        Math math = new Math(v1, v2, Math.ADD);
        assertSame(v1, math.getVal1());
        assertSame(v2, math.getVal2());
        assertEquals(Math.ADD, math.getOperation());
    }
    @Test
    public void testMetaDataGetterSetter() {
        Math math = new Math(null, null, Math.ADD);
        assertNull(math.getMetaData());
        ClassMetaData meta = null;
        math.setMetaData(meta);
        assertNull(math.getMetaData());
    }
    @Test
    public void testGetTypeUsesPromotionWhenNoImplicitType() {
        Val v1 = new StubVal(Integer.class);
        Val v2 = new StubVal(Double.class);
        Math math = new Math(v1, v2, Math.ADD);
        Class<?> type = math.getType();
        assertNotNull(type);
        assertTrue(type == Double.class || type == Number.class);
    }
    @Test
    public void testSetImplicitTypeOverridesType() {
        Val v1 = new StubVal(Integer.class);
        Val v2 = new StubVal(Integer.class);
        Math math = new Math(v1, v2, Math.ADD);
        math.setImplicitType(String.class);
        assertEquals(String.class, math.getType());
    }
    @Test
    public void testLengthAlwaysReturnsOne() {
        Math math = new Math(null, null, Math.ADD);
        assertEquals(1, math.length(null, null, null));
    }
    @Test
    public void testGetIdReturnsMathVal() {
        Math math = new Math(null, null, Math.ADD);
        assertEquals(Val.MATH_VAL, math.getId());
    }
}
