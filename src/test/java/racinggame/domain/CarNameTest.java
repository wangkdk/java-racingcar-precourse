package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    private static final String VALIDATE_CAR_NAME_MESSAGE = "[ERROR] 자동차 이름은 1자리 이상 5자리 이하로 만들 수 있습니다.";

    @ParameterizedTest
    @DisplayName("자동차_이름_1_5_검증")
    @ValueSource(strings = {"t", "test1"})
    void validate_car_name_1_5(String name) {
        new CarName(name);
    }

    @ParameterizedTest
    @DisplayName("자동차_이름_예외")
    @ValueSource(strings = {"", "test12"})
    void validate_car_name_exception(String name) {
        assertThatThrownBy(() -> new CarName(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(VALIDATE_CAR_NAME_MESSAGE);
    }

    @Test
    @DisplayName("자동차_이름_가져오기")
    void get_car_name() {
        String name = "test1";
        CarName carName = new CarName(name);
        assertEquals(name, carName.getName());
    }
}
