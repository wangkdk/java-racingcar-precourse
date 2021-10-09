package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarPositionTest {
    @Test
    @DisplayName("자동차_위치_생성")
    void car_position_init() {
        new CarPosition();
    }

    @Test
    @DisplayName("자동차_위치_증가")
    void car_position_move() {
        CarPosition carPosition = new CarPosition();
        carPosition.moveOneForward();
        carPosition.moveOneForward();
        assertEquals(2, carPosition.getPosition());
    }
}
