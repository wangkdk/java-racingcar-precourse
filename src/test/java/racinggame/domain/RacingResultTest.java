package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingResultTest {
    private RacingResult racingResult;

    @BeforeEach
    void setUp() {
        racingResult = new RacingResult();
    }

    @Test
    @DisplayName("결과 입력 테스트")
    void add_report() {
        String report1 = "test1";
        String report2 = "test2";
        String report3 = "test3";
        racingResult.addReport(report1);
        racingResult.addReport(report2);
        racingResult.addReport(report3);
        assertThat(racingResult.getReports())
            .containsExactly(report1, report2, report3);
    }
}
