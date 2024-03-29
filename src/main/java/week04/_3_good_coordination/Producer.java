package week04._3_good_coordination;

public class Producer extends Thread {

  private final IChannel channel;

  public Producer(IChannel channel) {
    this.channel = channel;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 1_000_000; i++) {
      channel.put(String.valueOf(i));
    }
    channel.put("DONE");
  }
}
