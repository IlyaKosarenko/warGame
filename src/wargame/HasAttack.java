package wargame;

public interface HasAttack {

    int getDamage();

    void giveDamage(Warrior warrior);

    void takeDamage(int damage);
}
