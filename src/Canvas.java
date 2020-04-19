import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Canvas {
    private int width;
    private int height;
    private Color[][] colors;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        colors = new Color[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                colors[i][j] = new Color(0.0, 0.0, 0.0);
            }
        }
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public Color getPixel(int i, int j) {
        return colors[i][j];
    }

    public void setPixel(int i, int j, Color color) {
        colors[i][j] = new Color(color);
    }

    public void saveImage(String filename) {
        File image = new File(filename);
        BufferedImage buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                float red = (float) colors[x][y].red();
                float green = (float) colors[x][y].green();
                float blue = (float) colors[x][y].blue();
                int color = new java.awt.Color(red, green, blue).getRGB();
                buffer.setRGB(y, x, color);
            }
        }

        try {
            ImageIO.write(buffer, "PNG", image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
