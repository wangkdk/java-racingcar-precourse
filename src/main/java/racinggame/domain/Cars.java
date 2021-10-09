package racinggame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    public static final String VALIDATE_CAR_NAMES_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";

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
}
