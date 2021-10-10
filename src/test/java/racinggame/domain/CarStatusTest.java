package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarStatusTest {
    @Test
    @DisplayName("isGo_테스트")
    void go() {
        assertTrue(CarStatus.GO.isGo());
        assertFalse(CarStatus.STOP.isGo());
    }
}
