package ppbo12.model;

public class User {
    private String name;
    private ChatRoom chatRoom;

    public User(String name) {
        this.name = name;
        this.chatRoom = null;
    }

    public String getName() {
        return name;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }
    public void send(String message) {
        System.out.println("[" + name + "]: Memproses pengiriman pesan grups");
        chatRoom.sendBroadcast(this, message);
    }
    public void sendGroupMessage(User receiver, String message) {
        if (chatRoom != null) {
            chatRoom.sendBroadcast(this, message);
        }
    }

     public void sendPrivate(String recipientName, String message) {
        System.out.println("[" + name + "]: Mengirim pesan privat ke-"
                + recipientName + "");

        chatRoom.sendPrivateMessage(this, recipientName, message);
    }

    public void receiveMessage(User sender, String message) {
        System.out.println("[" + name + "] Menerima pesan dari " + sender.getName() + ": " + message);
    }
    public void receivePrivateMessage(User sender, String message) {
        System.out.println("[ " + name + " ] Menerima pesan privat dari "
                + sender.getName() + ": " + message);
    }
}
