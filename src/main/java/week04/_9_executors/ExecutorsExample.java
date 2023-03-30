package week04._9_executors;

import java.util.concurrent.*;

public class ExecutorsExample {

  public static void main(String[] args) throws InterruptedException
  {
    int corePoolSize = 2;
    int maximumPoolSize = 8;
    long keepAliveTime = 0;
    TimeUnit unit = TimeUnit.SECONDS; //the time unit for the {@code keepAliveTime} argument
    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);

    ExecutorService executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new ThreadPoolExecutor.AbortPolicy());

    for (int i = 1; i <= 15; i++) {
      Thread.sleep(1000);
      executor.execute(new Task("task" + i));
    }

    executor.shutdown();
  }
}
