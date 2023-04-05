import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GeometryTest {
    private static final double DELTA = 1e-15;
    private Geometry geometry;
    
    public void setUp() {
        geometry = new Geometry(10);
        geometry.calculateAreas();
    }

    public void testTriangleArea() {
        double expected = 43.30127018922193;
        if (Math.abs(expected - geometry.getTriangleArea()) < DELTA) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }
    
    public void testRectangleArea() {
        double expected = 100.0;
        if (Math.abs(expected - geometry.getRectangleArea()) < DELTA) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }
    
    public void testTotalArea() {
        double expected = 143.30127018922193;
        if (Math.abs(expected - geometry.getTotalArea()) < DELTA) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }
    
    public void testSerialization() {
        try {
            FileOutputStream fileOut = new FileOutputStream("geometry.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(geometry);
            out.close();
            fileOut.close();
            
            FileInputStream fileIn = new FileInputStream("geometry.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Geometry deserializedGeometry = (Geometry) in.readObject();
            in.close();
            fileIn.close();
            
            if (Math.abs(geometry.getSideLength() - deserializedGeometry.getSideLength()) < DELTA) {
                System.out.println("Side length test passed.");
            } else {
                System.out.println("Side length test failed.");
            }
            if (Math.abs(geometry.getTriangleArea() - deserializedGeometry.getTriangleArea()) < DELTA) {
                System.out.println("Triangle area test passed.");
            } else {
                System.out.println("Triangle area test failed.");
            }
            if (Math.abs(geometry.getRectangleArea() - deserializedGeometry.getRectangleArea()) < DELTA) {
                System.out.println("Rectangle area test passed.");
            } else {
                System.out.println("Rectangle area test failed.");
            }
            if (Math.abs(geometry.getTotalArea() - deserializedGeometry.getTotalArea()) < DELTA) {
                System.out.println("Total area test passed.");
            } else {
                System.out.println("Total area test failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
