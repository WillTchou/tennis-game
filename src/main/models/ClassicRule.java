package main.models;

import main.utils.ScoringPointUtils;

public class ClassicRule extends Rule {

    public ClassicRule(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public void winsBall(Player player) {
        final PointsEnum[] points = ScoringPointUtils.getScoringPoints(ScoringStateEnum.CLASSIC);
        player.setPoints(points[player.getPoints().getOrder() + 1]);
        checkForWinner(player, PointsEnum.CLASSIC_WIN);
    }
}
