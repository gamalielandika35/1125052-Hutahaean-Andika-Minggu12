package ppbo12;

import ppbo12.model.User;
import ppbo12.model.ChatRoom;

public class Main {
    public static void main(String[] args) {

        ChatRoom general = new ChatRoom("General");
        ChatRoom sports = new ChatRoom("Sports");

        User budi = new User("Budi");
        User andi = new User("Andi");
        User cici = new User("Cici");

        general.registerUser(budi);
        sports.registerUser(andi);
        sports.registerUser(cici);

        budi.send("Halo Semuany");

        budi.sendPrivate("andi", "hai mas halo");

        System.out.println();

        general.addBadword("anjeng");
        general.addBadword("babi");

        budi.sendPrivate("cici", "anjeng lu");

        sports.removeUser(cici);

        






    }
}
