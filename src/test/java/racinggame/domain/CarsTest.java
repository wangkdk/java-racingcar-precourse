package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    public static final String VALIDATE_CAR_NAMES_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList("car1", "car2", "car3"));
    }

    @Test
    @DisplayName("자동차_여러대_생성_중복된_자동차_이름")
    void cars_init_duplicate_name() {
        assertThatThrownBy(() -> new Cars(Arrays.asList("car1", "car1", "car2")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(VALIDATE_CAR_NAMES_MESSAGE);
    }

    @Test
    @DisplayName("자동차_경주_결과")
    void racing_cars_reports() {
        cars.play();
        cars.play();
        RacingResult racingResult = cars.play();
        assertThat(racingResult.getReports())
            .hasSize(12);
    }
}
