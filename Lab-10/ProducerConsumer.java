import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {

    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 3;
    private boolean productionFinished = false;

    public synchronized void produce(int item)
            throws InterruptedException {

        while (buffer.size() == capacity) {
            wait();
        }

        buffer.add(item);
        System.out.println("Produced item: " + item);

        if (buffer.size() == capacity || item == 10) {
            System.out.println("(" + buffer.size() + " items produced)\n");
        }

        notifyAll();
    }

    public synchronized void consumeBatch()
            throws InterruptedException {

        while (buffer.size() < capacity && !productionFinished) {
            wait();
        }

        if (buffer.isEmpty()) {
            return;
        }

        int count = buffer.size();

        for (int i = 0; i < count; i++) {
            System.out.println("Consumed item: " + buffer.remove());
        }

        System.out.println("(" + count + " items consumed)\n");

        notifyAll();
    }

    public synchronized void finishProduction() {
        productionFinished = true;
        notifyAll();
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
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                buffer.finishProduction();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 4; i++) {
                    buffer.consumeBatch();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Producer-Consumer Problem Completed");
        System.out.println("\nObservation: wait() and notifyAll() coordinate both threads.");
    }
}