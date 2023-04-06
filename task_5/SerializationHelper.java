import java.io.*;

public class SerializationHelper {
    
    public static void serialize(Object obj, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("Об'єкт успішно збережено у файл " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Object deserialize(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object obj = in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Об'єкт успішно відновлено з файлу " + filename);
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}