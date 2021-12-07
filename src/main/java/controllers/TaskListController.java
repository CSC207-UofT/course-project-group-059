package controllers;

import task.taskEntities.Task;
import task.taskUseCases.TaskTracker;

public class TaskListController {
    //deal with any taskList modifying features

    private final TaskTracker taskTracker;

    public TaskListController(TaskTracker taskTracker) {
        this.taskTracker = taskTracker;
    }


    public TaskTracker getTaskTracker() {
        return taskTracker;
    }

    // select task form taskList
    public Task selectFromTaskList(int index){
        return taskTracker.getTaskList().getTaskList().get(index);
    }


    // create and add task
    public void createEventTask(String name, String priority, String description,
                                String startDate, String startTime, String endDate, String endTime){
        taskTracker.creatEventTask(name,priority,description,startDate,startTime,endDate,endTime);
    }

    public void createTodoTask(String name, String priority, String description,
                               String date, String time){
        taskTracker.creatToDoTask(name,priority,description,date,time);
    }


    // delete task from this system
    public void deleteTaskFromTaskList(int index){
        taskTracker.deleteTask(taskTracker.getTaskList().getTaskList().get(index));
    }
}
