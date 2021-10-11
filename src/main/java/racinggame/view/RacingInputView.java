package racinggame.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;

public class RacingInputView {
    private static final int PLAY_COUNT_MIN_NUMBER = 1;
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_PLAY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String VALID_PLAY_COUNT_MESSAGE = "[ERROR] 경주 회수는 1 이상 숫자로만 입력 가능합니다.";
    private static final String COMMA = ",";

    private RacingInputView() {
    }

    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String carNames = Console.readLine().trim();
        String[] split = carNames.split(COMMA);
        return new ArrayList<>(Arrays.asList(split));
    }

    public static int inputPlayCount() {
        System.out.println(INPUT_PLAY_COUNT_MESSAGE);
        String inputPlayCount = Console.readLine();
        System.out.println();
        return convertToPlayCount(inputPlayCount);
    }

    private static int convertToPlayCount(String inputPlayCount) {
        try {
            int playCount = Integer.parseInt(inputPlayCount);
            validateMinPlayCount(playCount);
            return playCount;
        } catch (IllegalArgumentException exception) {
            System.out.println(VALID_PLAY_COUNT_MESSAGE);
            return inputPlayCount();
        }
    }

    private static void validateMinPlayCount(int playCount) {
        if (playCount < PLAY_COUNT_MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
