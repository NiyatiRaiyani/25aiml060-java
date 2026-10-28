class GenericStack<T> {
    private Object[] elements;
    private int top;

    public GenericStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "Capacity must be positive.");
        }

        elements = new Object[capacity];
        top = -1;
    }

    public void push(T value) {
        if (top == elements.length - 1) {
            System.out.println("Stack Overflow!");
            return;
        }

        elements[++top] = value;
        System.out.println("Pushed: " + value);
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return null;
        }

        T value = (T) elements[top];
        elements[top] = null;
        top--;

        return value;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack elements:");

        for (int i = top; i >= 0; i--) {
            System.out.println(elements[i]);
        }
    }
}

public class GenericStackDemo {
    public static void main(String[] args) {
        GenericStack<Integer> numbers = new GenericStack<>(5);

        numbers.push(10);
        numbers.push(20);
        numbers.push(30);
        numbers.display();

        System.out.println("Popped: " + numbers.pop());

        GenericStack<String> names = new GenericStack<>(3);

        names.push("Kavya");
        names.push("Anaya");
        names.push("Nayana");
        
        names.display();

        System.out.println("Popped: " + names.pop());
    }
}
