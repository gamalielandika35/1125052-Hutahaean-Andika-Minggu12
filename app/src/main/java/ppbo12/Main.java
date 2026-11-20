package ppbo12;

import ppbo12.model.User;

public class Main {
    public static void main(String[] args) {
        User budi = new User("Budi");
        User andi = new User("Andi");
        User cici = new User("Cici");

        budi.addContact(andi);
        budi.addContact(cici);

        budi.sendGroupMessage(andi, "Halo Andi!");
    }
}
