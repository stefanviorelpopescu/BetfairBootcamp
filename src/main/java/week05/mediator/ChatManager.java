package week05.mediator;

import java.util.List;

public class ChatManager
{
    List<User> connectedUsers;

    public void sendAll(String message) {
        for (User user : connectedUsers) {
            user.receiveMessage(message);
        }
    }

    public void send(User user, String message) {
        for (User connectedUser : connectedUsers) {
            if (connectedUser.equals(user)) {
                connectedUser.receiveMessage(message);
                break;
            }
        }
    }
}
