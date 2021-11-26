package dateAndTimeAttributes;

import java.time.LocalTime;

public class TimeRange extends Time {

    public TimeRange(LocalTime startTime, LocalTime endTime) {
       super(startTime,endTime);
    }

    @Override
    public String toString() {
        return "TimeRange{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
