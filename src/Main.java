public class Main {
    public static void main(String[] args) {
        int size = 64;
        Canvas canvas = new Canvas(size, size);
        for (int y = 0; y < canvas.height(); y++) {
            for (int x = 0; x < canvas.width(); x++) {
                if (x == y) {
                    double color = 1 - (double) x / size;
                    canvas.setPixel(x, y, new Color(color, color, color));
                } else if (x <= y) {
                    canvas.setPixel(x, y, new Color(1 - (double) x / size, 0, 0));
                } else {
                    canvas.setPixel(x, y, new Color(0, 0, 1 - (double) y / size));
                }
            }
        }
        canvas.saveImage("image.png");
    }
}
