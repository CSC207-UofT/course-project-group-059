package abstractClasses;

import java.time.*;


public abstract class Time {
    protected LocalTime time;

    public Time() {
    }

    public Time(LocalTime time) {
        this.time = time;
    }

    protected LocalTime getTime() {
        return time;
    }

    private void setTime(LocalTime time) {
        this.time = time;
    }
}
