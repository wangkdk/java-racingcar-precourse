package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {
    @Test
    @DisplayName("자동차_이름_1_5_검증")
    void validate_car_name_1_5() {
        assertTrue(CarName.validateName("t"));
        assertTrue(CarName.validateName("test1"));
        assertFalse(CarName.validateName("test12"));
        assertFalse(CarName.validateName(""));
    }
}
