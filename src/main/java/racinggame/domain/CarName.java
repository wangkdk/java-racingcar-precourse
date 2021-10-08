package racinggame.domain;

public class CarName {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 5;

    public static boolean validateName(String name) {
        return name.length() >= MIN_NUMBER && name.length() <= MAX_NUMBER;
    }
}
