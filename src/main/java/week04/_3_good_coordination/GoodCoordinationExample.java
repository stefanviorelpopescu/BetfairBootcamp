package week04._3_good_coordination;

public class GoodCoordinationExample {

  public static void main(String[] args) {
    IChannel c = new GoodCoordinationChannel();

    (new Consumer(c)).start();
    (new Producer(c)).start();
  }

}
