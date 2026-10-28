
import java.util.Scanner;

import javax.print.StreamPrintService;

public class StudentApp {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StreamPrintService();

        OUTER:
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
                    }                      sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        continue;
                    }   service.addStudent(new Student());
                    System.out.println("Student added successfully.");
                }

                case 2 -> {
                    if (service.getAllStudents().isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student student : service.getAllStudents()) {
                            System.out.println(student);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Application closed.");
                    break OUTER;
                }
                default -> System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
