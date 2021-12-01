package dateAndTime.dateAndTimeAttributes;

import java.time.LocalDate;

public class DateRange extends Date {
    public DateRange(LocalDate startDate, LocalDate endDate) {
        super(startDate, endDate);
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
