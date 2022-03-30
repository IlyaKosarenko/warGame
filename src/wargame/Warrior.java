package wargame;


import static wargame.Defender.newDefender;
import static wargame.Healer.newHealer;
import static wargame.Knight.newKnight;
import static wargame.Lancer.newLancer;
import static wargame.Vampire.newVampire;

public class Warrior implements Entity, HasAttack {
    private int initialHealth = 50;
    private int health = 50;
    private int attack = 5;
    private Warrior behindWarrior = null;

    public Warrior() {

    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
    }

    public Warrior getBehindWarrior() {
        return behindWarrior;
    }

    public void setBehindWarrior(Warrior behindWarrior) {
        this.behindWarrior = behindWarrior;
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
            case HEALER -> newHealer();
        };
    }
    @Override
    public int getDamage() {
        return attack;
    }

    @Override
    public void giveDamage(Warrior warrior) {
        warrior.takeDamage(this.getDamage());
        if(this.behindWarrior instanceof Healer) {
            ((Healer) behindWarrior).heal(this);
        }
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

    //protected void heal(Warrior warrior, Healer healer) {}


}
