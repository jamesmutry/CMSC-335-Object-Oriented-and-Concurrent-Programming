public class Triangle extends Shape implements TwoDimensionalShape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super(2);
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}
