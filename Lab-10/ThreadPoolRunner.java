import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolRunner {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(3);

        System.out.println("\nNotice: Demonstration of Thread Pool using 3 threads.\n");
        
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;

            pool.submit(() -> { String threadName = Thread.currentThread().getName();

                System.out.println("Task " + taskId + " is running on " + threadName);

                try 
                {
                    Thread.sleep(500);
                } 
                catch (InterruptedException e) 
                {
                    Thread.currentThread().interrupt();
                    return;
                }

                System.out.println("Task " + taskId + " completed by " + threadName);
            });
        }

        pool.shutdown();

        try {
            if (pool.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("\nAll tasks completed.");
            } else {
                System.out.println("\nSome tasks are still running.");
                pool.shutdownNow();
            }
        } catch (InterruptedException e) 
        {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("\nNotice: A fixed thread pool of 3 threads executes 10 tasks, and threads are reused.\n");
    }
}