public class Cylinder extends Shape implements ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        super(3);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}


