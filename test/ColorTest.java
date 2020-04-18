import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {
    private final double EPSILON = 0.001;

    @Test
    public void color() {
        Color color = new Color(-0.5, 0.4, 1.7);

        assertEquals(-0.5, color.red(), EPSILON);
        assertEquals(0.4, color.green(), EPSILON);
        assertEquals(1.7, color.blue(), EPSILON);
    }

    @Test
    public void add() {
        Color color1 = new Color(0.9, 0.6, 0.75);
        Color color2 = new Color(0.7, 0.1, 0.25);
        Color color3 = new Color(1.6, 0.7, 1.0);

        assertTrue(color3.equal(color1.add(color2)));
    }

    @Test
    public void sub() {
        Color color1 = new Color(0.9, 0.6, 0.75);
        Color color2 = new Color(0.7, 0.1, 0.25);
        Color color3 = new Color(0.2, 0.5, 0.5);

        assertTrue(color3.equal(color1.sub(color2)));
    }

    @Test
    public void mul() {
        Color color1 = new Color(0.2, 0.3, 0.4);
        Color color2 = new Color(0.4, 0.6, 0.8);
        double number = 2.0;

        assertTrue(color2.equal(color1.mul(number)));
    }

    @Test
    public void prod() {
        Color color1 = new Color(1, 0.2, 0.4);
        Color color2 = new Color(0.9, 1, 0.1);
        Color color3 = new Color(0.9, 0.2, 0.04);

        assertTrue(color3.equal(color1.prod(color2)));
    }
}