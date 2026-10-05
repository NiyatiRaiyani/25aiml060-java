class LocalSumThread extends Thread {
    private int[] numbers;
    private int start;
    private int end;
    private int localSum = 0;

    public LocalSumThread(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            localSum += numbers[i];
        }
    }

    public int getLocalSum() {
        return localSum;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public void setStart(int start) {
        this.start = start;
    }
}

public class LocalArraySum {
    public static void main(String[] args)
            throws InterruptedException {

        int[] numbers = new int[100000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 1;
        }

        int threadCount = 4;
        int part = numbers.length / threadCount;

        LocalSumThread[] threads =
                new LocalSumThread[threadCount];

        long startTime = System.nanoTime();

        for (int i = 0; i < threadCount; i++) {

            int start = i * part;
            int end = (i == threadCount - 1)
                    ? numbers.length
                    : start + part;

            threads[i] = new LocalSumThread(
                numbers, start, end
            );

            threads[i].start();
        }

        int finalSum = 0;

        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
            finalSum += threads[i].getLocalSum();
        }

        long endTime = System.nanoTime();

        System.out.println("Final Sum : " + finalSum);
        System.out.println("Execution Time : "
                + (endTime - startTime) + " ns");
    }
}