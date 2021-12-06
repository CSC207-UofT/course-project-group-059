package alarm.alarmUseCase;

import alarm.alarmClockEntities.AlarmClock;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Pomodoro {
    private final static String workMsg = "Start working now!";
    private final static String breakMsg = "Start relaxing now!";

    private int pomodoroCount;
    private AlarmClock alarm;

    private final int finalIndex; //index of last interval in cycle (long break)
    private final int shortBreakDuration, longBreakDuration, workDuration;

    //constructor
    public Pomodoro(int workIntervals, int shortDur, int longDur, int workDur) {
        this.pomodoroCount = 0;

        this.finalIndex = workIntervals *2 - 1;

        this.shortBreakDuration = shortDur;
        this.longBreakDuration = longDur;
        this.workDuration = workDur;
        startWorkAlarm();
        repeatUpdate();
    }

    //changes and resets pomodoro count when needed
    private void updateCount() {
        this.pomodoroCount++;

        if (pomodoroCount > this.finalIndex) { //reset count
            this.pomodoroCount = 0;
        }
    }

    //starts alarm for working and returns a message
    private String startWorkAlarm() {
        this.alarm = new AlarmClock(this.workDuration);
        return workMsg;
    }

    //starts alarm for relaxing and returns a message
    private String startRelaxAlarm(int dur) {
        this.alarm = new AlarmClock(dur);
        return breakMsg;
    }

    //run this every minute
    public String update() {
        int duration = this.alarm.updateDuration();
        String message = duration + " minutes remaining.";
        if (duration == 0) {
            updateCount();

            if (this.pomodoroCount%2 == 0) {
                message = startWorkAlarm();
            }
            else if (this.pomodoroCount == this.finalIndex) { //last interval in cycle
                // message = startRelaxAlarm(this.longBreakDuration); //take long break
                message = "Pomodoro session complete.";
            }
            else {
                message = startRelaxAlarm(this.shortBreakDuration); //take short break
            }
        }
        return message;
    }

    // Repeats update method every minute
    public void repeatUpdate() {
        while (true) {
            try {
//                TimeUnit.MINUTES.sleep(1);

                // Repeating every second, use for testing or demo
                TimeUnit.SECONDS.sleep(1);

                String message = update();
                System.out.println(message);
                if (Objects.equals(message, "Pomodoro session complete.")) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getWorkMsg() {
        return workMsg;
    }

    public static String getBreakMsg() {
        return breakMsg;
    }
}
