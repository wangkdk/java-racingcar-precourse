package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingNumberTest {
    @ParameterizedTest
    @DisplayName("자동차_경주_번호_0_9_검증")
    @ValueSource(ints = {0, 9})
    void racing_number_0_9_valid(int number) {
        new RacingNumber(number);
    }

    @ParameterizedTest
    @DisplayName("자동차_경주_번호_0_9_검증_예외")
    @ValueSource(ints = {-1, 10})
    void racing_number_0_9_valid_exception(int number) {
        assertThatThrownBy(() -> new RacingNumber(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("자동차_경주_match_전진")
    @ValueSource(ints = {4, 9})
    void racing_number_match_go(int number) {
        RacingNumber racingNumber = new RacingNumber(number);
        assertEquals(CarStatus.GO, racingNumber.match());
    }

    @ParameterizedTest
    @DisplayName("자동차_경주_match_멈춤")
    @ValueSource(ints = {0, 3})
    void racing_number_match_stop(int number) {
        RacingNumber racingNumber = new RacingNumber(number);
        assertEquals(CarStatus.STOP, racingNumber.match());
    }
}
