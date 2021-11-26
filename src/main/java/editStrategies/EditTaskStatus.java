package editStrategies;

import task.taskAttributes.Status;
import task.taskEntities.Task;

public class EditTaskStatus implements EditStrategy {
    private final Status newStat;

    public EditTaskStatus(Status newStat) {
        this.newStat = newStat;
    }

    @Override
    public void edit(Task task) {
        newStat.overwriteToTask(task);
    }



}
