public class Cone extends Shape implements ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        super(3);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }
}
