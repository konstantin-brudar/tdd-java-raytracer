import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    private Point point;
    private final double EPSILON = 0.001;

    @After
    public void afterTest() {
        point = null;
    }

    @Test
    public void point() {
        point = new Point(4.3, -4.2, 3.1);

        assertEquals(4.3, point.x, EPSILON);
        assertEquals(-4.2, point.y, EPSILON);
        assertEquals(3.1, point.z, EPSILON);
        assertEquals(1.0, point.w, EPSILON);

        assertTrue(point.isPoint());
        assertFalse(point.isVector());
    }
}