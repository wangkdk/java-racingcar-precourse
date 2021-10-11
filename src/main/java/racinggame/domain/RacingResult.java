package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private final List<Car> cars;
    private final List<Car> winnerCars;

    public RacingResult(List<Car> cars) {
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
        StringBuilder report = new StringBuilder(winnerCars.get(0).getName());
        for (int i = 1; i < winnerCars.size(); i++) {
            report.append(",").append(winnerCars.get(i).getName());
        }
        return report.toString();
    }
}
