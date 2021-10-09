package racinggame.domain;

public class Car {
    private final CarName name;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public CarStatus play(RacingNumber racingNumber) {
        return racingNumber.match();
    }
}
