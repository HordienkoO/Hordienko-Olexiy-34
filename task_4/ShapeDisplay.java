package lab2;

public class ShapeDisplay {
    private ShapeFactory factory;
    private Shape shape;

    public ShapeDisplay(ShapeFactory factory) {
        this.factory = factory;
    }

    public void setShape(double side) {
        shape = factory.createShape(side);
    }

    public void displayShapeInfo() {
        if (shape != null) {
            factory.displayShapeInfo(shape);
        } else {
            System.out.println("No shape has been created yet.");
        }
    }
}
