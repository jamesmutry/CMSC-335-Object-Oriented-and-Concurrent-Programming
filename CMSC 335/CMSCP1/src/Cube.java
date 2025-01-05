public class Cube extends Shape implements ThreeDimensionalShape {
    private double side;

    public Cube(double side) {
        super(3);
        this.side = side;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }
}


