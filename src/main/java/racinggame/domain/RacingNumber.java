package racinggame.domain;

public class RacingNumber {
    private static final int RACING_STANDARD_NUMBER = 4;
    private static final int RACING_MIN_NUMBER = 0;
    private static final int RACING_MAX_NUMBER = 9;
    private static final String VALIDATE_RACING_NUMBER_MESSAGE = "[ERROR] 자동차 경주 번호는 0 이상 9 이하 값이여야 합니다.";

    private final int number;

    public RacingNumber(int number) {
        validateRacingNumber(number);
        this.number = number;
    }

    private void validateRacingNumber(int number) {
        if (number < RACING_MIN_NUMBER || number > RACING_MAX_NUMBER) {
            throw new IllegalArgumentException(VALIDATE_RACING_NUMBER_MESSAGE);
        }
    }

    public CarStatus match() {
        if (number >= RACING_STANDARD_NUMBER) {
            return CarStatus.GO;
        }
        return CarStatus.STOP;
    }
}
