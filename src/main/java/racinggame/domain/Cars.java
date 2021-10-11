package racinggame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class Cars {
    private static final String VALIDATE_CAR_NAMES_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
    private static final String VALIDATE_PARTICIPATE_MIN_MESSAGE = "[ERROR] 최소 1대 이상의 자동차가 참가해야 합니다.";
    private static final int RACING_MIN_NUMBER = 0;
    private static final int RACING_MAX_NUMBER = 9;
    private static final int RACING_PARTICIPATE_MIN_NUMBER = 1;

    private final List<Car> cars;
    private final RacingResult racingResult;

    public Cars(List<String> carNames) {
        validateCarsSize(carNames);
        validateDuplicateCarNames(carNames);
        cars = mapCars(carNames);
        racingResult = new RacingResult(cars);
    }

    private void validateCarsSize(List<String> carNames) {
        if (carNames.size() < RACING_PARTICIPATE_MIN_NUMBER) {
            throw new IllegalArgumentException(VALIDATE_PARTICIPATE_MIN_MESSAGE);
        }
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

    public void play() {
        for (Car car : cars) {
            car.play(new RacingNumber(Randoms.pickNumberInRange(RACING_MIN_NUMBER, RACING_MAX_NUMBER)));
        }
    }

    public RacingResult racingResult() {
        return racingResult;
    }
}
