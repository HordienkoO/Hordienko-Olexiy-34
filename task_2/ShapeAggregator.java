package lab2;

import java.util.ArrayList;
import java.util.List;

public class ShapeAggregator {
    private List<Shape> shapes;

    public ShapeAggregator() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }
}






