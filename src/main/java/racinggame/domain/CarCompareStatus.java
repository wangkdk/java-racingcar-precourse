package racinggame.domain;

public enum CarCompareStatus {
    WIN, DRAW, LOSE;

    public boolean isWin() {
        return this == WIN;
    }

    public boolean isDraw() {
        return this == DRAW;
    }
}
