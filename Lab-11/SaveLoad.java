
import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    transient String password;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}

public class SaveLoad {
    public static void main(String[] args) {
        Student[] students = {
            new Student(101, "Niyati", "pass@123"),
            new Student(102, "Radha", "pass#@456")
        };

        // Serialize objects
        try (ObjectOutputStream out =
                 new ObjectOutputStream(
                     new FileOutputStream("students.dat"))) {

            out.writeObject(students);
            System.out.println("Objects saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving objects: "
                               + e.getMessage());
            return;
        }

        // Deserialize objects
        try (ObjectInputStream in =
                 new ObjectInputStream(
                     new FileInputStream("students.dat"))) {

            Student[] data = (Student[]) in.readObject();

            System.out.println("\nStudent Details:");
            for (Student s : data) {
                System.out.println("ID: " + s.id);
                System.out.println("Name: " + s.name);
                System.out.println("Password: " + s.password);
                System.out.println();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading objects: "
                               + e.getMessage());
        }
    }
}
