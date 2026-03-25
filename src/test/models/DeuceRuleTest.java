package test.models;

import main.models.DeuceRule;
import main.models.Player;
import main.models.PointsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeuceRuleTest {

    DeuceRule rule;
    OutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        Player player1 = new Player('C');
        Player player2 = new Player('D');
        rule = new DeuceRule(player1, player2);
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testPrintWhenPlayerWinsBall() {
        rule.winsBall(rule.getPlayer1());
        assertEquals(PointsEnum.ADVANTAGE, rule.getPlayer1().getPoints());
        assertEquals("Player C : advantaged / Player D : 0\n", outputStream.toString());
    }

    @Test
    void testPrintWhenPlayerWinsGame() {
        rule.winsBall(rule.getPlayer1());
        rule.winsBall(rule.getPlayer1());
        assertEquals(PointsEnum.DEUCE_WIN, rule.getPlayer1().getPoints());
        assertEquals("""
                Player C : advantaged / Player D : 0
                Player C wins the game
                """, outputStream.toString());
    }

    @Test
    void testResetScore() {
        rule.resetScore();
        assertEquals(PointsEnum.DEUCE, rule.getPlayer1().getPoints());
        assertEquals(PointsEnum.DEUCE, rule.getPlayer2().getPoints());
    }
}
