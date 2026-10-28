class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Pair<A, B> {
    private A first;
    @SuppressWarnings("FieldMayBeFinal")
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public Pair() {
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}

public class GenericContainer {

    // Generic method to return the first array element
    public static <T> T firstElement(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[0];
    }

    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(100);

        Box<String> strBox = new Box<>();
        strBox.set("Java Programming");

        Pair<String, Integer> student =
            new Pair<>("Niyati", 20);

        String[] names = {"Kavya", "Anaya", "Nayana"};

        System.out.println("Integer Box: " + intBox.get());
        System.out.println("String Box: " + strBox.get());
        System.out.println("Student Name: " + student.getFirst());
        System.out.println("Student Age: " + student.getSecond());
        System.out.println("First Name: " + firstElement(names));
    }
}