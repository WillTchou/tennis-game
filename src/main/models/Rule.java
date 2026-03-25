package main.models;

public abstract class Rule {
    protected Player player1;
    protected Player player2;

    public Rule(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    protected void checkForWinner(Player player, PointsEnum pointsEnum) {
        if(player.getPoints().equals(pointsEnum)) {
            System.out.println("Player " + player.getName() + " wins the game");
        } else {
            System.out.printf("Player %s : %s / Player %s : %s\n", player1.getName(), player1.getPoints().getValue(), player2.getName(), player2.getPoints().getValue());
        }
    }

    public abstract void winsBall(Player player);

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
