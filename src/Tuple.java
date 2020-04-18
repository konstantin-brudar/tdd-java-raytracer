public class Tuple {
    public double x, y, z, w;

    public Tuple(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public boolean isPoint() {
        return w == 1.0;
    }

    public boolean isVector() {
        return w == 0.0;
    }

    public boolean equal(Tuple tuple) {
        return Operation.equal(tuple.x, x) &&
                Operation.equal(tuple.y, y) &&
                Operation.equal(tuple.z, z) &&
                Operation.equal(tuple.w, w);
    }

    public Tuple add(Tuple tuple) {
        return new Tuple(x + tuple.x, y + tuple.y, z + tuple.z, w + tuple.w);
    }

    public Tuple sub(Tuple tuple) {
        return new Tuple(x - tuple.x, y - tuple.y, z - tuple.z, w - tuple.w);
    }

    public Tuple negate() {
        return new Tuple(-x, -y, -z, -w);
    }

    public Tuple mul(double number) {
        return new Tuple(x * number, y * number, z * number, w * number);
    }

    public Tuple div(double number) {
        return new Tuple(x / number, y / number, z / number, w / number);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z + w * w);
    }

    public Tuple normalize() {
        double magnitude = magnitude();
        return new Tuple(x / magnitude, y / magnitude, z / magnitude, w / magnitude);
    }

    public double dot(Tuple tuple) {
        return x * tuple.x + y * tuple.y + z * tuple.z + w * tuple.w;
    }

    public Tuple cross(Tuple tuple) {
        double a = y * tuple.z - z * tuple.y;
        double b = z * tuple.x - x * tuple.z;
        double c = x * tuple.y - y * tuple.x;
        return new Tuple(a, b, c, 0);
    }
}
