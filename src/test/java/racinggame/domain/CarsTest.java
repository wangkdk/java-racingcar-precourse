package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private static final String VALIDATE_CAR_NAMES_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
    private static final String VALIDATE_PARTICIPATE_MIN_MESSAGE = "[ERROR] 최소 1대 이상의 자동차가 참가해야 합니다.";

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList("car1", "car2", "car3"));
    }

    @Test
    @DisplayName("자동차_생성_0대의_자동차_예외")
    void cars_init_zero_car() {
        assertThatThrownBy(() -> new Cars(new ArrayList<>()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(VALIDATE_PARTICIPATE_MIN_MESSAGE);
    }

    @Test
    @DisplayName("자동차_여러대_생성_중복된_자동차_이름")
    void cars_init_duplicate_name() {
        assertThatThrownBy(() -> new Cars(Arrays.asList("car1", "car1", "car2")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(VALIDATE_CAR_NAMES_MESSAGE);
    }

    @Test
    @DisplayName("자동차_경주_결과_오브젝트_여러번_호출")
    void racing_result_many_call() {
        assertEquals(cars.racingResult(), cars.racingResult());
    }
}
