package wargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {
    @Test
    @DisplayName("Quantity equals 3")
    void test1() {
        var army1 = new Army();

        army1.addUnits(Entity.Type.WARRIOR, 3);

        assertEquals(3, army1.getQueue().size());
    }

    @Test
    @DisplayName("Warriors instanceof class")
    void test2() {
        var army1 = new Army();

        army1.addUnits(Entity.Type.WARRIOR, 3);

        assertTrue(army1.getQueue().peek()  instanceof Warrior);
    }

    @Test
    @DisplayName("Knights instanceof class")
    void test3() {
        var army1 = new Army();

        army1.addUnits(Entity.Type.KNIGHT, 1);

        assertTrue(army1.getQueue().peek() instanceof Knight);
    }

    @Test
    @DisplayName("army1(3 war) vs army2(5 war): false")
    void test4() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Entity.Type.WARRIOR, 3);
        army2.addUnits(Entity.Type.WARRIOR, 5);

        boolean res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("army1(5 war) vs army2(5 war): true")
    void test5() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Entity.Type.WARRIOR, 5);
        army2.addUnits(Entity.Type.WARRIOR, 5);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("army1(5 war) vs army2(4 war): true")
    void test6() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Entity.Type.WARRIOR, 5);
        army2.addUnits(Entity.Type.WARRIOR, 4);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("army1(20 war, 5 kn) vs army2(30 war): false")
    void test7() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Entity.Type.WARRIOR, 20);
        army1.addUnits(Entity.Type.KNIGHT, 5);
        army2.addUnits(Entity.Type.WARRIOR, 30);

        boolean res = Battle.fight(army1, army2);

        assertFalse(res);
    }

}