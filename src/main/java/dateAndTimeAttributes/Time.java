package dateAndTimeAttributes;

import task.taskEntities.Task;

import java.time.*;


//Time object use startTime as main
public abstract class Time {
    protected LocalTime startTime;
    protected LocalTime endTime;


    public Time(LocalTime time) {
        this.startTime = time;
    }

    public Time(LocalTime startTime, LocalTime enTime) {
        this.startTime = startTime;
        this.endTime = enTime;
    }

    public LocalTime getTime() {
        return startTime;
    }

    public void setTime(LocalTime time) {
        this.startTime = time;
    }


    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        if(this.endTime == null){
            return this.startTime;
        }
        return endTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime enTime) {
        this.endTime = enTime;
    }

    public boolean isNow(){
        return isStart() || isEnd();
    }

    public boolean isStart(){
            return this.startTime.isBefore(LocalTime.now()) || this.startTime.equals(LocalTime.now());
    }

    public boolean isEnd(){
        if(this.endTime == null){
            return isStart();
        }
        return this.endTime.isAfter(LocalTime.now()) || this.endTime.equals(LocalTime.now());
    }


    public void overwriteToTask(Task task) {
        task.setTime(this);
    }
}
