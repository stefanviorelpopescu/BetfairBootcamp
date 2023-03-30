package week04._4_starvation;

public class Person extends Thread {
  protected final OnePersonKitchen onePersonKitchen;
  protected String id;

  public Person(String id, OnePersonKitchen onePersonKitchen) {
    super(id);
    this.id = id;
    this.onePersonKitchen = onePersonKitchen;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (onePersonKitchen) {
        System.out.println(id + " eating ...");
        onePersonKitchen.eat();
        System.out.println(id + " finished eating");
        onePersonKitchen.notifyAll(); //notify others that the kitchen is free now
        waitToBeNotifiedThatKitchenIsOpen();
      }
    }
  }

  private void waitToBeNotifiedThatKitchenIsOpen() {
    try {
      onePersonKitchen.wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}