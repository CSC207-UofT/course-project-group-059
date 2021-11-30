package editStrategies;

import task.taskEntities.Task;
import dateAndTime.dateAndTimeAttributes.Date;
import dateAndTime.dateAndTimeAttributes.Time;

public class EditTaskDateAndTime implements EditStrategy {
    private Date newDate;
    private Time newTime;

    public EditTaskDateAndTime(Date newDate, Time newTime) {
        this.newDate = newDate;
        this.newTime = newTime;
    }

    public EditTaskDateAndTime(Date newDate) {
        this.newDate = newDate;
    }

    public EditTaskDateAndTime(Time newTime) {
        this.newTime = newTime;
    }

    @Override
    public void edit(Task task){
        if (newDate != null) {
            newDate.overwriteToTask(task);
        }
        if (newTime != null){
            task.setTime(newTime);
        }
    }

}
