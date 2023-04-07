import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import lab2.Menu;
import lab2.SuccessMessage;


public class Main {
    
    public static void main(String[] args) {
        Menu menu = Menu.getInstance();
        menu.showMenu();

        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        menu.handleCommand(command);

        System.out.println("Enter the side length in binary number system:");
        int sideLength = scanner.nextInt(2);
        scanner.close();
        
        Geometry geometry = new Geometry(sideLength);
        geometry.calculateAreas();
        
        serializeGeometry(geometry);

        deserializeGeometry();

        double minValue = geometry.getTriangleArea() < geometry.getRectangleArea() ? geometry.getTriangleArea() : geometry.getRectangleArea();
        double maxValue = geometry.getTriangleArea() > geometry.getRectangleArea() ? geometry.getTriangleArea() : geometry.getRectangleArea();
        double avgValue = (geometry.getTriangleArea() + geometry.getRectangleArea()) / 2.0;

        double[] areas = { geometry.getTriangleArea(), geometry.getRectangleArea() };
        double mean = avgValue;
        double sum = 0;
        for (double area : areas) {
            sum += Math.pow(area - mean, 2);
        }
        double sd = Math.sqrt(sum / areas.length);

        System.out.println("Minimum value: " + minValue);
        System.out.println("Maximum value: " + maxValue);
        System.out.println("Average value: " + avgValue);
        System.out.println("Standard deviation: " + sd);
        SuccessMessage successMessage = new SuccessMessage();
        successMessage.display();
        System.out.println("END");
    }
    
    

    public static void serializeGeometry(Geometry geometry) {
        try {
            FileOutputStream fileOut = new FileOutputStream("geometry.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(geometry);
            out.close();
            fileOut.close();
            System.out.println("Object successfully saved to file geometry.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeGeometry() {
        try {
            FileInputStream fileIn = new FileInputStream("geometry.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Geometry deserializedGeometry = (Geometry) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Object successfully restored from file geometry.ser");

            System.out.println("Side length: " + deserializedGeometry.getSideLength());
            System.out.println("Equilateral triangle area: " + deserializedGeometry.getTriangleArea());
            System.out.println("Square area: " + deserializedGeometry.getRectangleArea());
            System.out.println("Total area: " + deserializedGeometry.getTotalArea());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
