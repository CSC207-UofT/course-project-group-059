package task.taskAttributes;

import editStrategies.EditTaskStatus;
import task.taskEntities.Task;

public class AllDay extends Status {
    public AllDay() {
    }

    public AllDay(boolean value) {
        super(value);
    }

    @Override
    public void overwriteToTask(Task task) {
         task.getAllDay().update(this);
    }

}
