package gateways;

import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.OneDay;
import dateAndTime.dateAndTimeAttributes.OneTime;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import task.taskEntities.EventTask;
import task.taskEntities.Task;
import task.taskEntities.TodoTask;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TaskToCSVStorer {


    // return a string value of task's property in csv format
    public List<String> getTasksToSaveCSV(Storable storable){

        List<String> toSave = new ArrayList<>();
        for(Task task: storable.save()){
            toSave.add(TaskToCSV(task));
        }

        return toSave;
    }

    public void getTaskToLoadCSV(Storable storable, List<String> load){
        List<Task> toLoad = new ArrayList<>();
        for (String task: load){
            toLoad.add(CsvToTask(task));
        }

       storable.load(toLoad);
    }

    private String TaskToCSV(Task task){

        StringBuilder output = new StringBuilder(task.getClass().toString());//0

        output.append(",").append(task.getName());//1
        output.append(",").append(task.getPriority());//2
        output.append(",").append(task.getDescription());//3
        output.append(",").append(task.getDate().getStartDate());//4
        output.append(",").append(task.getTime().getStartTime());//5
        output.append(",").append(task.getDate().getEndDate());//6
        output.append(",").append(task.getTime().getEndTime());//7

        output.append(",").append(task.getAllDay());//8
        output.append(",").append(task.getRecurring());//9
        output.append(",").append(task.getFinished());//10
        output.append('\n');

        return output.toString();
    }

    private Task CsvToTask(String csv){
        Task task;
        String[] res = csv.split(",");

        if(res[0].equals("class task.taskEntities.EventTask")){
            DateRange dateRange = new DateRange(LocalDate.parse(res[4]), LocalDate.parse(res[6]));
            TimeRange timeRange = new TimeRange(LocalTime.parse(res[5]), LocalTime.parse(res[7]));

            task = new EventTask(res[1],res[2],res[3],dateRange,timeRange);

        }

        else{
            OneDay oneDay = new OneDay(LocalDate.parse(res[6]));
            OneTime oneTime = new OneTime(LocalTime.parse(res[5]));

            task = new TodoTask(res[1],res[2],res[3],oneDay, oneTime);

        }
        task.getAllDay().update(res[4]);
        task.getAllDay().update(res[5]);
        task.getAllDay().update(res[6]);
        return task;
    }


}
