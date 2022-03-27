package wargame;

public interface Entity {
    enum Type {
        WARRIOR, KNIGHT, DEFENDER, VAMPIRE, LANCER
    }
    boolean isAlive();

    int getHealth();


}
