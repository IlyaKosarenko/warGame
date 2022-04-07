package wargame;

public class Healer extends Warrior {
    private static final int HEAL = 2;
    private int maxAids = 200;

    public Healer() {
        this.setDamage(0);
        this.setHealth(60);
        this.setInitialHealth(60);
    }

    public void heal(Warrior warrior) {
        if(maxAids > 0) {
            if(warrior.getHealth() > getInitialHealth() - HEAL) {
                warrior.setHealth(warrior.getInitialHealth());
            } else {
                warrior.setHealth(warrior.getHealth() + HEAL);
            }
            maxAids--;
        }
    }

    @Override
    public String toString() {
        return "Healer(" + getHealth() + " hp)";
    }

}
