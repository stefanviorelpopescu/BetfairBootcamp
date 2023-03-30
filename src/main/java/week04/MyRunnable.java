package week04;

import lombok.SneakyThrows;

public class MyRunnable implements Runnable
{
    @SneakyThrows
    @Override
    public void run()
    {
        for (int i=0; i<1_000; i++) {
//            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " - "  + i);
        }
    }
}
