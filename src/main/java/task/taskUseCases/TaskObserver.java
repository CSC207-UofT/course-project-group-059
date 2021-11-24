package task.taskUseCases;

import task.taskEntities.Task;
import task.tasklistEntities.TaskList;

public interface TaskObserver {

    void simpleRefresh(Task task); // only refresh when the taskList only change in one Task

    void refresh(TaskList taskList); // refresh with the whole taskList
}
