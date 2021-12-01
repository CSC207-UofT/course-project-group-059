package dateAndTime.dateAndTimeAttributes;

import task.taskEntities.Task;

import java.time.*;

public abstract class Time {
    protected LocalTime startTime;
    protected LocalTime endTime;


//These methods are dealing when start and end Time are the same
    public Time(LocalTime time) {
        this.startTime = time;
        this.endTime = time;
    }

    // only return value when start and end Time are the same
    public LocalTime getTime() {
        if(startTime.equals(endTime)) return startTime;
        else return null;
    }

    // return true if start and end at the same time
    public boolean isOneTime(){
        return startTime.equals(endTime);
    }


//These methods are dealing with the case that start and end time are different
    public Time(LocalTime startTime, LocalTime enTime) {
        this.startTime = startTime;
        this.endTime = enTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    // helper method for the task editing strategy
    public void overwriteToTask(Task task) {
        task.setTime(this);
    }

}
