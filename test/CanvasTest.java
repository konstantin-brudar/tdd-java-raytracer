import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CanvasTest {
    private final double EPSILON = 0.001;

    @Test
    public void canvasSize() {
        Canvas canvas = new Canvas(10, 20);

        assertEquals(10, canvas.width());
        assertEquals(20, canvas.height());
    }

    @Test
    public void canvasGetColor() {
        Canvas canvas = new Canvas(10, 20);

        for (int i = 0; i < canvas.height(); i++) {
            for (int j = 0; j < canvas.width(); j++) {
                Color color = canvas.getPixel(i, j);
                assertEquals(0.0, color.red(), EPSILON);
                assertEquals(0.0, color.green(), EPSILON);
                assertEquals(0.0, color.blue(), EPSILON);
            }
        }
    }

    @Test
    public void canvasSetColor() {
        Canvas canvas = new Canvas(10, 20);

        Color color = new Color(1.0, 0.5, 0.0);
        canvas.setPixel(1, 2, color);

        Color newColor = canvas.getPixel(1, 2);
        assertEquals(1.0, newColor.red(), EPSILON);
        assertEquals(0.5, newColor.green(), EPSILON);
        assertEquals(0.0, newColor.blue(), EPSILON);
    }

}