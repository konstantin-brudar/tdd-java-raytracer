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

        Tuple x = new Tuple(1, 2, 3, 4);
        Tuple y = new Tuple(4, 1, 3, 2);

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

        Tuple x = new Tuple(1, 2, 3, 4);

        assertTrue(x.equal(I.mul(x)));
    }

    @Test
    public void matrixTranspose() {
        Matrix A = new Matrix(2);

        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(1, 0, 3);
        A.setElement(1, 1, 4);

        Matrix B = new Matrix(2);

        B.setElement(0, 0, 1);
        B.setElement(0, 1, 3);
        B.setElement(1, 0, 2);
        B.setElement(1, 1, 4);

        assertTrue(B.equal(A.transpose()));
    }

    @Test
    public void matrixDeterminant2d() {
        Matrix A = new Matrix(2);

        A.setElement(0, 0, 1);
        A.setElement(0, 1, 5);
        A.setElement(1, 0, -3);
        A.setElement(1, 1, 2);

        assertEquals(17, A.det(), EPSILON);
    }

    @Test
    public void submatrix3d() {
        Matrix A = new Matrix(3);

        A.setElement(0, 0, 1);
        A.setElement(0, 1, 5);
        A.setElement(0, 2, 0);
        A.setElement(1, 0, -3);
        A.setElement(1, 1, 2);
        A.setElement(1, 2, 7);
        A.setElement(2, 0, 0);
        A.setElement(2, 1, 6);
        A.setElement(2, 2, -3);

        Matrix B = new Matrix(2);

        B.setElement(0, 0, -3);
        B.setElement(0, 1, 2);
        B.setElement(1, 0, 0);
        B.setElement(1, 1, 6);

        assertTrue(B.equal(A.submatrix(0, 2)));
    }

    @Test
    public void submatrix4d() {
        Matrix A = new Matrix(4);

        A.setElement(0, 0, -6);
        A.setElement(0, 1, 1);
        A.setElement(0, 2, 1);
        A.setElement(0, 3, 6);
        A.setElement(1, 0, -8);
        A.setElement(1, 1, 5);
        A.setElement(1, 2, 8);
        A.setElement(1, 3, 6);
        A.setElement(2, 0, -1);
        A.setElement(2, 1, 0);
        A.setElement(2, 2, 8);
        A.setElement(2, 3, 2);
        A.setElement(3, 0, -7);
        A.setElement(3, 1, 1);
        A.setElement(3, 2, -1);
        A.setElement(3, 3, 1);

        Matrix B = new Matrix(3);

        B.setElement(0, 0, -6);
        B.setElement(0, 1, 1);
        B.setElement(0, 2, 6);
        B.setElement(1, 0, -8);
        B.setElement(1, 1, 8);
        B.setElement(1, 2, 6);
        B.setElement(2, 0, -7);
        B.setElement(2, 1, -1);
        B.setElement(2, 2, 1);

        assertTrue(B.equal(A.submatrix(2, 1)));
    }

    @Test
    public void MatrixMinor3d() {
        Matrix A = new Matrix(3);

        A.setElement(0, 0, 3);
        A.setElement(0, 1, 5);
        A.setElement(0, 2, 0);
        A.setElement(1, 0, 2);
        A.setElement(1, 1, -1);
        A.setElement(1, 2, -7);
        A.setElement(2, 0, 6);
        A.setElement(2, 1, -1);
        A.setElement(2, 2, 5);

        assertEquals(25, A.minor(1, 0), EPSILON);
    }

    @Test
    public void MatrixCofactor() {
        Matrix A = new Matrix(3);

        A.setElement(0, 0, 3);
        A.setElement(0, 1, 5);
        A.setElement(0, 2, 0);
        A.setElement(1, 0, 2);
        A.setElement(1, 1, -1);
        A.setElement(1, 2, -7);
        A.setElement(2, 0, 6);
        A.setElement(2, 1, -1);
        A.setElement(2, 2, 5);

        assertEquals(-12, A.cofactor(0, 0), EPSILON);
        assertEquals(-25, A.cofactor(1, 0), EPSILON);
    }

    @Test
    public void MatrixDeterminant3d() {
        Matrix A = new Matrix(3);

        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(0, 2, 6);
        A.setElement(1, 0, -5);
        A.setElement(1, 1, 8);
        A.setElement(1, 2, -4);
        A.setElement(2, 0, 2);
        A.setElement(2, 1, 6);
        A.setElement(2, 2, 4);

        assertEquals(56, A.cofactor(0, 0), EPSILON);
        assertEquals(12, A.cofactor(0, 1), EPSILON);
        assertEquals(-46, A.cofactor(0, 2), EPSILON);
        assertEquals(-196, A.det(), EPSILON);
    }

    @Test
    public void MatrixDeterminant4d() {
        Matrix A = new Matrix(4);

        A.setElement(0, 0, -2);
        A.setElement(0, 1, -8);
        A.setElement(0, 2, 3);
        A.setElement(0, 3, 5);
        A.setElement(1, 0, -3);
        A.setElement(1, 1, 1);
        A.setElement(1, 2, 7);
        A.setElement(1, 3, 3);
        A.setElement(2, 0, 1);
        A.setElement(2, 1, 2);
        A.setElement(2, 2, -9);
        A.setElement(2, 3, 6);
        A.setElement(3, 0, -6);
        A.setElement(3, 1, 7);
        A.setElement(3, 2, 7);
        A.setElement(3, 3, -9);

        assertEquals(690, A.cofactor(0, 0), EPSILON);
        assertEquals(447, A.cofactor(0, 1), EPSILON);
        assertEquals(210, A.cofactor(0, 2), EPSILON);
        assertEquals(51, A.cofactor(0, 3), EPSILON);
        assertEquals(-4071, A.det(), EPSILON);
    }

    @Test
    public void MatrixInvertibilityTrue() {
        Matrix A = new Matrix(4);

        A.setElement(0, 0, 6);
        A.setElement(0, 1, 4);
        A.setElement(0, 2, 4);
        A.setElement(0, 3, 4);
        A.setElement(1, 0, 5);
        A.setElement(1, 1, 5);
        A.setElement(1, 2, 7);
        A.setElement(1, 3, 6);
        A.setElement(2, 0, 4);
        A.setElement(2, 1, -9);
        A.setElement(2, 2, 3);
        A.setElement(2, 3, -7);
        A.setElement(3, 0, 9);
        A.setElement(3, 1, 1);
        A.setElement(3, 2, 7);
        A.setElement(3, 3, -6);

        assertEquals(-2120, A.det(), EPSILON);
        assertTrue(A.isInvertible());
    }

    @Test
    public void MatrixInvertibilityFalse() {
        Matrix A = new Matrix(4);

        A.setElement(0, 0, -4);
        A.setElement(0, 1, 2);
        A.setElement(0, 2, -2);
        A.setElement(0, 3, -3);
        A.setElement(1, 0, 9);
        A.setElement(1, 1, 6);
        A.setElement(1, 2, 2);
        A.setElement(1, 3, 6);
        A.setElement(2, 0, 0);
        A.setElement(2, 1, -5);
        A.setElement(2, 2, 1);
        A.setElement(2, 3, -5);
        A.setElement(3, 0, 0);
        A.setElement(3, 1, 0);
        A.setElement(3, 2, 0);
        A.setElement(3, 3, 0);

        assertEquals(0, A.det(), EPSILON);
        assertFalse(A.isInvertible());
    }

    @Test
    public void MatrixInverse() {
        Matrix A = new Matrix(4);

        A.setElement(0, 0, -5);
        A.setElement(0, 1, 2);
        A.setElement(0, 2, 6);
        A.setElement(0, 3, -8);
        A.setElement(1, 0, 1);
        A.setElement(1, 1, -5);
        A.setElement(1, 2, 1);
        A.setElement(1, 3, 8);
        A.setElement(2, 0, 7);
        A.setElement(2, 1, 7);
        A.setElement(2, 2, -6);
        A.setElement(2, 3, -7);
        A.setElement(3, 0, 1);
        A.setElement(3, 1, -3);
        A.setElement(3, 2, 7);
        A.setElement(3, 3, 4);

        assertEquals(532, A.det(), EPSILON);
        assertEquals(-160, A.cofactor(2,3), EPSILON);
        assertEquals(105, A.cofactor(3,2), EPSILON);

        Matrix B = new Matrix(4);

        B.setElement(0, 0, 0.21805);
        B.setElement(0, 1, 0.45113);
        B.setElement(0, 2, 0.24060);
        B.setElement(0, 3, -0.04511);
        B.setElement(1, 0, -0.80827);
        B.setElement(1, 1, -1.45677);
        B.setElement(1, 2, -0.44361);
        B.setElement(1, 3, 0.52068);
        B.setElement(2, 0, -0.07895);
        B.setElement(2, 1, -0.22368);
        B.setElement(2, 2, -0.05263);
        B.setElement(2, 3, 0.19737);
        B.setElement(3, 0, -0.52256);
        B.setElement(3, 1, -0.81391);
        B.setElement(3, 2, -0.30075);
        B.setElement(3, 3, 0.30639);

        assertTrue(B.equal(A.inverse()));
    }

    @Test
    public void MatrixInverseCheck() {
        Matrix A = new Matrix(4);

        A.setElement(0, 0, 3);
        A.setElement(0, 1, -9);
        A.setElement(0, 2, 7);
        A.setElement(0, 3, 3);
        A.setElement(1, 0, 3);
        A.setElement(1, 1, -8);
        A.setElement(1, 2, 2);
        A.setElement(1, 3, -9);
        A.setElement(2, 0, -4);
        A.setElement(2, 1, 4);
        A.setElement(2, 2, 4);
        A.setElement(2, 3, 1);
        A.setElement(3, 0, -6);
        A.setElement(3, 1, 5);
        A.setElement(3, 2, -1);
        A.setElement(3, 3, 1);

        Matrix B = new Matrix(4);

        B.setElement(0, 0, 8);
        B.setElement(0, 1, 2);
        B.setElement(0, 2, 2);
        B.setElement(0, 3, 2);
        B.setElement(1, 0, 3);
        B.setElement(1, 1, -1);
        B.setElement(1, 2, 7);
        B.setElement(1, 3, 0);
        B.setElement(2, 0, 7);
        B.setElement(2, 1, 0);
        B.setElement(2, 2, 5);
        B.setElement(2, 3, 4);
        B.setElement(3, 0, 6);
        B.setElement(3, 1, -2);
        B.setElement(3, 2, 0);
        B.setElement(3, 3, 5);

        Matrix C = A.mul(B);

        assertTrue(A.equal(C.mul(B.inverse())));
    }
}