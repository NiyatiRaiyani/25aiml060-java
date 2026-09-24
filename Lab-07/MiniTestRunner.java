import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

class MyTests {

    @Run
    public void testLogin() {
        System.out.println("Running testLogin");
    }

    @Run
    public void testSignup() {
        System.out.println("Running testSignup");
    }

    public void normalMethod() {
        System.out.println("This method should not run");
    }

    @Run
    public void testPayment() {
        System.out.println("Running testPayment");
    }
}

public class MiniTestRunner {

    public static void main(String[] args) {

        MyTests testObject = new MyTests();

        int count = 0;

        Method[] methods = MyTests.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Run.class)
                    && method.getParameterCount() == 0) {

                try {
                    method.invoke(testObject);
                    count++;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.out.println("Error running "
                            + method.getName());
                }
            }
        }

        System.out.println("Total @Run methods executed: " + count);
    }
}