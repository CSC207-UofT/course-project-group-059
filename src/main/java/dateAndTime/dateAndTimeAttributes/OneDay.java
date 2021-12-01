package dateAndTime.dateAndTimeAttributes;

import java.time.LocalDate;

public class OneDay extends Date {
    public OneDay(LocalDate date) {
        super(date);
    }

    @Override
    public String toString() {
        return "OneDay{" +
                "date=" + endDate +
                '}';
    }
}
