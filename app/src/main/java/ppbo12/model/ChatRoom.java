
package ppbo12.model;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<User> members;
    private List<String> badwords;

    public ChatRoom(String roomName) {
        this.roomName = roomName;
        members = new ArrayList<User>();
        badwords = new ArrayList<String>();
    }

    public void registerUser(User user) {
        members.add(user);
        user.setChatRoom(this);
    }

    public void addBadword(String badword) {
        badwords.add(badword);
    }

    String filtermessage(String message) {
        String filteredMessage = message;
        for (String badword : badwords) {
            filteredMessage = filteredMessage.replaceAll("(?i)" + badword, "****");
        }
        return filteredMessage;
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
    public void sendPrivateMessage(User sender, String recipientName, String message) {
        for (User user : members) {
            if (user.getName().equals(recipientName)) {
                System.out.println("[ChatRoom - " + roomName
                        + "] (Private " + sender.getName()
                        + " -> " + recipientName + "): " + message);

                user.receivePrivateMessage(sender, message);
                return;
            }
        }

        System.out.println("Pengguna " + recipientName + " tidak ditemukan.");
    }
}
