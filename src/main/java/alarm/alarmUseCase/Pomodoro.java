package alarm.alarmUseCase;

import alarm.alarmClockEntities.AlarmClock;

public class Pomodoro {
    private int pomodoroCount;
    private AlarmClock alarm;

    //constructor
    public Pomodoro() {
        this.pomodoroCount = 0;
        startWorkAlarm();
    }

    //changes and resets pomodoro count when needed
    private void updateCount() {
        this.pomodoroCount++;

        if (pomodoroCount > 7) { //reset count
            this.pomodoroCount = 0;
        }
    }

    //starts alarm for working and returns a message
    private String startWorkAlarm() {
        this.alarm = new AlarmClock(25);
        return "Start working now!";
    }

    //starts alarm for relaxing and returns a message
    private String startRelaxAlarm(int dur) {
        this.alarm = new AlarmClock(dur);
        return "Start relaxing now!";
    }

    //run this every minute
    public String update() {
        String message = "";
        if (this.alarm.sound()) {
            //pomodoro count - work: 0, 2, 4, 6, short break: 1, 3, 5, long break: 7
            updateCount();

            if (this.pomodoroCount%2 == 0) {
                message = startWorkAlarm();
            }
            else if (this.pomodoroCount == 7) {
                message = startRelaxAlarm(15); //take long break
            }
            else {
                message = startRelaxAlarm(5); //take short break
            }
        }
        return message;
    }
}
