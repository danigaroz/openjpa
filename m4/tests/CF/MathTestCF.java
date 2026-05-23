package org.apache.openjpa.jdbc.kernel.exps;
import org.apache.openjpa.jdbc.sql.Select;
import org.apache.openjpa.kernel.exps.ExpressionVisitor;
import org.junit.Test;
import static org.junit.Assert.*;
public class MathTestCF {
    private static class StubVal implements Val {
        private final Class type;
        StubVal(Class type) {
            this.type = type;
        }
        @Override
        public Class getType() {
            return type;
        }
        @Override
        public ExpState initialize(Select sel, ExpContext ctx, int flags) {
            return null;
        }
        @Override
        public void select(Select sel, ExpContext ctx, ExpState state, boolean pks) {
        }
        @Override
        public void selectColumns(Select sel, ExpContext ctx, ExpState state, boolean pks) {
        }
        @Override
        public void groupBy(Select sel, ExpContext ctx, ExpState state) {
        }
        @Override
        public void orderBy(Select sel, ExpContext ctx, ExpState state, boolean asc) {
        }
        @Override
        public Object load(ExpContext ctx, ExpState state, org.apache.openjpa.jdbc.sql.Result res) {
            return null;
        }
        @Override
        public void calculateValue(Select sel, ExpContext ctx, ExpState state, Val other, ExpState otherState) {
        }
        @Override
        public int length(Select sel, ExpContext ctx, ExpState state) {
            return 0;
        }
        @Override
        public void appendTo(Select sel, ExpContext ctx, ExpState state,
                             org.apache.openjpa.jdbc.sql.SQLBuffer sql, int index) {
        }
        @Override
        public void acceptVisit(ExpressionVisitor visitor) {
        }
        @Override
        public int getId() {
            return 0;
        }
    }
    @Test
    public void testConstructorAndGettersWithValidOperator() {
        Val v1 = new StubVal(Integer.class);
        Val v2 = new StubVal(Integer.class);
        Math math = new Math(v1, v2, Math.ADD);
        assertSame(v1, math.getVal1());
        assertSame(v2, math.getVal2());
        assertEquals(Math.ADD, math.getOperation());
    }
    @Test
    public void testConstructorWithEmptyOperator() {
        Val v1 = new StubVal(Integer.class);
        Val v2 = new StubVal(Integer.class);
        Math math = new Math(v1, v2, "");
        assertEquals("", math.getOperation());
    }
    @Test
    public void testConstructorWithUnknownOperator() {
        Val v1 = new StubVal(Integer.class);
        Val v2 = new StubVal(Integer.class);
        Math math = new Math(v1, v2, "UNKNOWN_OP");
        assertEquals("UNKNOWN_OP", math.getOperation());
    }
    @Test
    public void testGetTypeWithoutCastUsesPromotion() {
        Val v1 = new StubVal(Integer.class);
        Val v2 = new StubVal(Double.class);
        Math math = new Math(v1, v2, Math.ADD);
        Class result = math.getType();
        assertNotNull(result);
        assertEquals(Double.class, result);
    }
    @Test
    public void testGetTypeWithSameTypesNoCast() {
        Val v1 = new StubVal(Integer.class);
        Val v2 = new StubVal(Integer.class);
        Math math = new Math(v1, v2, Math.ADD);
        Class result = math.getType();
        assertEquals(Integer.class, result);
    }
    @Test
    public void testGetTypeWithImplicitCastOverridesPromotion() {
        Val v1 = new StubVal(Integer.class);
        Val v2 = new StubVal(Double.class);
        Math math = new Math(v1, v2, Math.ADD);
        math.setImplicitType(Long.class);
        assertEquals(Long.class, math.getType());
    }
    @Test
    public void testSetImplicitTypeMultipleChanges() {
        Val v1 = new StubVal(Integer.class);
        Val v2 = new StubVal(Float.class);
        Math math = new Math(v1, v2, Math.MULTIPLY);
        math.setImplicitType(Double.class);
        assertEquals(Double.class, math.getType());
        math.setImplicitType(String.class);
        assertEquals(String.class, math.getType());
    }
    @Test
    public void testSetImplicitTypeNullResetsToPromotion() {
        Val v1 = new StubVal(Integer.class);
        Val v2 = new StubVal(Double.class);
        Math math = new Math(v1, v2, Math.SUBTRACT);
        math.setImplicitType(Double.class);
        assertEquals(Double.class, math.getType());
        math.setImplicitType(null);
        Class result = math.getType();
        assertEquals(Double.class, result);
    }
    @Test
    public void testAcceptVisitCallsVisitor() {
        Val v1 = new StubVal(Integer.class);
        Val v2 = new StubVal(Integer.class);
        Math math = new Math(v1, v2, Math.ADD);
        final boolean[] visited = new boolean[2];
        ExpressionVisitor visitor = new ExpressionVisitor() {
            @Override
            public void enter(Object obj) {
                if (obj instanceof Math) {
                    visited[0] = true;
                }
            }
            @Override
            public void exit(Object obj) {
                if (obj instanceof Math) {
                    visited[1] = true;
                }
            }
        };
        math.acceptVisit(visitor);
        assertTrue(visited[0]);
        assertTrue(visited[1]);
    }
    @Test
    public void testGetId() {
        Math math = new Math(new StubVal(Integer.class), new StubVal(Integer.class), Math.ADD);
        assertEquals(Val.MATH_VAL, math.getId());
    }
}
