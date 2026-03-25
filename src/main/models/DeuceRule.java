package main.models;

import main.utils.ScoringPointUtils;

public class DeuceRule extends Rule {

    public DeuceRule(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public void winsBall(Player player) {
        final PointsEnum[] points = ScoringPointUtils.getScoringPoints(ScoringStateEnum.DEUCE);
        player.setPoints(points[player.getPoints().getOrder() + 1]);
        checkForWinner(player, PointsEnum.DEUCE_WIN);
        handleScore();
    }

    public void resetScore() {
        player1.setPoints(PointsEnum.DEUCE);
        player2.setPoints(PointsEnum.DEUCE);
        System.out.println("Players are deuce");
    }

    private void handleScore() {
        if (this.player1.getPoints().equals(player2.getPoints())) {
            resetScore();
        }
    }
}
