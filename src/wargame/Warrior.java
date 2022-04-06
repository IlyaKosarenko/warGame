package wargame;

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


    public static Warrior of(Type type) {
        return switch (type) {
            case WARRIOR -> new Warrior();
            case KNIGHT -> new Knight();
            case DEFENDER -> new Defender();
            case VAMPIRE -> new Vampire();
            case LANCER -> new Lancer();
            case HEALER -> new Healer();
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


}
