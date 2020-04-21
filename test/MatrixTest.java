import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    private final double EPSILON = 0.001;

    @Test
    public void matrix() {
        int size = 4;
        Matrix matrix = new Matrix(size);

        assertEquals(4, matrix.size());

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                assertEquals(0.0, matrix.getElement(row, col), EPSILON);
            }
        }
    }

    @Test
    public void matrixElement() {
        Matrix matrix = new Matrix(2);

        matrix.setElement(0, 0, 1);
        matrix.setElement(0, 1, 2);
        matrix.setElement(1, 0, 3);
        matrix.setElement(1, 1, 4);

        assertEquals(1.0, matrix.getElement(0, 0), EPSILON);
        assertEquals(2.0, matrix.getElement(0, 1), EPSILON);
        assertEquals(3.0, matrix.getElement(1, 0), EPSILON);
        assertEquals(4.0, matrix.getElement(1, 1), EPSILON);
    }

    @Test
    public void matrixEqual() {
        Matrix A = new Matrix(2);

        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(1, 0, 3);
        A.setElement(1, 1, 4);

        Matrix B = new Matrix(2);

        B.setElement(0, 0, 1);
        B.setElement(0, 1, 2);
        B.setElement(1, 0, 3);
        B.setElement(1, 1, 4);

        Matrix C = new Matrix(2);

        C.setElement(0, 0, 1);
        C.setElement(0, 1, 2);
        C.setElement(1, 0, 3);
        C.setElement(1, 1, 7);

        assertTrue(A.equal(B));
        assertFalse(A.equal(C));
    }

    @Test
    public void matrixMultiplication() {
        Matrix A = new Matrix(2);

        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(1, 0, 3);
        A.setElement(1, 1, 4);

        Matrix B = new Matrix(2);

        B.setElement(0, 0, 5);
        B.setElement(0, 1, 6);
        B.setElement(1, 0, 7);
        B.setElement(1, 1, 8);

        Matrix C = new Matrix(2);

        C.setElement(0, 0, 19);
        C.setElement(0, 1, 22);
        C.setElement(1, 0, 43);
        C.setElement(1, 1, 50);

        assertTrue(C.equal(A.mul(B)));
    }

    @Test
    public void matrixTupleMultiplication() {
        Matrix A = new Matrix(4);

        A.setElement(0, 3, 1);
        A.setElement(1, 0, 1);
        A.setElement(2, 2, 1);
        A.setElement(3, 1, 1);

        Tuple x = new Tuple(1,2,3,4);
        Tuple y = new Tuple(4,1,3,2);

        assertTrue(y.equal(A.mul(x)));
    }

    @Test
    public void matrixMultiplicationIdentity() {
        Matrix I = new Matrix(2);

        I.setElement(0, 0, 1);
        I.setElement(1, 1, 1);

        Matrix A = new Matrix(2);

        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(1, 0, 3);
        A.setElement(1, 1, 4);

        assertTrue(A.equal(I.mul(A)));
        assertTrue(A.equal(A.mul(I)));
    }

    @Test
    public void matrixMultiplicationTupleIdentity() {
        Matrix I = new Matrix(4);

        I.setElement(0, 0, 1);
        I.setElement(1, 1, 1);
        I.setElement(2, 2, 1);
        I.setElement(3, 3, 1);

        Tuple x = new Tuple(1,2,3,4);

        assertTrue(x.equal(I.mul(x)));
    }
}