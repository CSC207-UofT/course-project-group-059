package dateAndTimeAttributes;

import java.time.*;


public abstract class Time {
    protected LocalTime startTime;
    protected LocalTime endTime;


    public Time(LocalTime time) {
        this.endTime = time;
    }

    public Time(LocalTime startTime, LocalTime enTime) {
        this.startTime = startTime;
        this.endTime = enTime;
    }

    public LocalTime getTime() {
        return endTime;
    }

    private void setTime(LocalTime time) {
        this.endTime = time;
    }


    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime enTime) {
        this.endTime = enTime;
    }

    public boolean isNow(){
        LocalTime now = LocalTime.now();
        return this.startTime.equals(now) || this.endTime.equals(now);
    }
}
