
package ppbo12.model;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<User> members;
    private List<String> badwords;
    private User King;
    private List<User> muteUsers;
    private List<String> chatHistory;

    public ChatRoom(String roomName) {
        this.roomName = roomName;
        members = new ArrayList<User>();
        badwords = new ArrayList<String>();
        muteUsers = new ArrayList<User>();
        chatHistory = new ArrayList<String>();
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
public void muteUser(User user) {
    if (members.contains(user)) {
        if (!muteUsers.contains(user)) {
            muteUsers.add(user);
            System.out.println(user.getName() + " telah di-mute.");
        }
    }
}

public void unmuteUser(User user) {
    if (muteUsers.contains(user)) {
        muteUsers.remove(user);
        System.out.println(user.getName() + " telah di-unmute.");
    }
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

    if (muteUsers.contains(sender)) {
        System.out.println(sender.getName() + " sedang di-mute. Pesan tidak dikirim.");
        return;
    }

    message = filtermessage(message);

    for (User user : members) {
        if (user.getName().equals(recipientName)) {
            String history = "[Private " + sender.getName()
                    + " -> " + recipientName + "]: " + message;

            chatHistory.add(history);

            System.out.println("[ChatRoom - " + roomName + "] " + history);

            user.receivePrivateMessage(sender, message);
            return;
        }
    }

    System.out.println(" member " + recipientName + " sudah dihitamkan");
}
public void showHistory() {
    System.out.println("=== CHAT HISTORY: " + roomName + " ===");

    for (String message : chatHistory) {
        System.out.println(message);
    }
}
}
