package wargame;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Army {
    Queue<Warrior> queue = new LinkedList<>();

    public void addUnits(Entity.Type type, int quantity) {
        for(int i = 0; i < quantity; i++) {
                queue.add(Warrior.of(type));
        }
    }

    public Queue<Warrior> getQueue() {
        return queue;
    }

    public boolean isDestroyed() {
        return queue.isEmpty();
    }


}
