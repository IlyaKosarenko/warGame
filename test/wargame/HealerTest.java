package wargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HealerTest {
    @Test
    @DisplayName("7 lan, 3 vam, 1 heal, 4 war, 1 heal, 2 def vs 4 war, 4 def, 1 heal, 6 vam, 4 lan: true")
    void test1() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Entity.Type.LANCER, 7);
        army1.addUnits(Entity.Type.VAMPIRE, 3);
        army1.addUnits(Entity.Type.HEALER, 1);
        army1.addUnits(Entity.Type.WARRIOR, 4);
        army1.addUnits(Entity.Type.HEALER, 1);
        army1.addUnits(Entity.Type.DEFENDER, 2);
        army2.addUnits(Entity.Type.WARRIOR, 4);
        army2.addUnits(Entity.Type.DEFENDER, 4);
        army2.addUnits(Entity.Type.HEALER, 1);
        army2.addUnits(Entity.Type.VAMPIRE, 6);
        army2.addUnits(Entity.Type.LANCER, 4);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);

    }

    @Test
    @DisplayName("1 lan, 3 war, 1 heal, 4 war, 1 heal, 2 knight vs 4 war, 4 def, 1 heal, 6 vam, 4 lan: false")
    void test2() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Entity.Type.LANCER, 1);
        army1.addUnits(Entity.Type.WARRIOR, 3);
        army1.addUnits(Entity.Type.HEALER, 1);
        army1.addUnits(Entity.Type.WARRIOR, 4);
        army1.addUnits(Entity.Type.HEALER, 1);
        army1.addUnits(Entity.Type.KNIGHT, 2);
        army2.addUnits(Entity.Type.WARRIOR, 4);
        army2.addUnits(Entity.Type.DEFENDER, 4);
        army2.addUnits(Entity.Type.HEALER, 1);
        army2.addUnits(Entity.Type.VAMPIRE, 6);
        army2.addUnits(Entity.Type.LANCER, 4);


        boolean res = Battle.fight(army1, army2);

        assertFalse(res);

    }

    @Test
    @DisplayName("1 war vs 1 war, 1 heal: false")
    void test3() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Entity.Type.WARRIOR, 1);
        army2.addUnits(Entity.Type.WARRIOR, 1);
        army2.addUnits(Entity.Type.HEALER, 1);


        boolean res = Battle.fight(army1, army2);

        assertFalse(res);

    }
}
