package racinggame.view;

import racinggame.domain.RacingResult;

public class RacingOutputView {
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자는 ";
    private static final String WINNER_MESSAGE_POSTFIX = " 입니다.";

    private RacingOutputView() {
    }

    public static void printRacingResultByRound(RacingResult racingResult) {
        for (String report : racingResult.reports()) {
            System.out.println(report);
        }
        System.out.println();
    }

    public static void printRacingWinner(RacingResult racingResult) {
        System.out.println(WINNER_MESSAGE_PREFIX + racingResult.reportByWinner() + WINNER_MESSAGE_POSTFIX);
    }
}
