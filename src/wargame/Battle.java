package wargame;

import java.util.Iterator;

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
        army1.setBehinds();
        army2.setBehinds();
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

    public static boolean straightFight(Army army1, Army army2) {
        army1.setBehindsNull();
        army2.setBehindsNull();
        Warrior war1;
        Warrior war2;
       while(true) {
           var it1 = army1.getQueue().iterator();
           var it2 = army2.getQueue().iterator();
           while(it1.hasNext() && it2.hasNext()) {
               war1 = it1.next();
               war2 = it2.next();
               if(Battle.fight(war1, war2)) {
                   it2.remove();
               } else {
                   it1.remove();
               }
               if(army1.isDestroyed()) {
                   return false;
               }
               if(army2.isDestroyed()) {
                   return true;
               }
           }
       }
    }
}
