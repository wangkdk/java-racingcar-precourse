package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingNumberTest {
    @Test
    @DisplayName("자동차_경주_번호_0_9_검증")
    void racing_number_0_9_valid() {
        new RacingNumber(0);
        new RacingNumber(9);
    }

    @Test
    @DisplayName("자동차_경주_번호_0_9_검증_예외")
    void racing_number_0_9_valid_exception() {
        assertThatThrownBy(() -> new RacingNumber(-1))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new RacingNumber(10))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차_경주_match_검증")
    void racing_number_match_valid() {
        RacingNumber go4 = new RacingNumber(4);
        RacingNumber go9 = new RacingNumber(9);
        RacingNumber stop0 = new RacingNumber(0);
        RacingNumber stop3 = new RacingNumber(3);

        assertEquals(CarStatus.GO, go4.match());
        assertEquals(CarStatus.GO, go9.match());
        assertEquals(CarStatus.STOP, stop0.match());
        assertEquals(CarStatus.STOP, stop3.match());
    }
}
