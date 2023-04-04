import java.io.Serializable;

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

        triangleArea = 0.5 * sideLength * height;
        rectangleArea = sideLength * sideLength;
    }
}
