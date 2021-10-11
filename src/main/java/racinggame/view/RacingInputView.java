package racinggame.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;

public class RacingInputView {
    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_PLAY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String VALID_PLAY_COUNT_MESSAGE = "[ERROR] 경주 횟수는 숫자로만 입력 가능합니다.";
    public static final String COMMA = ",";

    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String carNames = Console.readLine();
        String[] split = carNames.split(COMMA);
        return new ArrayList<>(Arrays.asList(split));
    }

    public static int inputPlayCount() {
        System.out.println(INPUT_PLAY_COUNT_MESSAGE);
        String playCount = Console.readLine();
        try {
            return Integer.parseInt(playCount);
        } catch (NumberFormatException exception) {
            System.out.println(VALID_PLAY_COUNT_MESSAGE);
            return inputPlayCount();
        }
    }
}
