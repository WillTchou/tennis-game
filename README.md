# Tennis game

## Overview
This project implements a simple tennis score computer following standard tennis rules.
The program calculates the score after each point and determines the winner.

## Rules
The scoring system consist in one game, divided by points :
Each player starts a game with 0 point.<br/>
If the player wins the 1st ball, he will have 15 points.<br/> 2nd balls won : 30 points. 3rd ball won : 40points.<br/>
If a player have 40 points and wins the ball, he wins the game, however there are special rules.
If both players have 40 points the players are “deuce”.<br/>
If the game is in deuce, the winner of the ball will have advantage.<br/>
If the player with advantage wins the ball he wins the game.<br/>
If the player without advantage wins the ball they are back at “deuce”.<br/>
If the player without Advantage wins the point, the score returns to Deuce.

Click [here](http://en.wikipedia.org/wiki/Tennis#Scoring) to get more details about tennis scoring rules

## Input
The program takes a String as input composed of characters representing the winner of each point in a tennis game.
Each character can be for instance:
- 'A' → Player A wins the point
- 'B' → Player B wins the point

Example input:
`ABABAA`

## Output
The program prints the score after each point and finally prints the winner of the game.
Example output for input `ABABAA`:
```
Player A : 15 / Player B : 0
Player A : 15 / Player B : 15
Player A : 30 / Player B : 15
Player A : 30 / Player B : 30
Player A : 40 / Player B : 30
Player A wins the game
```

## Unit Tests
Unit tests have been added to validate the scoring logic, including:
- Standard score progression
- Deuce scenarios
- Advantage handling
- Winning conditions for both players
- Edge cases such as invalid input and empty input.

## Design Decisions
- I created a `TennisGame` class to encapsulate the game logic and state.
- There are one abstract class Rule and two concrete classes ClassicRule and DeuceRule to handle the different game states.
- The game points are enums (ZERO, FIFTEEN, THIRTY, FORTY) to improve readability and maintainability.
- I used recursion to handle the score progression after each point, which simplifies the logic and makes it easier to follow.

## Technical Requirements
Language: **Java 21**<br/>
The implementation exposes a method that:
- Accepts a String input
- Computes the score after each point
- Prints the score progression
- Prints the game winner

## How to Run
1. Clone the repository
2. Go to the project directory (`cd TennisGame`)
3. Compile the Java files (`javac -d bin src/main/**/*.java`)
4. Run the main class with the input string (`java -cp bin main.Main <yourInputString>`)
