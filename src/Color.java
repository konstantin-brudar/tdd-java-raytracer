public class Color extends Tuple {
    public Color(double red, double green, double blue) {
        super(red, green, blue, 0.0);
    }

    public Color(Color color) {
        super(color.red(), color.green(), color.blue(), 0.0);
    }

    public double red() {
        return x;
    }

    public double green() {
        return y;
    }

    public double blue() {
        return z;
    }
}
