import abstractClasses.Task;
import interfaces.TaskObserver;
import taskEntities.TaskList;

import java.util.*;

public class TaskTracker {

//Task Tracker implements Observer design pattern
    private final List<TaskObserver> observerList = new ArrayList<>();

    private final TaskList taskList;


    //Constructor
    public TaskTracker(TaskList tasklist, TaskObserver... observers) {
        this.taskList = tasklist;
        Collections.addAll(observerList, observers);
    }

    public TaskTracker(TaskList tasklist) {
        this.taskList = tasklist;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    // deal with Observer list
//    public void addNewObservers(TaskObserver observer){
//        observerList.add(observer);
//    }
//
//    public void removeObserver(TaskObserver observer){
//        observerList.remove(observer);
//    }
//
//    public List<TaskObserver> getObserverList(){
//        return observerList;
//    }

    // auto update to the observer
    private void simpleRefreshObserver(Task task){
        if(!observerList.isEmpty()){
            for(TaskObserver observer: observerList){
                observer.simpleRefresh(task);
            }
        }
    }

//    private void refreshObserver(){
//        for(TaskObserver observer: observerList){
//            observer.refresh(taskList);
//        }
//    }


// deal with taskList

    public void addTask(Task task){
        taskList.getTaskList().add(task);
        simpleRefreshObserver(task);
    }

    public void deleteTask(Task task){
        taskList.getTaskList().remove(task);
        simpleRefreshObserver(task);
    }



}