package racinggame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;

public class ApplicationTest extends NSTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 전진_정지() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,javaji");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("전진_정지_공동_우승")
    void go_stop_many_winner() {
        assertRandomTest(() -> {
            run("test1,test2,test3", "3");
            verify("test1 : -", "test2 : -", "test3 : ", "최종 우승자는 test1,test2 입니다.");
        }, MOVING_FORWARD, MOVING_FORWARD, STOP);
    }

    @Test
    @DisplayName("전진_여러번_정지_공동_우승")
    void many_go_stop_many_winner() {
        assertRandomTest(() -> {
            run("test1,test2,test3", "2");
            verify("test1 : -", "test2 : -", "test3 : -", "test1 : --", "test2 : -", "test3 : --",
                "최종 우승자는 test1,test3 입니다.");
        }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD);
    }

    @Test
    @DisplayName("이름에_대한_예외_처리_공백만_입력")
    void name_trim_exception() {
        assertSimpleTest(() -> {
            runNoLineFound(" ");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("이름에_대한_예외_처리_콤마만_입력")
    void name_comma_exception() {
        assertSimpleTest(() -> {
            runNoLineFound(",");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("경기_횟수에_대한_예외_처리_0_입력")
    void play_count_min() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,woni", "0");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("경기_횟수에_대한_예외_처리_공백_입력")
    void play_count_space_input() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,woni", " ");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("경기_횟수에_대한_예외_처리_문자_입력")
    void play_count_char_input() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,woni", "aa");
            verify(ERROR_MESSAGE);
        });
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
