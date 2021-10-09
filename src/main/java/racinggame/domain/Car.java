package racinggame.domain;

public class Car {
    public Car(String name) {
    }

    public CarStatus play(RacingNumber racingNumber) {
        return racingNumber.match();
    }
}
