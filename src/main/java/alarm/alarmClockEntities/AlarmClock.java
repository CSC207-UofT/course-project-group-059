package alarm.alarmClockEntities;

public class AlarmClock {
    private int duration;

    public AlarmClock(int dur) {
        this.duration = dur;
    }

    //updates duration and returns true if duration is 0
    public boolean sound() {
        this.duration--;
        return this.duration == 0;
    }
}
