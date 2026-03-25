package main.models;

public class Player {
    private final char name;
    private PointsEnum points;

    public Player(char name) {
        this.name = name;
        this.points = PointsEnum.ZERO;
    }

    public char getName() {
        return this.name;
    }

    public PointsEnum getPoints() {
        return this.points;
    }

    public void setPoints(PointsEnum points) {
        this.points = points;
    }
}
