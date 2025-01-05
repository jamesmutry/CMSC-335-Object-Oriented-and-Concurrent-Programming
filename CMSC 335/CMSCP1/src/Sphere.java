public class Sphere extends Shape implements ThreeDimensionalShape {
    private double radius;

    public Sphere(double radius) {
        super(3);
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}

