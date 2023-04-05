package lab2;

public class TriangleFactory implements ShapeFactory {
    private double side;

    public TriangleFactory(double side) {
        this.side = side;
    }

    @Override
    public Shape createShape(double side) {
        return new Triangle(side);
    }

    @Override
    public void displayShapeInfo(Shape shape) {
        if (shape instanceof Triangle) {
            double side = ((Triangle) shape).getSide();
            double area = Math.round((Math.sqrt(3) / 4) * Math.pow(side, 2) * 100.0) / 100.0;
            System.out.println("Triangle with side " + side + " has an area of " + area + " square units.");
        } else {
            System.out.println("Invalid shape type");
        }
    }
}
