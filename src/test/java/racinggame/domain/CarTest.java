package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private static final String COLON = " : ";
    public static final String CAR_NAME = "car";
    public static final String WINNER_CAR_NAME = "win";

    private Car car;
    private Car winnerCar;

    @BeforeEach
    void setUp() {
        car = new Car(CAR_NAME);
        winnerCar = new Car(WINNER_CAR_NAME);
    }

    @Test
    @DisplayName("자동차_경주_go")
    void racing_go() {
        car.play(new RacingNumber(4));
        car.play(new RacingNumber(9));
        assertEquals(CAR_NAME + COLON + "--", car.report());
    }

    @Test
    @DisplayName("자동차_경주_stop")
    void racing_stop() {
        car.play(new RacingNumber(0));
        car.play(new RacingNumber(3));
        assertEquals(CAR_NAME + COLON, car.report());
    }

    @Test
    @DisplayName("자동차_위치_비교_승리")
    void car_position_compare_win() {
        car.play(new RacingNumber(5));
        car.play(new RacingNumber(5));
        winnerCar.play(new RacingNumber(5));
        int compareResult = this.car.compareToWinnerPosition(winnerCar);
        assertEquals(1, compareResult);
    }

    @Test
    @DisplayName("자동차_위치_비교_동률")
    void car_position_compare_same() {
        car.play(new RacingNumber(5));
        winnerCar.play(new RacingNumber(5));
        int compareResult = this.car.compareToWinnerPosition(winnerCar);
        assertEquals(0, compareResult);
    }

    @Test
    @DisplayName("자동차_위치_비교_패배")
    void car_position_compare_lose() {
        winnerCar.play(new RacingNumber(5));
        int compareResult = this.car.compareToWinnerPosition(winnerCar);
        assertEquals(-1, compareResult);
    }

    @Test
    @DisplayName("자동차_이름_가져오기")
    void get_car_name() {
        assertEquals(CAR_NAME, car.getName());
    }
}
