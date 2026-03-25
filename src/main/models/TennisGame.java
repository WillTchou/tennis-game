package main.models;

import main.exceptions.InvalidGameInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TennisGame {
    private final String input;
    private Player player1;
    private Player player2;

    public TennisGame(String input) {
        if (input.isBlank()) {
            throw new InvalidGameInputException("Tennis game input cannot be empty");
        }
        this.input = input.trim().toUpperCase();
    }

    public void play() {
        List<Character> players = getPlayersList(input);
        if (players.size() == 2) {
            startTennisGame(players, input);
        } else {
            throw new InvalidGameInputException("Not enough or too many players. Only two players are authorized");
        }
    }

    private void startTennisGame(List<Character> players, String input) {
        player1 = new Player(players.get(0));
        player2 = new Player(players.get(1));
        Rule classicRule = new ClassicRule(player1, player2);
        handleGame(input, classicRule);
    }

    private void handleGame(String input, Rule rule) {
        if(input.length() == 1) {
            checkForBallWinner(rule, input);
            return;
        }
        checkForBallWinner(rule, input);
        changeGameRuleWhetherFortyAll(input, rule);
    }

    private void changeGameRuleWhetherFortyAll(String input, Rule rule) {
        String newInput = input.substring(1);
        if (player1.getPoints().equals(PointsEnum.FORTY) && player2.getPoints().equals(PointsEnum.FORTY)) {
            rule = new DeuceRule(player1, player2);
            ((DeuceRule) rule).resetScore();
            handleGame(newInput, rule);
        } else {
            handleGame(newInput, rule);
        }
    }

    private void checkForBallWinner(Rule rule, String character) {
        Stream.of(this.player1, this.player2)
                .filter(player -> player.getName() == character.charAt(0))
                .findFirst()
                .ifPresent(rule::winsBall);
    }

    private static List<Character> getPlayersList(String input) {
        char firstPlayer = input.charAt(0);
        List<Character> players = new ArrayList<>();
        players.add(firstPlayer);
        for(int i=1; i<input.length(); i++) {
            char characterIndex = input.charAt(i);
            if(!players.contains(characterIndex)) {
                players.add(input.charAt(i));
            }
        }
        return players;
    }
}
