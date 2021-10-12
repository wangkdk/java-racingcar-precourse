package racinggame.domain;

public class Car {
    private static final String COLON = " : ";
    private static final String DASH = "-";

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
        StringBuilder positionDisplay = new StringBuilder();
        for (int i = 0; i < position.getPosition(); i++) {
            positionDisplay.append(DASH);
        }
        return positionDisplay;
    }

    public CarCompareStatus compareToWinnerPosition(Car winnerCar) {
        int compare = Integer.compare(this.position.getPosition(), winnerCar.position.getPosition());
        if (compare == 1) {
            return CarCompareStatus.WIN;
        }
        if (compare == 0) {
            return CarCompareStatus.DRAW;
        }
        return CarCompareStatus.LOSE;
    }

    public String getName() {
        return name.getName();
    }
}
