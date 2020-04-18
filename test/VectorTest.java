import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {
    private Vector vector;
    private final double EPSILON = 0.001;

    @After
    public void afterTest() {
        vector = null;
    }

    @Test
    public void vector() {
        vector = new Vector(4.3, -4.2, 3.1);

        assertEquals(4.3, vector.x, EPSILON);
        assertEquals(-4.2, vector.y, EPSILON);
        assertEquals(3.1, vector.z, EPSILON);
        assertEquals(0.0, vector.w, EPSILON);

        assertFalse(vector.isPoint());
        assertTrue(vector.isVector());
    }
}