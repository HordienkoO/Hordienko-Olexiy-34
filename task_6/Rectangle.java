package lab2;

public class Rectangle extends Shape {
    private double sideLength;
    private double rectangleArea;

    public Rectangle(double sideLength) {
        this.sideLength = sideLength;
    }

  public void calculateArea() {
    if (this.sideLength > 0) {
        this.rectangleArea = Math.pow(this.sideLength, 2);
    } else {
        this.rectangleArea = 0;
    }
}


    @Override
    public double getArea() {
        return this.rectangleArea;
    }

    public double getSideLength() {
        return this.sideLength;
    }
    
    public static class Factory implements ShapeFactory {
        @Override
        public Shape createShape(double side) {
            return new Rectangle(side);
        }

        @Override
        public void displayShapeInfo(Shape shape) {
            Rectangle rectangle = (Rectangle) shape;
            rectangle.calculateArea();
            System.out.println("Rectangle with side length " + rectangle.getSideLength() +
                    " has area " + rectangle.getArea());
        }
    }
}