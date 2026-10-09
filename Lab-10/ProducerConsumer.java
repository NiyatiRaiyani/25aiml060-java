import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {

    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 3;

    public synchronized void produce(int item)
        throws InterruptedException {

        while (buffer.size() == capacity) {
            wait();
        }

        buffer.add(item);
        System.out.println("Produced item: " + item);

        notify();
    }

    public synchronized int consume()
            throws InterruptedException {

        while (buffer.isEmpty()) {
            wait();
        }

        int item = buffer.remove();
        System.out.println("Consumed item: " + item);

        notify();
        return item;
    }
}

public class ProducerConsumer {

    public static void main(String[] args) {

        System.out.println("\nProducer-Consumer Problem Started\n");

        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.consume();
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nProducer-Consumer Problem Completed\n");
    }
}