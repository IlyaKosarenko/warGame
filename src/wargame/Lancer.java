package wargame;

public class Lancer extends Warrior {
    public Lancer() {
        this.setDamage(6);
        this.setInitialHealth(50);
    }

    @Override
    public void giveDamage(Warrior warrior) {
        int hp1 = warrior.getHealth();
        super.giveDamage(warrior);
        if(warrior.getBehindWarrior() != null && warrior.getBehindWarrior().isAlive()) {
            int hp2 = warrior.getHealth();
            warrior.getBehindWarrior().takeDamage((hp1 - hp2) / 2);
        }
    }

    @Override
    public String toString() {
        return "Lancer(" + getHealth() + " hp)";
    }
}
