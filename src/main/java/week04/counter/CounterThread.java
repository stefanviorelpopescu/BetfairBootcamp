package week04.counter;

public class CounterThread implements Runnable
{
    Counter counter;

    public CounterThread(Counter counter)
    {
        this.counter = counter;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10_000_000; i++)
        {
            counter.incrementCount();
        }
    }
}
