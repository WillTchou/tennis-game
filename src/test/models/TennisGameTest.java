package test.models;

import main.exceptions.InvalidGameInputException;
import main.models.TennisGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TennisGameTest {
    TennisGame tennisGame;
    OutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABC", "AAABBC", "ABCD", "AAAA", "A", "Aa"})
    void testTooManyPlayers(String value) {
        tennisGame = new TennisGame(value);
        assertThrows(InvalidGameInputException.class, () -> tennisGame.play());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABABAA", " aBABAA ", "ababaa"})
    void testPrintScores(String value) {
        tennisGame = new TennisGame(value);
        tennisGame.play();
        assertEquals("""
                Player A : 15 / Player B : 0
                Player A : 15 / Player B : 15
                Player A : 30 / Player B : 15
                Player A : 30 / Player B : 30
                Player A : 40 / Player B : 30
                Player A wins the game
                """, outputStream.toString());
    }

    @Test
    void testPrintScoresWithDeuceClassic() {
        tennisGame = new TennisGame("ABABABAA");
        tennisGame.play();
        assertEquals("""
                Player A : 15 / Player B : 0
                Player A : 15 / Player B : 15
                Player A : 30 / Player B : 15
                Player A : 30 / Player B : 30
                Player A : 40 / Player B : 30
                Player A : 40 / Player B : 40
                Players are deuce
                Player A : advantaged / Player B : deuce
                Player A wins the game
                """, outputStream.toString());
    }

    @Test
    void testPrintScoresWithNotFinishedClassic() {
        tennisGame = new TennisGame("ABABABABAB");
        tennisGame.play();
        assertEquals("""
                Player A : 15 / Player B : 0
                Player A : 15 / Player B : 15
                Player A : 30 / Player B : 15
                Player A : 30 / Player B : 30
                Player A : 40 / Player B : 30
                Player A : 40 / Player B : 40
                Players are deuce
                Player A : advantaged / Player B : deuce
                Player A : advantaged / Player B : advantaged
                Players are deuce
                Player A : advantaged / Player B : deuce
                Player A : advantaged / Player B : advantaged
                Players are deuce
                """, outputStream.toString());
    }
}
