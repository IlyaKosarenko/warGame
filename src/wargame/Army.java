package wargame;


import java.util.*;

public class Army {
    ArrayDeque<Warrior> queue = new ArrayDeque<>();

    public void addUnits(Entity.Type type, int quantity) {
        for (int i = 0; i < quantity; i++) {
            queue.add(Warrior.of(type));
            setBehinds();
        }
    }

    public Queue<Warrior> getQueue() {
        return queue;
    }

    public boolean isDestroyed() {
        return queue.isEmpty();
    }

    public void setBehinds() {
        if (queue.size() <= 1) {
            return;
        }
        Iterator<Warrior> iterator = queue.iterator();
        Iterator<Warrior> iterator1 = queue.iterator();
        iterator1.next();
        while(iterator.hasNext() && iterator1.hasNext()) {
            iterator.next().setBehindWarrior(iterator1.next());
        }
    }
}
