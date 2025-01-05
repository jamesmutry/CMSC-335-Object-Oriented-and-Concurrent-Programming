public class Rectangle extends Shape implements TwoDimensionalShape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super(2);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}
