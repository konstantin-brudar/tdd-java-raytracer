import org.junit.Test;

import static org.junit.Assert.*;

public class OperationTest {
    private static final double EPSILON = 0.001;

    @Test
    public void equal() {
        double number = 3.001;
        assertTrue(Operation.equal(number, number+Operation.EPSILON/2));
        assertFalse(Operation.equal(number, number+Operation.EPSILON));
    }
}