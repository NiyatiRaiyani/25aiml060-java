import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {

    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "age")
    int age;

    public void display() {
        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
        System.out.println("Age   : " + age);
    }
}

public class ColumnMapper {

    public static Student createStudent(
            String[] headers,
            String[] data) throws Exception {

        Student student = new Student();

        // Store header and data together
        Map<String, String> values = new HashMap<>();

        for (int i = 0; i < headers.length; i++) {
            values.put(headers[i], data[i]);
        }

        Field[] fields = Student.class.getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Column.class)) {

                Column column = field.getAnnotation(Column.class);

                String columnName = column.name();

                if (values.containsKey(columnName)) {

                    String value = values.get(columnName);

                    field.setAccessible(true);

                    if (field.getType() == String.class) {
                        field.set(student, value);
                    }

                    else if (field.getType() == int.class) {
                        field.setInt(student, Integer.parseInt(value));
                    }
                }

                else {
                    System.out.println(
                            "Missing column: " + columnName);
                }
            }
        }

        return student;
    }

    public static void main(String[] args) throws Exception {

        String[] headers = {
            "name",
            "email",
            "age"
        };

        String[] data = {
            "Niyati",
            "niyatiraiyani42@gmail.com",
            "18"
        };

        Student student = createStudent(headers, data);

        student.display();
    }
}