package test.models;

import main.models.ClassicRule;
import main.models.Player;
import main.models.PointsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassicRuleTest {

    ClassicRule rule;
    OutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        Player player1 = new Player('C');
        Player player2 = new Player('D');
        rule = new ClassicRule(player1, player2);
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testPrintWhenPlayerWinsBall() {
        rule.winsBall(rule.getPlayer1());
        assertEquals(PointsEnum.FIFTEEN, rule.getPlayer1().getPoints());
        assertEquals("Player C : 15 / Player D : 0\n", outputStream.toString());
    }

    @Test
    void testPrintWhenPlayerWinsGame() {
        rule.winsBall(rule.getPlayer1());
        rule.winsBall(rule.getPlayer1());
        rule.winsBall(rule.getPlayer1());
        rule.winsBall(rule.getPlayer1());
        assertEquals(PointsEnum.CLASSIC_WIN, rule.getPlayer1().getPoints());
        assertEquals("""
                Player C : 15 / Player D : 0
                Player C : 30 / Player D : 0
                Player C : 40 / Player D : 0
                Player C wins the game
                """, outputStream.toString());
    }
}
