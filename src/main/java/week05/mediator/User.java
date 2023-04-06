package week05.mediator;

public class User
{
    private String name;
    private ChatManager chatManager;

    public void sendAll(String message) {
        chatManager.sendAll(message);
    }

    public void sendMessage(User user, String message) {
        chatManager.send(user, message);
    }

    public void receiveMessage(String message)
    {
        System.out.println(message);
    }
}
