public class Torus extends Shape implements ThreeDimensionalShape {
    private double majorRadius;
    private double minorRadius;

    public Torus(double majorRadius, double minorRadius) {
        super(3);
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    @Override
    public double getVolume() {
        return (Math.PI * Math.pow(minorRadius, 2)) * (2 * Math.PI * majorRadius);
    }
}

