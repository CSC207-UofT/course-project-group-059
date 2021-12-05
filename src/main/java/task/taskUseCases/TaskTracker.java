package task.taskUseCases;

import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.OneDay;
import dateAndTime.dateAndTimeAttributes.OneTime;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import task.taskEntities.EventTask;
import task.taskEntities.Task;
import task.taskEntities.TodoTask;
import task.tasklistEntities.TaskList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class TaskTracker {

//Task Tracker implements Observer design pattern
    private final List<TaskObserver> observerList = new ArrayList<>();

    private TaskList taskList = new TaskList();

    //Constructor
    public TaskTracker(TaskList tasklist, TaskObserver... observers) {
        this.taskList = tasklist;
        Collections.addAll(observerList, observers);
    }

    public TaskTracker(TaskList tasklist) {
        this.taskList = tasklist;
    }
    public TaskTracker(){

    }

    public TaskList getTaskList() {
        return taskList;
    }

    // deal with Observer list
    public void addNewObservers(TaskObserver observer){
        observerList.add(observer);
    }

    public void removeObserver(TaskObserver observer){
        observerList.remove(observer);
    }

    public List<TaskObserver> getObserverList(){
        return observerList;
    }

    // auto update to the observer
    private void simpleRefreshObserver(Task task){
        if(!observerList.isEmpty()){
            for(TaskObserver observer: observerList){
                observer.simpleRefresh(task);
            }
        }
    }

    private void refreshObserver(){
        for(TaskObserver observer: observerList){
            observer.refresh(taskList);
        }
    }


// deal with taskList and task creation

    public void creatEventTask(String name,String priority,String description,
                               String startDate,String startTime, String endDate, String endTime){
        DateRange dateRange = new DateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
        TimeRange timeRange = new TimeRange(LocalTime.parse(startTime), LocalTime.parse(endTime));
        Task task = new EventTask(name,priority,description, dateRange, timeRange);
        addTask(task);
    }

    public void creatToDoTask(String name,String priority,String description, String date,String time){

        OneDay oneday = new OneDay(LocalDate.parse(date));
        OneTime onetime = new OneTime(LocalTime.parse(time));

        Task task = new TodoTask(name,priority,description,oneday,onetime);
        addTask(task);
    }


    public void addTask(Task task){
        taskList.getTaskList().add(task);
        simpleRefreshObserver(task);
    }

    public void deleteTask(Task task){
        taskList.getTaskList().remove(task);
        simpleRefreshObserver(task);
    }



}