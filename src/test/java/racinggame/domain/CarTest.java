package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private final static String COLON = " : ";
    public static final String CAR_NAME = "car1";

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(CAR_NAME);
    }

    @Test
    @DisplayName("자동차_경주_go")
    void racing_go() {
        car.play(new RacingNumber(4));
        car.play(new RacingNumber(9));
        assertEquals(CAR_NAME + COLON + "--", car.report());
    }

    @Test
    @DisplayName("자동차_경주_stop")
    void racing_stop() {
        car.play(new RacingNumber(0));
        car.play(new RacingNumber(3));
        assertEquals(CAR_NAME + COLON, car.report());
    }
}
