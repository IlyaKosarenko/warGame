package wargame;

public class Defender extends Warrior {
    private static final int DEFENSE = 2;

    public Defender() {
        this.setDamage(3);
        this.setHealth(60);
        this.setInitialHealth(60);
    }

    @Override
    public void takeDamage(int damage) {
        if (damage > DEFENSE) {
            super.setHealth(super.getHealth() - (damage - DEFENSE));
        }
    }

    @Override
    public String toString() {
        return "Defender(" + getHealth() + " hp)";
    }
}
