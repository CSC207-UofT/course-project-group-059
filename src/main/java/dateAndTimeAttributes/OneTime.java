package dateAndTimeAttributes;

import java.time.LocalTime;

public class OneTime extends Time {
    public OneTime(LocalTime time) {
        super(time);
    }


    @Override
    public String toString() {
        return "OneTime{" +
                "time=" + endTime +
                '}';
    }
}
