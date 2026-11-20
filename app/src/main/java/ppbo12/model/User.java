package ppbo12.model;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<ChatRoom> chatRooms;

    public User(String name) {
        this.name = name;
        this.chatRooms = new ArrayList<ChatRoom>();
    }

    public String getName() {
        return name;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRooms.add(chatRoom);
    }
    public void send(String message) {
        System.out.println("[" + name + "]: Memproses pengiriman pesan grups");
        for (ChatRoom chatRoom : chatRooms) {
            chatRoom.sendBroadcast(this, message);
        }
    }
     public void sendPrivate(String recipientName, String message) {
        System.out.println("[" + name + "]: Mengirim pesan privat ke-"
                + recipientName + "");

        for (ChatRoom chatRoom : chatRooms) {
            chatRoom.sendPrivateMessage(this, recipientName, message);
        }
    }

    public void receiveMessage(User sender, String message) {
        System.out.println("[" + name + "] Menerima pesan dari " + sender.getName() + ": " + message);
    }
    public void receivePrivateMessage(User sender, String message) {
        System.out.println("[ " + name + " ] Menerima pesan privat dari "
                + sender.getName() + ": " + message);
    }
}
