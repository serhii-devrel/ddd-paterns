package Mediator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Room room = new Room();
        Player john = new Player("John");
        Player jane = new Player("Jane");
        Player carl = new Player("Carl");
        room.join(john);
        room.join(jane);
        room.join(carl);
        john.sendMessage("Hi everyone!");
    }
}

class Player {
    String name;
    Room room;

    public Player(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        this.room.broadcast(message, this);
    }

    public void receiveMessage(String message, Player player) {
        System.out.printf("%s send a message: %s\n", player.name, message);
    }
}

class Room {
    List<Player> participants = new ArrayList<>();

    public void broadcast(String message, Player player) {
        participants.forEach(participant -> {
            if (participant != player) {
                participant.receiveMessage(message, player);
            }
        });
    }

    public void join(Player player) {
        player.room = this;
        participants.add(player);
    }

}
