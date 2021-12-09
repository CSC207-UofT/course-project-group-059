package task.tasklistEntities;

import task.taskEntities.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList{
    private List<Task> taskList = new ArrayList<>();

    public TaskList(){}

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Your to-do list:");

        output.append("\n");
        if (taskList.isEmpty()) {
            output.append("(Currently Empty)");
        }
        else {
            int i = 0;
            for (Task task: getTaskList()) {
                i++;
                output.append(i).append(". ");
                output.append(task);
                output.append("\n");
            }
        }

        return output.toString();
    }
}
