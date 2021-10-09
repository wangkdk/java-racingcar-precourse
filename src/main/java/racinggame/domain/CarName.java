package racinggame.domain;

public class CarName {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 5;
    public static final String VALIDATE_CAR_NAME_MESSAGE = "[ERROR] 자동차 이름은 1자리 이상 5자리 이하로 만들 수 있습니다.";

    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NUMBER || name.length() > MAX_NUMBER) {
            throw new IllegalArgumentException(VALIDATE_CAR_NAME_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
