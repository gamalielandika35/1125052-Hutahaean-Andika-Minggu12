package ppbo12.model;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<User> contacts;

    public User(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public void addContact(User contact) {
        contacts.add(contact);
    }

    public void sendGroupMessage(User receiver, String message) {
        System.out.println("[" + name + " -> " + receiver.name + "]: " + message);
        for (User user : contacts) {
            user.receiveMessage(this, message);
        }
    }

    public void receiveMessage(User sender, String message) {
        System.out.println("[" + name + "] Menerima pesan dari " + sender.name + ": " + message);
    }
}
