package ppbo12;

import ppbo12.model.User;
import ppbo12.model.ChatRoom;

public class Main {
    public static void main(String[] args) {

        ChatRoom general = new ChatRoom("General");

        User budi = new User("Budi");
        User andi = new User("Andi");
        User cici = new User("Cici");

        general.registerUser(budi);
        general.registerUser(andi);
        general.registerUser(cici);

        budi.sendGroupMessage(andi, "Halo Semuany");
    }
}
