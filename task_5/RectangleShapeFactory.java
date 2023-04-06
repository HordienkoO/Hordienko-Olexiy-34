package lab2;

public class RectangleShapeFactory implements ShapeFactory {
    private double side;

    public RectangleShapeFactory(double side) {
        this.side = side;
    }

    @Override
    public Shape createShape(double side) {
        return new Rectangle(side);
    }

    @Override
    public void displayShapeInfo(Shape shape) {
        if (shape instanceof Rectangle) {
            double side = ((Rectangle) shape).getSideLength();
            double area = Math.round(Math.pow(side, 2) * 100.0) / 100.0;
            System.out.println("Rectangle with side " + side + " has an area of " + area + " square units.");
        } else {
            System.out.println("Invalid shape type");
        }
    }
}
