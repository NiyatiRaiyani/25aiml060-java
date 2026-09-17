class MyResource implements AutoCloseable {

    MyResource() {
        System.out.println("Resource opened");
    }

    void use() {
        System.out.println("Using resource");
        throw new RuntimeException("Something went wrong!");
    }

    @Override
    public void close() {
        System.out.println("Resource closed");
    }
}

public class AutoCloseDemo {

    public static void main(String[] args) {

        try (MyResource r = new MyResource()) {

            r.use();

        } catch (RuntimeException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}