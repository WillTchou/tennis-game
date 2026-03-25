package test.utils;

import main.models.PointsEnum;
import main.models.ScoringStateEnum;
import main.utils.ScoringPointUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoringPointUtilsTest {

    @Test
    void testGetScoringPointsForClassicGame() {
        PointsEnum[] results = ScoringPointUtils.getScoringPoints(ScoringStateEnum.CLASSIC);
        PointsEnum[] pointsEnums = {PointsEnum.ZERO, PointsEnum.FIFTEEN, PointsEnum.THIRTY, PointsEnum.FORTY, PointsEnum.CLASSIC_WIN};
        Assertions.assertArrayEquals(results, pointsEnums);
    }

    @Test
    void testGetScoringPointsForDeuceGame() {
        PointsEnum[] results = ScoringPointUtils.getScoringPoints(ScoringStateEnum.DEUCE);
        PointsEnum[] pointsEnums = {PointsEnum.DEUCE, PointsEnum.ADVANTAGE, PointsEnum.DEUCE_WIN};
        Assertions.assertArrayEquals(results, pointsEnums);
    }

    @Test
    void testGetScoringPointsWhenScoringStateEnumIsNull() {
        PointsEnum[] results = ScoringPointUtils.getScoringPoints(null);
        Assertions.assertArrayEquals(new PointsEnum[0], results);
    }
}
