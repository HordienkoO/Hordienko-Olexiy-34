package lab2;

public class Rectangle {
    private double sideLength;
    private double rectangleArea;

    public Rectangle(double sideLength) {
        this.sideLength = sideLength;
    }

    public void calculateArea() {
        this.rectangleArea = Math.pow(this.sideLength, 2);
    }

    public double getArea() {
        return this.rectangleArea;
    }

    public double getSideLength() {
        return this.sideLength;
    }
}
