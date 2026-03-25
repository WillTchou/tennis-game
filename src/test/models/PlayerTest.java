package test.models;

import main.models.Player;
import main.models.PointsEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void testGetName() {
        final char playerName = 'Y';
        Player player = new Player(playerName);
        Assertions.assertEquals(playerName,  player.getName());
    }

    @Test
    void testGetPoints() {
        Player player = new Player('Z');
        Assertions.assertEquals(PointsEnum.ZERO, player.getPoints());
    }

    @Test
    void testSetPoints() {
        Player player = new Player('X');
        player.setPoints(PointsEnum.FIFTEEN);
        Assertions.assertEquals(PointsEnum.FIFTEEN, player.getPoints());
    }
}
