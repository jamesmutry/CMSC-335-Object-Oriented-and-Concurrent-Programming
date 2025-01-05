//Base class for shape
abstract class Shape {
    private int numberOfDimensions;
    private int area;

    public Shape(int numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }

    public int getNumberOfDimensions() {
        return numberOfDimensions;
    }
}
