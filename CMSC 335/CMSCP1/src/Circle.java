public class Circle extends Shape implements TwoDimensionalShape {
    private double radius;

    public Circle(double radius){
        super(2);
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
