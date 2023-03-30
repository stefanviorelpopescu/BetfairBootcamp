package week04._4_starvation;

public class OnePersonKitchen {

  public void eat() {
    try {
      Thread.sleep(1_000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}