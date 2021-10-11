package racinggame.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;

public class RacingInputView {
    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String COMMA = ",";

    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String carNames = Console.readLine();
        String[] split = carNames.split(COMMA);
        return new ArrayList<>(Arrays.asList(split));
    }
}
