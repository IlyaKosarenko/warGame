package wargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VampireTest {
    @Test
    @DisplayName("def vs vam: true")
    void test1() {
        var def = Warrior.of(Entity.Type.DEFENDER);
        var vam = Warrior.of(Entity.Type.VAMPIRE);

        boolean res = Battle.fight(vam, def);

        assertTrue(res);
    }
}
