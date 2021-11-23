import alarm.alarmUseCase.Pomodoro;
import org.junit.Test;

import static org.junit.Assert.*;

public class PomodoroTest {
    Pomodoro p = new Pomodoro();

    @Test
    public void updateTest() {
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