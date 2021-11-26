package editStrategies;

import task.taskEntities.Task;
import dateAndTimeAttributes.Date;
import dateAndTimeAttributes.Time;

public class EditTime implements EditStrategy {
    private Date newDate;
    private Time newTime;

    public EditTime(Date newDate, Time newTime) {
        this.newDate = newDate;
        this.newTime = newTime;
    }

    public EditTime(Date newDate) {
        this.newDate = newDate;
    }

    public EditTime(Time newTime) {
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
