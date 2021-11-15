package taskEntities;

import abstractClasses.Task;
import interfaces.Storable;

import java.time.LocalTime;
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

    public String toString() {
        StringBuilder output = new StringBuilder("Your to-do list:");

        output.append("\n");
        if (taskList.isEmpty()) {
            output.append("(Currently Empty)");
        }
        else {
            for (Task task: getTaskList()) {
                output.append(task);
                output.append("\n");
            }
        }

        return output.toString();
    }
}
