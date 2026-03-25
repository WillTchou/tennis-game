package main;

import main.models.TennisGame;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No input provided.");
        }
        TennisGame tennisGame = new TennisGame(args[0]);
        tennisGame.play();
    }
}