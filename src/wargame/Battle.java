package wargame;

public class Battle {
    Battle() {

    }

    public static boolean fight(Warrior w1, Warrior w2) {
        while(true) {
            if(w1.isAlive()) {
                w1.giveDamage(w2);
            } else {
                return false;
            }
            if (w2.isAlive()) {
                w2.giveDamage(w1);
            } else {
                return true;
            }
        }
    }

    public static boolean fight(Army army1, Army army2) {
        while(true) {
            if(!army1.isDestroyed()) {
                if(Battle.fight(army1.getQueue().peek(), army2.getQueue().peek())) {
                    army2.getQueue().poll();
                } else {
                    army1.getQueue().poll();
                }
            } else {
                return false;
            }
            if (army2.isDestroyed()) {
                return true;
            }
        }
    }

}
