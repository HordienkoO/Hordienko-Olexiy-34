import java.io.Serializable;
import lab2.Triangle;
import lab2.Rectangle;

public class Geometry implements Serializable {
    private int sideLength;
    private double triangleArea;
    private double rectangleArea;

    public Geometry(int sideLength) {
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public double getTriangleArea() {
        return triangleArea;
    }

    public double getRectangleArea() {
        return rectangleArea;
    }

    public double getTotalArea() {
        return triangleArea + rectangleArea;
    }

    public void calculateAreas() {
        double height = Math.sqrt(3) / 2 * sideLength;

        Triangle triangle = new Triangle(sideLength);
        Rectangle rectangle = new Rectangle(sideLength);
        triangleArea = triangle.getArea();
        rectangleArea = rectangle.getArea();
    }

    // overload calculateAreas() method to accept a custom side length for rectangle
    public void calculateAreas(int rectangleSideLength) {
        double height = Math.sqrt(3) / 2 * sideLength;

        Triangle triangle = new Triangle(sideLength);
        Rectangle rectangle = new Rectangle(rectangleSideLength);
        triangleArea = triangle.getArea();
        rectangleArea = rectangle.getArea();
    }
}
