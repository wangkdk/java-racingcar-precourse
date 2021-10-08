package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {
    public static final String VALIDATE_CAR_NAME_MESSAGE = "[ERROR] 자동차 이름은 1자리 이상 5자리 이하로 만들 수 있습니다.";

    @Test
    @DisplayName("자동차_이름_1_5_검증")
    void validate_car_name_1_5() {
        new CarName("t");
        new CarName("test1");
    }

    @Test
    @DisplayName("자동차_이름_예외")
    void validate_car_name_exception() {
        assertThatThrownBy(() -> new CarName(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(VALIDATE_CAR_NAME_MESSAGE);

        assertThatThrownBy(() -> new CarName("test12"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(VALIDATE_CAR_NAME_MESSAGE);
    }
}
