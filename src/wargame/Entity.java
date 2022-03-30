package wargame;

public interface Entity {
    enum Type {
        WARRIOR, KNIGHT, DEFENDER, VAMPIRE, LANCER, HEALER
    }
    boolean isAlive();

    int getHealth();


}
