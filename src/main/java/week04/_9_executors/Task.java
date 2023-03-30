package week04._9_executors;

public class Task implements Runnable {

  private final String name;

  public Task(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 10; i++) {
      System.out.println(name + " calling database #" + i + " om " + Thread.currentThread().getName());
      simulateLongDatabaseCall();
    }
  }

  private void simulateLongDatabaseCall() {
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
