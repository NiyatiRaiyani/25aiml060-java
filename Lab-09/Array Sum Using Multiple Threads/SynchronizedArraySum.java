class SafeSum {
    private int total = 0;

    public synchronized void add(int value) {
        total += value;
    }

    public int getTotal() {
        return total;
    }
}

class SafeSumThread extends Thread {
    private int[] numbers;
    private int start;
    private int end;
    private SafeSum sum;

    public SafeSumThread(int[] numbers, int start,
                         int end, SafeSum sum) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
        this.sum = sum;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum.add(numbers[i]);
        }
    }

    public SafeSum getSum() {
        return sum;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public void setSum(SafeSum sum) {
        this.sum = sum;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

public class SynchronizedArraySum {
    public static void main(String[] args)
            throws InterruptedException {

        int[] numbers = new int[100000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 1;
        }

        SafeSum sum = new SafeSum();

        int threadCount = 4;
        int part = numbers.length / threadCount;

        Thread[] threads = new Thread[threadCount];

        long startTime = System.nanoTime();

        for (int i = 0; i < threadCount; i++) {

            int start = i * part;
            int end = (i == threadCount - 1)
                    ? numbers.length
                    : start + part;

            threads[i] = new SafeSumThread(
                numbers, start, end, sum
            );

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long endTime = System.nanoTime();

        System.out.println("Final Sum : " + sum.getTotal());
        System.out.println("Execution Time : "
                + (endTime - startTime) + " ns");
    }
}