package wargame;
import java.util.logging.*;

public class Battle {
    Battle() {

    }
    public static final Logger logger = Logger.getLogger(Battle.class.getName());

    public static boolean fight(Warrior w1, Warrior w2) {
        logger.info("Fight: " + w1.toString() + " vs " + w2.toString());
        while(true) {
            if(w1.isAlive()) {
                w1.giveDamage(w2);
            } else {
                logger.info(w2.toString() + " won");
                return false;
            }
            if (w2.isAlive()) {
                w2.giveDamage(w1);
            } else {
                logger.info(w1.toString() + " won");
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
