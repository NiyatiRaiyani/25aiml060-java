
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException(
                "Student cannot be null");
        }
        students.add(student);
    }

    public int getStudentCount() {
        return students.size();
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void performAction(String action) {
        if (!"ADD".equals(action) && !"LIST".equals(action)) {
            throw new IllegalArgumentException(
                "Invalid action: " + action);
        }
    }
}
