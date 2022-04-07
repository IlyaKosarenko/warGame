package wargame;


import java.util.*;

public class Army {
    Queue<Warrior> queue = new LinkedList<>();

    public void addUnits(Entity.Type type, int quantity) {
        for (int i = 0; i < quantity; i++) {
            queue.add(Warrior.of(type));
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
    public void setBehindsNull() {
        for(var el: queue) {
            el.setBehindWarrior(null);
        }
        for(var el: queue) {
            el.setBehindWarrior(null);
        }
    }
    Iterator<Warrior> iterator() {
        return new armyIterator();
    }
    private class armyIterator implements Iterator<Warrior>{
        Iterator<Warrior> it = queue.iterator();
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public Warrior next() {
            return it.next();
        }
    }
}
