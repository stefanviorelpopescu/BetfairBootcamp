package week04.counter;

public class SumThread implements Runnable
{
    Counter counter;

    public SumThread(Counter counter)
    {
        this.counter = counter;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10_000_000; i++)
        {
            counter.incrementSum();
        }

    }
}
