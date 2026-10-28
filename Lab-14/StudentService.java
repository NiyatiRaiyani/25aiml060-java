import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public int getStudentCount() {
        return students.size();
    }

    public void performAction(String action) {
        if (action == null ||
            (!action.equalsIgnoreCase("ADD") &&
             !action.equalsIgnoreCase("LIST"))) {
            throw new IllegalArgumentException("Invalid action");
        }
    }
}