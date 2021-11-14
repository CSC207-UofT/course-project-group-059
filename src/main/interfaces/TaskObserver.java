package interfaces;

import abstractClasses.Task;

import java.util.ArrayList;

public interface TaskObserver {

    void simpleRefresh(Task task); // only refresh when the taskList only change in one Task

    void refresh(ArrayList<Task> taskList); // refresh with the whole taskList
}
