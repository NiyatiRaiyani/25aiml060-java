class Counter {
    private int count = 0;

    // Synchronized method 
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            counter.increment();
        }
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }
}

public class CounterRace {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);
        Thread t3 = new CounterThread(counter);
        Thread t4 = new CounterThread(counter);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Expected Count : 40000");
        System.out.println("Actual Count   : " + counter.getCount());
    }
}