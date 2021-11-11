package timeEntities;

import abstractClasses.Time;

import java.time.LocalTime;

public class TimeRange extends Time {
    private LocalTime startTime;
    private LocalTime enTime;

    public TimeRange(LocalTime startTime, LocalTime enTime) {
        this.startTime = startTime;
        this.enTime = enTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEnTime() {
        return enTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEnTime(LocalTime enTime) {
        this.enTime = enTime;
    }


    @Override
    public String toString() {
        return "TimeRange{" +
                "startTime=" + startTime +
                ", enTime=" + enTime +
                '}';
    }
}
