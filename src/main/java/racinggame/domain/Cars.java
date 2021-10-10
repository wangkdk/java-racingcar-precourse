package racinggame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class Cars {
    public static final String VALIDATE_CAR_NAMES_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
    public static final int RACING_MIN_NUMBER = 0;
    public static final int RACING_MAX_NUMBER = 9;

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateDuplicateCarNames(carNames);
        cars = mapCars(carNames);
    }

    private void validateDuplicateCarNames(List<String> carNames) {
        int carNamesSize = carNames.size();
        Set<String> nonDuplicateCarNames = new HashSet<>(carNames);
        if (nonDuplicateCarNames.size() != carNamesSize) {
            throw new IllegalArgumentException(VALIDATE_CAR_NAMES_MESSAGE);
        }
    }

    private static List<Car> mapCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public RacingResult play() {
        RacingResult racingResult = new RacingResult(this.cars);
        for (Car car : cars) {
            car.play(new RacingNumber(Randoms.pickNumberInRange(RACING_MIN_NUMBER, RACING_MAX_NUMBER)));
        }
        return racingResult;
    }
}
