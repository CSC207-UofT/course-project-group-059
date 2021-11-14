package abstractClasses;

import java.time.*;


public abstract class Date {
    protected LocalDate startDate;
    protected LocalDate endDate;

    protected Date(LocalDate date) {
        this.endDate = date;
    }

    public Date(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getDate() {
        return endDate;
    }

    public void setDate(LocalDate date) {
        this.endDate = date;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isStartAndEndToday(){
        return true;
    }


}


