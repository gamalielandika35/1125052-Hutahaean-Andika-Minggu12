package model;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(User receiver, String message) {
        System.out.println("[" + name + " -> " + receiver.name + "]: " + message);
        receiver.receiveMessage(this, message);
    }

    public void receiveMessage(User sender, String message) {
        System.out.println("[" + name + "] Menerima pesan dari " + sender.name + ": " + message);
    }
}
