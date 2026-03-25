package main.models;

public enum PointsEnum {
    ZERO("0", ScoringStateEnum.CLASSIC, 0),
    FIFTEEN("15", ScoringStateEnum.CLASSIC, 1),
    THIRTY("30", ScoringStateEnum.CLASSIC, 2),
    FORTY("40", ScoringStateEnum.CLASSIC, 3),
    DEUCE("deuce", ScoringStateEnum.DEUCE, 0),
    ADVANTAGE("advantaged", ScoringStateEnum.DEUCE, 1),
    CLASSIC_WIN("game", ScoringStateEnum.CLASSIC, 4),
    DEUCE_WIN("game", ScoringStateEnum.DEUCE, 2);

    private final String value;
    private final ScoringStateEnum scoringState;
    private final int order;

    PointsEnum(String value,  ScoringStateEnum scoringStateEnum, int order) {
        this.value = value;
        this.scoringState = scoringStateEnum;
        this.order = order;
    }

    public String getValue() {
        return value;
    }

    public ScoringStateEnum getScoringState() {
        return scoringState;
    }

    public int getOrder() {
        return order;
    }
}
