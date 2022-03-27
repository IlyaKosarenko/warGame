package wargame;

public class Defender extends Warrior {
    private static final int DEFENSE = 2;

    public Defender() {
        this.setDamage(3);
        this.setHealth(60);
    }


    public static Defender newDefender() {
        return new Defender();
    }

    @Override
    public void takeDamage(int damage) {
        if (damage > DEFENSE) {
            super.setHealth(super.getHealth() - (damage - DEFENSE));
        }
    }

}
