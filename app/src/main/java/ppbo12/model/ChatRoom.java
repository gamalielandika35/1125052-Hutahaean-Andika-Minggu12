
package ppbo12.model;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<User> members;
    private List<String> badwords;
    private User King;

    public ChatRoom(String roomName) {
        this.roomName = roomName;
        members = new ArrayList<User>();
        badwords = new ArrayList<String>();
    }

    public void registerUser(User user) {
        if (!members.contains(user)) {
            members.add(user);
            user.setChatRoom(this);
            System.out.println(user.getName() + "member baru masuk jir"+ roomName);
        } else {
            System.out.println( user.getName() + "admin datang" + roomName);
        }
    }

    public User getKing() {
        return King;
    }



    public void addBadword(String badword) {
        badwords.add(badword);
    }

    String filtermessage(String message) {
        String filteredMessage = message;
        for (String badword : badwords) {
            filteredMessage = filteredMessage.replaceAll("(ppp)" + badword, "****");
        }
        return filteredMessage;
    }

    public void removeUser(User user) {
        if (members.contains(user)) {
            members.remove(user);
            user.setChatRoom(null);
            System.out.println(user.getName() + "dikeluarkan admin " + roomName);
        } else {
            System.out.println(user.getName() + "sudah dihitamkan admin " + roomName);
        }
    }

    public void sendBroadcast(User sender, String message) {
        if (!members.contains(sender)) {
            System.out.println(sender.getName() + " bukan anggota " + roomName);
            return;
        }

        message = filtermessage(message);

        System.out.println("ChatRoom- " + roomName
                + " Broadcast dari " + sender.getName() + ": " + message);

        for (User user : members) {
            if (user != sender) {
                user.receiveMessage(sender, message);
            }
        }
    }
    public void sendPrivateMessage(User sender, String recipientName, String message) {
        if (!members.contains(sender)) {
            System.out.println(sender.getName() + " bukan anggota " + roomName);
            return;
        }

        message = filtermessage(message);

        for (User user : members) {
            if (user.getName().equals(recipientName)) {
                System.out.println("[ChatRoom- " + roomName
                        + " Private " + sender.getName()
                        + "  " + recipientName + ": " + message);

                user.receivePrivateMessage(sender, message);
                return;
            }
        }

        System.out.println("member" + recipientName + " sudah dihitamkan");
    }
}
