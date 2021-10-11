package racinggame.controller;

import racinggame.domain.Cars;
import racinggame.domain.RacingResult;
import racinggame.view.RacingInputView;
import racinggame.view.RacingOutputView;

public class RacingGame {
    public void play() {
        Cars cars = createCars();
        int playCount = RacingInputView.inputPlayCount();
        RacingResult rankBoard = cars.rankBoard();
        System.out.println("실행 결과");
        for (int i = 1; i <= playCount; i++) {
            cars.play();
            RacingOutputView.racingResultByRound(rankBoard);
        }
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
