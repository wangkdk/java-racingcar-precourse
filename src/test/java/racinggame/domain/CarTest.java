package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String CAR_NAME = "car";
    private static final String WINNER_CAR_NAME = "win";

    private Car car;
    private Car winnerCar;

    @BeforeEach
    void setUp() {
        car = new Car(CAR_NAME);
        winnerCar = new Car(WINNER_CAR_NAME);
    }

    @ParameterizedTest
    @DisplayName("자동차_경주_go")
    @ValueSource(ints = {4, 9})
    void racing_go(int number) {
        car.play(new RacingNumber(number));
        assertEquals(CAR_NAME + COLON + DASH, car.report());
    }

    @ParameterizedTest
    @DisplayName("자동차_경주_stop")
    @ValueSource(ints = {0, 3})
    void racing_stop(int number) {
        car.play(new RacingNumber(number));
        assertEquals(CAR_NAME + COLON, car.report());
    }

    @Test
    @DisplayName("자동차_위치_비교_승리")
    void car_position_compare_win() {
        car.play(new RacingNumber(5));
        car.play(new RacingNumber(5));
        winnerCar.play(new RacingNumber(5));
        CarCompareStatus carCompareStatus = this.car.compareToWinnerPosition(winnerCar);
        assertEquals(CarCompareStatus.WIN, carCompareStatus);
    }

    @Test
    @DisplayName("자동차_위치_비교_동률")
    void car_position_compare_same() {
        car.play(new RacingNumber(5));
        winnerCar.play(new RacingNumber(5));
        CarCompareStatus carCompareStatus = this.car.compareToWinnerPosition(winnerCar);
        assertEquals(CarCompareStatus.DRAW, carCompareStatus);
    }

    @Test
    @DisplayName("자동차_위치_비교_패배")
    void car_position_compare_lose() {
        winnerCar.play(new RacingNumber(5));
        CarCompareStatus carCompareStatus = this.car.compareToWinnerPosition(winnerCar);
        assertEquals(CarCompareStatus.LOSE, carCompareStatus);
    }

    @Test
    @DisplayName("자동차_이름_가져오기")
    void get_car_name() {
        assertEquals(CAR_NAME, car.getName());
    }
}
