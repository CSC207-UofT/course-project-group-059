package task.taskUseCases;

import editStrategies.EditStrategy;
import task.taskEntities.Task;

public class TaskEditor{
    public static void editTask(Task task, EditStrategy strategy){
        strategy.edit(task);
    }
}
