package wargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @Test
    @DisplayName("carl vs jim: false")
    void test1() {
        var carl = Warrior.of(Entity.Type.WARRIOR);
        var jim = Warrior.of(Entity.Type.KNIGHT);

        boolean res = Battle.fight(carl, jim);

        assertFalse(res);
    }

    @Test
    @DisplayName("ramon vs slevin: true")
    void test2() {
        var ramon = Knight.newKnight();
        var slevin = Warrior.newWarrior();

        boolean res = Battle.fight(ramon, slevin);

        assertTrue(res);
    }

    @Test
    @DisplayName("bob vs mars, bob alive?: true")
    void test3() {
        var bob = Warrior.newWarrior();
        var mars = Warrior.newWarrior();

        Battle.fight(bob, mars);
        boolean res = bob.isAlive();

        assertTrue(res);
    }

    @Test
    @DisplayName("zeus vs godkiller, zeus alive?: true")
    void test4() {
        var zeus = Knight.newKnight();
        var godkiller = Warrior.newWarrior();

        Battle.fight(zeus, godkiller);
        boolean res = zeus.isAlive();

        assertTrue(res);
    }

    @Test
    @DisplayName("wife vs husband, wife alive?: false")
    void test5() {
        var wife = Warrior.newWarrior();
        var husband = Warrior.newWarrior();

        Battle.fight(husband, wife);
        boolean res = wife.isAlive();

        assertFalse(res);
    }

    @Test
    @DisplayName("dragon vs knight, knight alive?: true")
    void test6() {
        var dragon = Warrior.newWarrior();
        var knight = Knight.newKnight();

        Battle.fight(dragon, knight);
        boolean res = knight.isAlive();

        assertTrue(res);
    }

    @Test
    @DisplayName("unit1 vs unit2, unit2 vs unit3: false")
    void test7() {
        var unit1 = Warrior.newWarrior();
        var unit2 = Knight.newKnight();
        var unit3 = Warrior.newWarrior();
        Battle.fight(unit1, unit2);

        boolean res = Battle.fight(unit2, unit3);

        assertFalse(res);
    }
}