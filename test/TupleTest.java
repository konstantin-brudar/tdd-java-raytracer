import org.junit.Test;

import static org.junit.Assert.*;

public class TupleTest {
    private final double EPSILON = 0.001;

    @Test
    public void point() {
        Tuple tuple = new Tuple(4.3, -4.2, 3.1, 1.0);

        assertEquals(4.3, tuple.x, EPSILON);
        assertEquals(-4.2, tuple.y, EPSILON);
        assertEquals(3.1, tuple.z, EPSILON);
        assertEquals(1.0, tuple.w, EPSILON);

        assertTrue(tuple.isPoint());
        assertFalse(tuple.isVector());
    }

    @Test
    public void vector() {
        Tuple tuple = new Tuple(4.3, -4.2, 3.1, 0.0);

        assertEquals(4.3, tuple.x, EPSILON);
        assertEquals(-4.2, tuple.y, EPSILON);
        assertEquals(3.1, tuple.z, EPSILON);
        assertEquals(0.0, tuple.w, EPSILON);

        assertFalse(tuple.isPoint());
        assertTrue(tuple.isVector());
    }

    @Test
    public void equal() {
        Tuple tuple1 = new Tuple(1, 2, 3, 1);
        Tuple tuple2 = new Tuple(1, 2, 3, 1);
        Tuple tuple3 = new Tuple(1, 2, 3, 0);

        assertTrue(tuple1.equal(tuple2));
        assertFalse(tuple1.equal(tuple3));
    }

    @Test
    public void add() {
        Tuple tuple1 = new Tuple(3, -2, 5, 1);
        Tuple tuple2 = new Tuple(-2, 3, 1, 0);
        Tuple tuple3 = new Tuple(1, 1, 6, 1);

        assertTrue(tuple3.equal(tuple1.add(tuple2)));
    }

    @Test
    public void sub() {
        Tuple tuple1 = new Tuple(3, 2, 1, 1);
        Tuple tuple2 = new Tuple(5, 6, 7, 0);
        Tuple tuple3 = new Tuple(-2, -4, -6, 1);

        assertTrue(tuple3.equal(tuple1.sub(tuple2)));
    }

    @Test
    public void negate() {
        Tuple tuple1 = new Tuple(1, -2, 3, -4);
        Tuple tuple2 = new Tuple(-1, 2, -3, 4);

        assertTrue(tuple1.equal(tuple2.negate()));
    }

    @Test
    public void mul() {
        Tuple tuple1 = new Tuple(1, -2, 3, -4);
        Tuple tuple2 = new Tuple(3.5, -7, 10.5, -14);
        double number = 3.5;

        assertTrue(tuple2.equal(tuple1.mul(number)));
    }

    @Test
    public void div() {
        Tuple tuple1 = new Tuple(1, -2, 3, -4);
        Tuple tuple2 = new Tuple(0.5, -1, 1.5, -2);
        double number = 2.0;

        assertTrue(tuple2.equal(tuple1.div(number)));
    }

    @Test
    public void magnitude() {
        Tuple tuple = new Tuple(-1, -2, -3, 0);
        double number = Math.sqrt(14);

        assertTrue(Operation.equal(number, tuple.magnitude()));
    }

    @Test
    public void normalize() {
        Tuple tuple1 = new Tuple(1, 2, 3, 0);
        double magnitude = Math.sqrt(14);
        Tuple tuple2 = new Tuple(1 / magnitude, 2 / magnitude, 3 / magnitude, 0 / magnitude);

        assertTrue(tuple2.equal(tuple1.normalize()));
    }

    @Test
    public void dot() {
        Tuple tuple1 = new Tuple(1, 2, 3, 0);
        Tuple tuple2 = new Tuple(2, 3, 4, 0);
        double dotProduct = 20.0;

        assertTrue(Operation.equal(dotProduct, tuple1.dot(tuple2)));
    }

    @Test
    public void cross() {
        Tuple tuple1 = new Tuple(1, 2, 3, 0);
        Tuple tuple2 = new Tuple(2, 3, 4, 0);
        Tuple tuple3 = new Tuple(-1, 2, -1, 0);
        Tuple tuple4 = new Tuple(1, -2, 1, 0);

        assertTrue(tuple3.equal(tuple1.cross(tuple2)));
        assertTrue(tuple4.equal(tuple2.cross(tuple1)));
    }
}