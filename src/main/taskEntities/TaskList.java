package taskEntities;

import abstractClasses.Task;
import interfaces.Storable;

import java.util.ArrayList;
import java.util.List;

public class TaskList implements Storable {
    private List<Task> taskList = new ArrayList<>();

    public TaskList(){}

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
