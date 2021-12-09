import alarm.alarmUseCase.Pomodoro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PomodoroTest {
    int workInt = 1;
    int shortDur = 1;
    int workDur = 1;

    Pomodoro p = new Pomodoro(workInt, shortDur, workDur);

    @Test
    public void updateTest() {
        for (int k = 0; k < 2; k++) {
            for (int j = 0; j < workInt-1; j++) {
                for (int i = 0; i < workDur-1; i++) {
                    Assertions.assertEquals("", p.update());
                }
                Assertions.assertEquals(Pomodoro.getBreakMsg(), p.update());

                for (int i = 0; i < shortDur-1; i++) {
                    Assertions.assertEquals("", p.update());
                }
                Assertions.assertEquals(Pomodoro.getWorkMsg(), p.update());
            }

            for (int i = 0; i < workDur-1; i++) {
                Assertions.assertEquals("", p.update());
            }
            Assertions.assertEquals(Pomodoro.getBreakMsg(), p.update());
        }
    }
}