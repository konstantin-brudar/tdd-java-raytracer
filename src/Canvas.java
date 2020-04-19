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
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                colors[y][x] = new Color(0.0, 0.0, 0.0);
            }
        }
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public Color getPixel(int x, int y) {
        return colors[y][x];
    }

    public void setPixel(int x, int y, Color color) {
        colors[y][x] = new Color(color);
    }

    public void saveImage(String filename) {
        File image = new File(filename);
        BufferedImage buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                float red = (float) colors[y][x].red();
                float green = (float) colors[y][x].green();
                float blue = (float) colors[y][x].blue();
                int color = new java.awt.Color(red, green, blue).getRGB();
                buffer.setRGB(x, y, color);
            }
        }

        try {
            ImageIO.write(buffer, "PNG", image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
