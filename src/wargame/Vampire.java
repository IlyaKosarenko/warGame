package wargame;

public class Vampire extends Warrior {
    private static final int VAMPIRISM = 50;

    public Vampire() {

    }

    public static Vampire newVampire() {
        return new Vampire();
    }

    @Override
    public void giveDamage(Warrior warrior) {
        int hp1 = warrior.getHealth();
        warrior.takeDamage(this.getDamage());
        this.setHealth(this.getHealth() + (hp1 - warrior.getHealth()) * VAMPIRISM / 100);
    }
}
