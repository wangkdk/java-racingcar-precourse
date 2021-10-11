package racinggame.controller;

import racinggame.domain.Cars;
import racinggame.view.RacingInputView;
import racinggame.view.RacingOutputView;

public class RacingGame {
    public static final String PLAY_RESULT_MESSAGE = "실행 결과";

    public void start() {
        Cars cars = createCars();
        playGame(cars);
        RacingOutputView.printRacingWinner(cars.racingResult());
    }

    private static Cars createCars() {
        try {
            return new Cars(RacingInputView.inputCarNames());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return createCars();
        }
    }

    private static void playGame(Cars cars) {
        int playCount = RacingInputView.inputPlayCount();
        System.out.println(PLAY_RESULT_MESSAGE);
        for (int i = 1; i <= playCount; i++) {
            cars.play();
            RacingOutputView.printRacingResultByRound(cars.racingResult());
        }
    }
}
