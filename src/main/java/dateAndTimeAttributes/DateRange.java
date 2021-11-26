package dateAndTimeAttributes;

import task.taskEntities.Task;

import java.time.LocalDate;

public class DateRange extends Date {
    public DateRange(LocalDate startDate, LocalDate endDate) {
        super(startDate, endDate);
    }


    @Override
    public boolean isStartAndEndToday(){
        return startDate.equals(endDate);
    }



    @Override
    public String toString() {
        return "DateRange{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
