public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas(1600, 900);
        for (int i = 0; i < canvas.height(); i++) {
            for (int j = 0; j < canvas.width(); j++) {
                double z = (double) i / (i + j);
                canvas.setPixel(i, j, new Color(z, 0, 0));
            }
        }
        canvas.saveImage("image.png");
    }
}
