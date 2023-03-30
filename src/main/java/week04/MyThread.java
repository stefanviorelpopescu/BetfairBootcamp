package week04;

public class MyThread extends Thread
{
    @Override
    public void run()
    {
        for (int i=0; i<1_000; i++) {
            System.out.println(Thread.currentThread().getName() + " - "  + i);
        }
    }
}
