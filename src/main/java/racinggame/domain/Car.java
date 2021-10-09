package racinggame.domain;

public class Car {
    private final static String COLON = " : ";
    private final static String DASH = "-";

    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition();
    }

    public void play(RacingNumber racingNumber) {
        CarStatus carStatus = racingNumber.match();
        if (carStatus.isGo()) {
            position.moveOneForward();
        }
    }

    public String report() {
        return name.getName() + COLON + createPositionDisplay();
    }

    private StringBuilder createPositionDisplay() {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < position.getPosition(); i++) {
            display.append(DASH);
        }
        return display;
    }
}
