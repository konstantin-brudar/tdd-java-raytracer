import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Matrix {
    private int size;
    private double[][] matrix;

    public Matrix(int size) {
        this.size = size;
        matrix = new double[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = 0.0;
            }
        }
    }

    public int size() {
        return size;
    }

    public double getElement(int row, int col) {
        return matrix[row][col];
    }

    public void setElement(int row, int col, double value) {
        matrix[row][col] = value;
    }

    public boolean equal(Matrix matrix) {
        boolean areEqual = true;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (this.matrix[row][col] != matrix.getElement(row, col)) {
                    areEqual = false;
                    break;
                }
            }
            if (!areEqual) {
                break;
            }
        }

        return areEqual;
    }

    public Matrix mul(Matrix matrix) {
        Matrix result = new Matrix(size);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                double sum = 0.0;
                for (int i = 0; i < size; i++) {
                    sum += this.matrix[row][i] * matrix.getElement(i, col);
                }
                result.setElement(row, col, sum);
            }
        }

        return result;
    }

    public Tuple mul(Tuple tuple) {
        Tuple result = new Tuple(0, 0, 0, 0);

        result.x = this.matrix[0][0] * tuple.x + this.matrix[0][1] * tuple.y + this.matrix[0][2] * tuple.z + this.matrix[0][3] * tuple.w;
        result.y = this.matrix[1][0] * tuple.x + this.matrix[1][1] * tuple.y + this.matrix[1][2] * tuple.z + this.matrix[1][3] * tuple.w;
        result.z = this.matrix[2][0] * tuple.x + this.matrix[2][1] * tuple.y + this.matrix[2][2] * tuple.z + this.matrix[2][3] * tuple.w;
        result.w = this.matrix[3][0] * tuple.x + this.matrix[3][1] * tuple.y + this.matrix[3][2] * tuple.z + this.matrix[3][3] * tuple.w;

        return result;
    }
}
