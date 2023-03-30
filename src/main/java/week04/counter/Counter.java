package week04.counter;

import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
    Integer count = 0;
    Integer backupCount = 0;

    Integer sum = 0;

    final Object counterLock = new Object();
    final Object sumLock = new Object();

    public Integer getCount()
    {
        return count;
    }

    public void incrementCount()
    {
        synchronized (counterLock) {
            count = count + 1;
            incrementBackupCount();
        }
    }

    public void incrementBackupCount()
    {
        synchronized (counterLock) {
            backupCount++;
        }
    }

    public Integer getSum()
    {
        return sum;
    }

    public void incrementSum()
    {
        synchronized (sumLock) {
            sum ++;
        }
    }
}
