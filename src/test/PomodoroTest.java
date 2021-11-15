import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PomodoroTest {
    Pomodoro p = new Pomodoro();

    @Test
    void updateTest() {
        String expected;
        for (int k = 0; k < 2; k++) {
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 24; i++) {
                    assertEquals("", p.update());
                }
                assertEquals("Start relaxing now!", p.update());
                for (int i = 0; i < 4; i++) {
                    assertEquals("", p.update());
                }
                assertEquals("Start working now!", p.update());
            }
            for (int i = 0; i < 24; i++) {
                assertEquals("", p.update());
            }
            assertEquals("Start relaxing now!", p.update());
            for (int i = 0; i < 14; i++) {
                assertEquals("", p.update());
            }
            assertEquals("Start working now!", p.update());
        }
    }
}