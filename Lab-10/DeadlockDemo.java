public class DeadlockDemo {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        System.out.println("Deadlock Demonstration\n");

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 acquired Lock 1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                System.out.println("Thread 1 waiting for Lock 2");

                synchronized (lock2) {
                    System.out.println("Thread 1 acquired Lock 2");
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 acquired Lock 2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                System.out.println("Thread 2 waiting for Lock 1");

                synchronized (lock1) {
                    System.out.println("Thread 2 acquired Lock 1");
                }
            }
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}