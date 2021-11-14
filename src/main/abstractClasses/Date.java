package abstractClasses;

import java.time.*;


public abstract class Date {
    protected LocalDate date;

    protected Date(LocalDate date) {
        this.date = date;
    }

    protected Date() {
    }

    protected LocalDate getDate() {
        return date;
    }

    protected void setDate(LocalDate date) {
        this.date = date;
    }

}


