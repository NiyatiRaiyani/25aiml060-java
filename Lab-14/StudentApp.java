
import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n===== Student Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student ID: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID.");
                        sc.nextLine();
                        continue;
                    }

                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        continue;
                    }

                    service.addStudent(new Student(id, name));
                    System.out.println("Student added successfully.");
                }

                case 2 -> {
                    if (service.getAllStudents().isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\n===== Student List =====");

                        for (Student student : service.getAllStudents()) {
                            System.out.println(student);
                        }
                    }
                }

                case 3 -> {
                    System.out.println("Application closed.");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
