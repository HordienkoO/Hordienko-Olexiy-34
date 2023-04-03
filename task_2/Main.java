import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        // Створення об'єкту Geometry та розрахунок площ
        Geometry geometry = new Geometry(1010101);
        geometry.calculateAreas();

        // Серіалізація об'єкту Geometry до файлу geometry.ser
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

        // Десеріалізація об'єкту Geometry з файлу geometry.ser та виведення розрахунків на екран
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
