package task.tasklistEntities;

import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import storer.Storable;
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
  
    public ArrayList<String> save() {
        ArrayList<String> z = new ArrayList<>();

        for (Task task : this.getTaskList()) {
            z.add(task.getName().toString() + ","
                    + task.getPriority().toString() + ","
                    + task.getDescription().toString() + ","
                    + task.getAllDay().toString() + ","
                    + task.getRecurring().toString() + ","
                    + task.getFinished().toString() + ","
                    + task.getDate().getStartDate().toString() + ","
                    + task.getDate().getEndDate().toString() + ","
                    + task.getTime().getStartTime().toString() + ","
                    + task.getTime().getEndTime().toString() + "\n");
        }

        return z;
    }

    public void open(ArrayList<String> csvData) {
        List<Task> newList = new ArrayList<>();

        for (String line: csvData) {
            String[] res = line.split(",");

            if (res.length > 1) {
                DateRange dateRange = new DateRange(LocalDate.parse(res[6]), LocalDate.parse(res[7]));
                TimeRange timeRange = new TimeRange(LocalTime.parse(res[8]), LocalTime.parse(res[9]));
                EventTask task = new EventTask(res[0], res[1], res[2], dateRange, timeRange);

                newList.add(task);
            }
        }

        this.setTaskList(newList);
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
