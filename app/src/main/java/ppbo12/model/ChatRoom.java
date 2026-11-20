
package ppbo12.model;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<User> members;

    public ChatRoom(String roomName) {
        this.roomName = roomName;
        members = new ArrayList<User>();
    }

    public void registerUser(User user) {
        members.add(user);
        user.setChatRoom(this);
    }

    public void sendBroadcast(User sender, String message) {
        System.out.println("[ChatRoom - " + roomName
                + "] (Broadcast dari " + sender.getName() + "): " + message);

        for (User user : members) {
            if (user != sender) {
                user.receiveMessage(sender, message);
            }
        }
    }
}
