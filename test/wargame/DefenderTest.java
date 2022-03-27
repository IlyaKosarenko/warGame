package wargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefenderTest {

    @Test
    @DisplayName("10 war, 4 def vs 4 war: true")
    void test1() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Entity.Type.WARRIOR, 5);
        army1.addUnits(Entity.Type.DEFENDER, 4);
        army1.addUnits(Entity.Type.WARRIOR, 5);
        army2.addUnits(Entity.Type.WARRIOR, 4);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("5 def, 20 war vs 21 war, 4 def: true")
    void test2() {
        var army1 =  new Army();
        var army2 = new Army();

        army1.addUnits(Entity.Type.DEFENDER, 5);
        army1.addUnits(Entity.Type.WARRIOR, 20);
        army2.addUnits(Entity.Type.WARRIOR, 21);
        army2.addUnits(Entity.Type.DEFENDER, 4);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("10 war, 15 def vs 5 war: true")
    void test3() {
        var army1 =  new Army();
        var army2 = new Army();

        army1.addUnits(Entity.Type.WARRIOR, 10);
        army1.addUnits(Entity.Type.DEFENDER, 5);
        army2.addUnits(Entity.Type.WARRIOR, 5);
        army1.addUnits(Entity.Type.DEFENDER, 10);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("3 def, 1 war vs 5 war: false")
    void test4() {
        var army1 =  new Army();
        var army2 = new Army();

        army1.addUnits(Entity.Type.DEFENDER, 2);
        army1.addUnits(Entity.Type.WARRIOR, 1);
        army1.addUnits(Entity.Type.DEFENDER, 1);
        army2.addUnits(Entity.Type.WARRIOR, 5);

        boolean res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("war vs def: false")
    void test5() {
        var def = new Defender();
        var war = new Warrior();

        boolean res = Battle.fight(war, def);

        assertFalse(res);
    }
}
