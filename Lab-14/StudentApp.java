
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        StudentService service = new StudentService();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Student Management ---");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input.");
                    sc.nextLine();
                    continue;
                }

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid ID.");
                            sc.nextLine();
                            break;
                        }

                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine().trim();

                        if (name.isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            break;
                        }

                        service.addStudent(new Student(id, name));
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        System.out.println("Total Students: "
                                           + service.getStudentCount());

                        for (Student s : service.getAllStudents()) {
                            System.out.println(s);
                        }
                        break;

                    case 3:
                        System.out.println("Program terminated.");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }
}
