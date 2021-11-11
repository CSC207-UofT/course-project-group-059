import abstractClasses.Task;
import interfaces.TaskObserver;

import java.util.*;

public class TaskTracker {

//Task Tracker will implement Observer design pattern
    private final List<TaskObserver> observerList = new ArrayList<>();

    private final TaskList taskList;


    //Constructor
    public TaskTracker(TaskList taskList, TaskObserver... observers) {
        this.taskList = taskList;
        Collections.addAll(observerList, observers);
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
    private void refreshObserver(Task task){
        for(TaskObserver observer: observerList){
            observer.simpleRefresh(task);
        }
    }


// deal with taskList

    public void addTask(Task task){
        taskList.getTaskList().add(task);
        refreshObserver(task);
    }

    public void deleteTask(Task task){
        taskList.getTaskList().remove(task);
        refreshObserver(task);
    }


//TODO edit Task


}