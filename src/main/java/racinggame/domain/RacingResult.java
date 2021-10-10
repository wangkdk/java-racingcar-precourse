package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private final List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> reports() {
        List<String> reports = new ArrayList<>();
        for (Car car : cars) {
            reports.add(car.report());
        }
        return reports;
    }
}
