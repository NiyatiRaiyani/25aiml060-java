public class DeadlockPrevention {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        System.out.println("Deadlock Prevention\n");

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();

            synchronized (lock1) {
                System.out.println(threadName + " acquired Lock 1");

                synchronized (lock2) {
                    System.out.println(threadName + " acquired Lock 2");
                    System.out.println(threadName + " completed successfully\n");
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Execution completed without deadlock.");
    }
}