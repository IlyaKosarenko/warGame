package wargame;

import java.util.LinkedList;

public class Knight extends Warrior {
    public Knight() {
        this.setDamage(7);
        this.setInitialHealth(50);
    }

    @Override
    public String toString() {
        return "Knight(" + getHealth() + " hp)";
    }
}
