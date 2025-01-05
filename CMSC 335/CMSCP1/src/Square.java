public class Square extends Shape implements TwoDimensionalShape {
    private double side;

    public Square(double side) {
        super(2);
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}

