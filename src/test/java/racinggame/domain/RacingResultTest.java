package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingResultTest {
    private RacingResult racingResult;

    @BeforeEach
    void setUp() {
        List<Car> cars = Arrays.asList(
            new Car("test1"),
            new Car("test2"),
            new Car("test3")
        );
        racingResult = new RacingResult(cars);
    }

    @Test
    @DisplayName("실행_결과_테스트")
    void result() {
        List<String> reports = racingResult.reports();
        assertEquals(3, reports.size());
        assertThat(reports).containsExactly("test1 : ", "test2 : ", "test3 : ");
    }
}
