package interfaces;

import abstractClasses.Task;
import taskEntities.TaskList;

import java.util.ArrayList;

public interface TaskObserver {

    void simpleRefresh(Task task); // only refresh when the taskList only change in one Task

    void refresh(TaskList taskList); // refresh with the whole taskList
}
