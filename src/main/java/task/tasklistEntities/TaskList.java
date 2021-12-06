package task.tasklistEntities;

import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import gateways.Storable;
import task.taskEntities.EventTask;
import task.taskEntities.Task;

import java.time.LocalDate;
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

    @Override
    public List<Task> save() {
        return taskList;
    }

    @Override
    public void load(List<Task> load) {
        setTaskList(load);
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
