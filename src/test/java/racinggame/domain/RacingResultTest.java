package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingResultTest {
    private static final String VALIDATE_PARTICIPATE_MIN_MESSAGE = "[ERROR] 최소 1대 이상의 자동차가 참가해야 합니다.";
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String COMMA = ",";

    private RacingResult racingResult;
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        car1 = new Car("car1");
        car2 = new Car("car2");
        car3 = new Car("car3");
        List<Car> cars = Arrays.asList(car1, car2, car3);
        racingResult = new RacingResult(cars);
    }

    @Test
    @DisplayName("실행_결과_테스트")
    void result() {
        car1.play(new RacingNumber(5));
        car1.play(new RacingNumber(5));
        car2.play(new RacingNumber(3));
        car3.play(new RacingNumber(3));
        car3.play(new RacingNumber(6));
        List<String> reports = racingResult.reports();
        assertEquals(3, reports.size());
        assertThat(reports).containsExactly(
            car1.getName() + COLON + DASH + DASH,
            car2.getName() + COLON,
            car3.getName() + COLON + DASH
        );
    }

    @Test
    @DisplayName("경기_우승자_1명")
    void winner_one() {
        car1.play(new RacingNumber(5));
        String byWinner = racingResult.reportByWinner();
        assertEquals(car1.getName(), byWinner);
    }

    @Test
    @DisplayName("경기_우승자_2명")
    void winner_two() {
        car1.play(new RacingNumber(5));
        car3.play(new RacingNumber(5));
        String byWinner = racingResult.reportByWinner();
        assertEquals(car1.getName() + COMMA + car3.getName(), byWinner);
    }

    @Test
    @DisplayName("경기_결과_확인_참가_자동차_0대")
    void winner_participate_zero_exception() {
        assertThatThrownBy(() -> new RacingResult(new ArrayList<>()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(VALIDATE_PARTICIPATE_MIN_MESSAGE);
    }

    @Test
    @DisplayName("경기_우승자_확인_여러번_확인")
    void report_by_winner_method_many_call() {
        car1.play(new RacingNumber(5));
        car3.play(new RacingNumber(5));
        racingResult.reportByWinner();
        String byWinner = racingResult.reportByWinner();
        assertEquals(car1.getName() + COMMA + car3.getName(), byWinner);
    }
}
