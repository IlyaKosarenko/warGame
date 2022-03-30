package wargame;

import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;

public class Lancer extends Warrior {
    public Lancer() {
        this.setDamage(6);
        this.setInitialHealth(50);
    }

    public static Lancer newLancer() {
        return new Lancer();
    }

    @Override
    public void giveDamage(Warrior warrior) {
        int hp1 = warrior.getHealth();
        warrior.takeDamage(this.getDamage());

        if(warrior.getBehindWarrior() != null && warrior.getBehindWarrior().isAlive()) {
            warrior.getBehindWarrior().takeDamage((hp1 - warrior.getHealth()) / 2);
        }
        if(this.getBehindWarrior() instanceof Healer) {
            ((Healer) this.getBehindWarrior()).heal(this);
        }
    }

}
