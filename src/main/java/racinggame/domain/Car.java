package racinggame.domain;

public class Car {
    public static final int STANDARD_NUMBER = 4;

    public Car(String name) {
    }

    public CarStatus play(int number) {
        if (number >= STANDARD_NUMBER) {
            return CarStatus.GO;
        }
        return CarStatus.STOP;
    }
}
