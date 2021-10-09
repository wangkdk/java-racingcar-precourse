package racinggame.domain;

public class Car {
    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public void play(RacingNumber racingNumber) {
        CarStatus carStatus = racingNumber.match();
        if (CarStatus.GO == carStatus) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
