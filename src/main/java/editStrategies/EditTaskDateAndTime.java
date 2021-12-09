package editStrategies;

import dateAndTime.dateAndTimeAttributes.Date;
import dateAndTime.dateAndTimeAttributes.Time;
import task.taskEntities.Task;

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
            newTime.overwriteToTask(task);
        }
    }

}
