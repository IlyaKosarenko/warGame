package wargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LancerTest {
    @Test
    @DisplayName("Lancer vs warrior, Knight: False")
    void test1() {
          Army army1 = new Army();
          Army army2 = new Army();
          army1.addUnits(Entity.Type.WARRIOR, 1);
          army1.addUnits(Entity.Type.KNIGHT, 1);
          army2.addUnits(Entity.Type.LANCER, 1);

        boolean res = Battle.fight(army2, army1);

        assertFalse(res);


    }

    @Test
    @DisplayName("5 lan, 3 vam, 2 def vs 4 war, 4 def, 6 vam, 5 lan: False")
    void test2() {
        Army army1 = new Army();
        Army army2 = new Army();
        army1.addUnits(Entity.Type.LANCER, 5);
        army1.addUnits(Entity.Type.VAMPIRE, 3);
        army1.addUnits(Entity.Type.DEFENDER, 2);
        army2.addUnits(Entity.Type.WARRIOR, 4);
        army2.addUnits(Entity.Type.DEFENDER, 4);
        army2.addUnits(Entity.Type.VAMPIRE, 6);
        army2.addUnits(Entity.Type.LANCER, 5);

        boolean res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("7 lan, 3 vam, 4 war, 2 def vs 4 war, 4 def, 6 vam, 4 lan: True")
    void test3() {
        Army army1 = new Army();
        Army army2 = new Army();
        army1.addUnits(Entity.Type.LANCER, 7);
        army1.addUnits(Entity.Type.VAMPIRE, 3);
        army1.addUnits(Entity.Type.WARRIOR, 4);
        army1.addUnits(Entity.Type.DEFENDER, 2);
        army2.addUnits(Entity.Type.WARRIOR, 4);
        army2.addUnits(Entity.Type.DEFENDER, 4);
        army2.addUnits(Entity.Type.VAMPIRE, 6);
        army2.addUnits(Entity.Type.LANCER, 4);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

}
