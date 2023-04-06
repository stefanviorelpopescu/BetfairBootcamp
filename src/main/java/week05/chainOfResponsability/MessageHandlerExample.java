package week05.chainOfResponsability;

public class MessageHandlerExample
{
    public static void main(String[] args)
    {
        Chain myChain = new Chain(msg -> msg.startsWith("im:"), x -> System.out.println("IM " + x));
        myChain.setNext(new Chain(msg -> msg.startsWith("sms:"), x -> System.out.println("SMS " + x)))
                .setNext(new Chain(msg -> msg.startsWith("log:"), x1 -> System.out.println("LOG " + x1)));

        myChain.handle("im: hello");
        myChain.handle("sms: hello");
        myChain.handle("log: hello");
        myChain.handle("email: hello");
    }
}
