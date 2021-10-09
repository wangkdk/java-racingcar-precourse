package racinggame.domain;

public class CarPosition {
    private int position;

    public void moveOneForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
