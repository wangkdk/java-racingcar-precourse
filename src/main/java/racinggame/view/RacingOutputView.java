package racinggame.view;

import racinggame.domain.RacingResult;

public class RacingOutputView {
    public static void racingResultByRound(RacingResult rankBoard) {
        for (String report : rankBoard.reports()) {
            System.out.println(report);
            System.out.println();
        }
    }
}
