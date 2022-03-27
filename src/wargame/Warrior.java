package wargame;


import static wargame.Defender.newDefender;
import static wargame.Knight.newKnight;
import static wargame.Lancer.newLancer;
import static wargame.Vampire.newVampire;

public class Warrior implements Entity, HasAttack {
    private int health = 50;
    private int attack = 5;

    public Warrior() {

    }

    public static Warrior newWarrior() {
        return new Warrior();
    }


    public static Warrior of(Type type) {
        return switch (type) {
            case WARRIOR -> newWarrior();
            case KNIGHT -> newKnight();
            case DEFENDER -> newDefender();
            case VAMPIRE -> newVampire();
            case LANCER -> newLancer();
        };
    }
    @Override
    public int getDamage() {
        return attack;
    }

    @Override
    public void giveDamage(Warrior warrior) {
        warrior.takeDamage(this.getDamage());
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    protected void setDamage(int attack) {
        this.attack = attack;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

}
