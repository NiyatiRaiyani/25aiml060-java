class ArraySumThread extends Thread 
{
    private int[] numbers;
    private int start;
    private int end;

    static int total = 0;

    public ArraySumThread(int[] numbers, int start, int end) 
    {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() 
    {
        for (int i = start; i < end; i++) 
        {
            total += numbers[i];
        }
    }

    public int[] getNumbers() 
    {
        return numbers;
    }

    public int getStart() 
    {
        return start;
    }

    public void setStart(int start) 
    {
        this.start = start;
    }

    public void setNumbers(int[] numbers) 
    {
        this.numbers = numbers;
    }

    public void setEnd(int end) 
    {
        this.end = end;
    }
}

public class ArraySumRace 
{
    public static void main(String[] args) throws InterruptedException 
    {

        int[] numbers = new int[100000];

        for (int i = 0; i < numbers.length; i++) 
        {
            numbers[i] = 1;
        }

        int threadCount = 4;
        int part = numbers.length / threadCount;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) 
        {

            int start = i * part;
            int end = (i == threadCount - 1) ? numbers.length : start + part;

            threads[i] = new ArraySumThread(numbers, start, end);

            threads[i].start();
        }

        for (Thread thread : threads) 
        {
            thread.join();
        }

        System.out.println("Expected Sum : 100000");
        System.out.println("Actual Sum   : " + ArraySumThread.total);
    }
}