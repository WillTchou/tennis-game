package main.utils;

import main.models.PointsEnum;
import main.models.ScoringStateEnum;

import java.util.stream.Stream;

public final class ScoringPointUtils {

    public static PointsEnum[] getScoringPoints(ScoringStateEnum scoringState) {
        return Stream.of(PointsEnum.values())
                .filter(pointsEnum -> pointsEnum.getScoringState().equals(scoringState))
                .toArray(PointsEnum[]::new);
    }
}
