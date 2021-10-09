package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car1");
    }

    @Test
    @DisplayName("자동차_경주_go")
    void racing_go() {
        CarStatus number4 = car.play(new RacingNumber(4));
        CarStatus number9 = car.play(new RacingNumber(9));

        assertEquals(CarStatus.GO, number4);
        assertEquals(CarStatus.GO, number9);
    }

    @Test
    @DisplayName("자동차_경주_stop")
    void racing_stop() {
        CarStatus number0 = car.play(new RacingNumber(0));
        CarStatus number3 = car.play(new RacingNumber(3));

        assertEquals(CarStatus.STOP, number0);
        assertEquals(CarStatus.STOP, number3);
    }
}
