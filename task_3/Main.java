import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the side length in binary number system:");
    int sideLength = scanner.nextInt(2); // read the side length as binary number
    scanner.close();

        // створення об'єкту Geometry та розрахунок площ
        Geometry geometry = new Geometry(sideLength);
        geometry.calculateAreas();

        // серіалізація об'єкту Geometry до файлу geometry.ser
        serializeGeometry(geometry);

        // десеріалізація об'єкту Geometry з файлу geometry.ser та виведення результатів на екран
        deserializeGeometry();
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
