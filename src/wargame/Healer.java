package wargame;

public class Healer extends Warrior {
    private static final int heal = 2;
    private int maxAids = 200;

    public Healer() {
        this.setDamage(0);
        this.setHealth(60);
        this.setInitialHealth(60);
    }

    public static Healer newHealer() {
        return new Healer();
    }

    public void heal(Warrior warrior) {
        if(maxAids > 0) {
            if (warrior.getHealth() > warrior.getInitialHealth() - 2) {
                warrior.setHealth(warrior.getInitialHealth());
            } else {
                warrior.setHealth(warrior.getHealth() + 2);
            }
            maxAids--;
        }
    }

}
