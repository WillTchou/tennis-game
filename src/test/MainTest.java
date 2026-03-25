package test;

import main.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    OutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testMainWithoutInput() {
        String[] args = {};
        assertThrows(IllegalArgumentException.class, () -> Main.main(args));
    }

    @Test
    void testMain() {
        String[] args = {"ABABAA"};
        Main.main(args);
        assertEquals("""
                Player A : 15 / Player B : 0
                Player A : 15 / Player B : 15
                Player A : 30 / Player B : 15
                Player A : 30 / Player B : 30
                Player A : 40 / Player B : 30
                Player A wins the game
                """, outputStream.toString());
    }
}