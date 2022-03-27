package wargame;

import java.util.LinkedList;

public class Knight extends Warrior {
    public Knight() {
        this.setDamage(7);
    }

    public static Knight newKnight() {
        return new Knight();
    }
}
