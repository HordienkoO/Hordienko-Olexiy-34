package lab2;

import java.util.List;

public class TableDisplay {
    private List<Shape> shapes;

    public TableDisplay(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public void display() {
        System.out.println("+----------------------+----------------------+");
        System.out.println("| Shape                | Area                 |");
        System.out.println("+----------------------+----------------------+");
        for (Shape shape : shapes) {
            System.out.printf("| %-20s| %-20f|\n", shape.getClass().getSimpleName(), shape.getArea());
            System.out.println("+----------------------+----------------------+");
            if (shape instanceof Rectangle) {
                System.out.printf("| %-20s| %-20f|\n", "Width", ((Rectangle) shape).getSideLength());
                System.out.println("+----------------------+----------------------+");
            }
        }
    }
}
