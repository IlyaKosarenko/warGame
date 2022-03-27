package wargame;

public interface Entity {
    enum Type {
        WARRIOR, KNIGHT, DEFENDER, VAMPIRE, LANCER
    }
    int a = 0;
    boolean isAlive();

    int getHealth();


}
