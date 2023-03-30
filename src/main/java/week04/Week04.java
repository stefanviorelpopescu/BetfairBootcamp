package week04;

import week04.counter.Counter;
import week04.counter.CounterThread;
import week04.counter.SumThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Week04
{

    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("BEFORE: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
//        t1.start();

        MyThread myThread = new MyThread();
//        myThread.setDaemon(true);
//        myThread.start();

//        t1.join();
//        myThread.join();

        Thread myThread2 = new Thread(() -> {
            for (int i=0; i<1_000; i++) {
                System.out.println(Thread.currentThread().getName() + " - "  + i);
            }
        });


        System.out.println("AFTER: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        Counter counter = new Counter();
        Integer count = 0;

        CounterThread c1 = new CounterThread(counter);
        CounterThread c2 = new CounterThread(counter);
        SumThread c3 = new SumThread(counter);
        SumThread c4 = new SumThread(counter);

        Thread counter1 = new Thread(c1);
        Thread counter2 = new Thread(c2);
        Thread sum1 = new Thread(c3);
        Thread sum2 = new Thread(c4);

        long start = System.currentTimeMillis();

        counter1.start();
        counter2.start();
        sum1.start();
        sum2.start();

        counter1.join();
        counter2.join();
        sum1.join();
        sum2.join();

        long end = System.currentTimeMillis();

        System.out.println(counter.getCount());
        System.out.println(counter.getSum());
        System.out.println("Time " + (end - start));

        List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());

        long startString = System.currentTimeMillis();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <1000_000; i++)
        {
            s.append("a");
        }
        long endString = System.currentTimeMillis();
        System.out.println("Time String: " + (endString-startString));

    }

}
