package wargame;

import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;

public class Lancer extends Warrior {
    public Lancer() {
        this.setDamage(6);
    }

    public static Lancer newLancer() {
        return new Lancer();
    }

    @Override
    public void giveDamage(Warrior warrior) {
        warrior.takeDamage(this.getDamage());
    }
}
