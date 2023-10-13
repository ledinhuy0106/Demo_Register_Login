import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileObj {
    public static final String FILENAME = "user.txt";

    public static void writeDataToFile(List<User> userList) {
        File file = new File(FILENAME);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userList);
            objectOutputStream.close();

        } catch (IOException e) {
            System.out.println("Lỗi!!");
        }
    }

    public static List<User> readDataFromFileToList() {
        List<User> list = new ArrayList<>();
        File file = new File(FILENAME);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (List<User>) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {

        } catch (FileNotFoundException e) {

        }
        catch (IOException e) {
            System.out.println("Lỗi!!");
        }
        return list;
    }
}
