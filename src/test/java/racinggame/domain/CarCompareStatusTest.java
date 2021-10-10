package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarCompareStatusTest {
    @Test
    @DisplayName("win")
    void win() {
        assertTrue(CarCompareStatus.WIN.isWin());
        assertFalse(CarCompareStatus.DRAW.isWin());
        assertFalse(CarCompareStatus.LOSE.isWin());
    }

    @Test
    @DisplayName("draw")
    void draw() {
        assertTrue(CarCompareStatus.DRAW.isDraw());
        assertFalse(CarCompareStatus.WIN.isDraw());
        assertFalse(CarCompareStatus.LOSE.isDraw());
    }
}
