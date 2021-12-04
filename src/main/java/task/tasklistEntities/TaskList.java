package task.tasklistEntities;

import storer.Storable;
import task.taskEntities.Task;

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

    public ArrayList<String> save() {
        //TODO
        return new ArrayList<>();
    }

    public void open(ArrayList<String> csvData) {
        //TODO
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
