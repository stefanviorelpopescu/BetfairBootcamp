package week04._3_good_coordination;

public class Consumer extends Thread {

  private final IChannel channel;

  public Consumer(IChannel channel) {
    this.channel = channel;
  }

  @Override
  public void run() {
    String previous = "0";
    String current = channel.take();
    while (!current.equals("DONE")) {
      System.out.println(current);

      if (Integer.parseInt(current) != Integer.parseInt(previous) + 1) {
        System.out.println("lack of coordination");
        System.exit(0);
      }

      previous = current;
      current = channel.take();
    }
  }

}
