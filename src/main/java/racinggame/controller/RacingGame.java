package racinggame.controller;

import racinggame.domain.Cars;
import racinggame.view.RacingInputView;

public class RacingGame {
    public void play() {
        Cars cars = createCars();
        int playCount = RacingInputView.inputPlayCount();
    }

    private static Cars createCars() {
        try {
            return new Cars(RacingInputView.inputCarNames());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return createCars();
        }
    }
}
