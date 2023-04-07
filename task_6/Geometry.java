import java.io.Serializable;
import lab2.Triangle;
import lab2.Rectangle;
import lab2.Square;

public class Geometry implements Serializable {
    private int sideLength;
    private double triangleArea;
    private double rectangleArea;
    private Square square;

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
    double rectangleSideLength = Math.sqrt(3) / 2 * sideLength;
    return rectangleSideLength * sideLength;
}


    public Square getSquare() {
        return square;
    }

    public double getTotalArea() {
        return triangleArea + rectangleArea + square.getArea();
    }

    public void calculateAreas() {
        double height = Math.sqrt(3) / 2 * sideLength;

        Triangle triangle = new Triangle(sideLength);
        Rectangle rectangle = new Rectangle(sideLength);
        Square square = new Square(sideLength);
        triangleArea = triangle.getArea();
        rectangleArea = rectangle.getArea();
        this.square = square;
    }

    public void calculateAreas(int rectangleSideLength) {
 
        double height = Math.sqrt(3) / 2 * sideLength;

        Triangle triangle = new Triangle(sideLength);
        Rectangle rectangle = new Rectangle(sideLength);

        Square square = new Square(sideLength);
        triangleArea = triangle.getArea();
        rectangleArea = rectangle.getArea();
        this.square = square;
}

}
