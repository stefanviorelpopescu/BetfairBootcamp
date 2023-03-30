package week04._4_starvation;


public class PersonThatNeverFinishesEating extends Person {
  public PersonThatNeverFinishesEating(String id, OnePersonKitchen onePersonKitchen) {
    super(id, onePersonKitchen);
  }

  @Override
  public void run() {
    synchronized (super.onePersonKitchen) {
      System.out.println(super.id + " eating ...");
      while (true) {
      }
    }
  }
}