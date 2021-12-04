package task.taskUseCases;

import task.taskEntities.Task;
import task.tasklistEntities.TaskList;

public interface TaskObserver {
    void refresh(TaskList taskList, Task task);
}
