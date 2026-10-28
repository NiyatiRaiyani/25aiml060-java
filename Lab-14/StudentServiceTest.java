
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    void testAddStudent() {
        StudentService service = new StudentService();

        assertEquals(0, service.getStudentCount());

        service.addStudent(new Student(101, "Amit"));

        assertEquals(1, service.getStudentCount());
    }

    @Test
    void testInvalidAction() {
        StudentService service = new StudentService();

        assertThrows(IllegalArgumentException.class,
            () -> service.performAction("DELETE"));
    }

    @Test
    void testStudentDetails() {
        StudentService service = new StudentService();
        service.addStudent(new Student(102, "Riya"));

        Student student = service.getAllStudents().get(0);

        assertEquals(102, student.getId());
        assertEquals("Riya", student.getName());
    }
}
