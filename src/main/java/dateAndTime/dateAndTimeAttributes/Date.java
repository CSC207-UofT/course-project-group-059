package dateAndTime.dateAndTimeAttributes;

import task.taskEntities.Task;

import java.time.LocalDate;

//Date object using date as main
public abstract class Date {
    protected LocalDate startDate;
    protected LocalDate endDate;

    protected Date(LocalDate date) {
        this.startDate = date;
        this.endDate = date;
    }

    // Only return a localDate when startDate and endDate are the same.
    public LocalDate getDate() {
        if(startDate.equals(endDate)){
            return endDate;
        }
        return null;
    }

    public Date(LocalDate startDate, LocalDate endDate) {

        //Reverse when the date input in a wrong order.
        if(startDate.isAfter(endDate)){

            this.startDate = endDate;
            this.endDate = startDate;
        }
        else{
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    // getter and setter for each localDate//These methods are dealing with the case that startDate and endDate are different

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isOneday(){
        return startDate.equals(endDate);
    }


    // This method is a helper for the task edit strategy.
    public void overwriteToTask(Task task) {
        task.setDate(this);
    }


}


