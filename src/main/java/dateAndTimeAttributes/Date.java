package dateAndTimeAttributes;

import task.taskEntities.Task;

import java.time.*;

//Date object using date as main
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
        if(this.startDate == null){
            return this.endDate;
        }
        else return this.startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    // TODO: there might have some more conditions have deal with here....
    public boolean isStartAndEndToday(){
        return true;
    }


    public void overwriteToTask(Task task) {
        task.setDate(this);
    }


}


