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
            car1.getName() + " : " + "--",
            car2.getName() + " : ",
            car3.getName() + " : " + "-"
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
        assertEquals(car1.getName() + "," + car3.getName(), byWinner);
    }
}
