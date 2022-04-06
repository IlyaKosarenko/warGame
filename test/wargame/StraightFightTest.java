package wargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StraightFightTest {

    @Test
    @DisplayName("5 lan, 3 vam, 4 war, 2 def vs 4 war, 4 def, 6 vam, 5 lan: false")
    void test1() {
        Army army1 = new Army();
        Army army2 = new Army();
        army1.addUnits(Entity.Type.LANCER, 5);
        army1.addUnits(Entity.Type.VAMPIRE, 3);
        army1.addUnits(Entity.Type.WARRIOR, 4);
        army1.addUnits(Entity.Type.DEFENDER, 2);
        army2.addUnits(Entity.Type.WARRIOR, 4);
        army2.addUnits(Entity.Type.DEFENDER, 4);
        army2.addUnits(Entity.Type.VAMPIRE, 6);
        army2.addUnits(Entity.Type.LANCER, 5);

        boolean res = Battle.straightFight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("7 lan, 3 vam, 4 war, 2 def vs 4 war, 4 def, 6 vam, 5 lan: true")
    void test2() {
        Army army1 = new Army();
        Army army2 = new Army();
        army1.addUnits(Entity.Type.LANCER, 7);
        army1.addUnits(Entity.Type.VAMPIRE, 3);
        army1.addUnits(Entity.Type.WARRIOR, 4);
        army1.addUnits(Entity.Type.DEFENDER, 2);
        army2.addUnits(Entity.Type.WARRIOR, 4);
        army2.addUnits(Entity.Type.DEFENDER, 4);
        army2.addUnits(Entity.Type.VAMPIRE, 6);
        army2.addUnits(Entity.Type.LANCER, 5);

        boolean res = Battle.straightFight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("7 lan, 3 vam, 1 heal, 4 war, 1 heal, 2 def vs 4 war, 4 def, 1 heal, 6 vam, 4 lan: false")
    void test3() {
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

        boolean res = Battle.straightFight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("4 lan, 3 war, 1 heal, 4 war, 1 heal, 2 knight vs 4 war, 4 def, 1 heal, 2 vam, 4 lan: true")
    void test4() {
        Army army1 = new Army();
        Army army2 = new Army();
        army1.addUnits(Entity.Type.LANCER, 4);
        army1.addUnits(Entity.Type.WARRIOR, 3);
        army1.addUnits(Entity.Type.HEALER, 1);
        army1.addUnits(Entity.Type.WARRIOR, 4);
        army1.addUnits(Entity.Type.HEALER, 1);
        army1.addUnits(Entity.Type.KNIGHT, 2);
        army2.addUnits(Entity.Type.WARRIOR, 4);
        army2.addUnits(Entity.Type.DEFENDER, 4);
        army2.addUnits(Entity.Type.HEALER, 1);
        army2.addUnits(Entity.Type.VAMPIRE, 2);
        army2.addUnits(Entity.Type.LANCER, 4);

        boolean res = Battle.straightFight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("2 war, 1 knight vs 2 knight, 1 heal: true")
    void test6() {
        Army army1 = new Army();
        Army army2 = new Army();
        army1.addUnits(Entity.Type.WARRIOR, 2);
        army1.addUnits(Entity.Type.KNIGHT, 1);
        army2.addUnits(Entity.Type.KNIGHT, 1);
        army2.addUnits(Entity.Type.HEALER, 1);
        army2.addUnits(Entity.Type.KNIGHT, 1);
        boolean res = Battle.straightFight(army1, army2);
        assertTrue(res);
    }
}
