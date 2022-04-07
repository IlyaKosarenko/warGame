package wargame;

public class Vampire extends Warrior {
    private static final int VAMPIRISM = 50;

    public Vampire() {
        this.setInitialHealth(50);
    }

    @Override
    public void giveDamage(Warrior warrior) {
        int hp1 = warrior.getHealth();
        super.giveDamage(warrior);
        this.setHealth(this.getHealth() + (hp1 - warrior.getHealth()) * VAMPIRISM / 100);
    }

    @Override
    public String toString() {
        return "Vampire(" + getHealth() + " hp)";
    }
}
