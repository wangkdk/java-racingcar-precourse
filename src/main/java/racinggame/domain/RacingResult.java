package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    public static final String VALIDATE_PARTICIPATE_MIN_MESSAGE = "[ERROR] 최소 1대 이상의 자동차가 참가해야 합니다.";
    public static final int RACING_PARTICIPATE_MIN_NUMBER = 1;

    private final List<Car> cars;
    private final List<Car> winnerCars;

    protected RacingResult(List<Car> cars) {
        this.cars = cars;
        this.winnerCars = new ArrayList<>();
    }

    public List<String> reports() {
        List<String> reports = new ArrayList<>();
        for (Car car : cars) {
            reports.add(car.report());
        }
        return reports;
    }

    public String reportByWinner() {
        validateCarsSize();
        winnerCars.clear();
        winnerCars.add(cars.get(0));
        for (int i = 1; i < cars.size(); i++) {
            Car car = cars.get(i);
            CarCompareStatus carCompareStatus = car.compareToWinnerPosition(winnerCars.get(0));
            setWinner(carCompareStatus, car);
        }
        return createWinnerReport();
    }

    private void setWinner(CarCompareStatus carCompareStatus, Car car) {
        if (carCompareStatus.isWin()) {
            winnerCars.clear();
            winnerCars.add(car);
        }
        if (carCompareStatus.isDraw()) {
            winnerCars.add(car);
        }
    }

    private String createWinnerReport() {
        List<String> carNames = new ArrayList<>();
        for (Car winnerCar : winnerCars) {
            carNames.add(winnerCar.getName());
        }
        return String.join(",", carNames);
    }

    private void validateCarsSize() {
        if (cars.size() < RACING_PARTICIPATE_MIN_NUMBER) {
            throw new IllegalArgumentException(VALIDATE_PARTICIPATE_MIN_MESSAGE);
        }
    }
}
