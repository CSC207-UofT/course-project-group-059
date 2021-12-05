package controllers;


import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import editStrategies.*;
import task.taskAttributes.*;
import task.taskEntities.Task;
import task.taskUseCases.*;
import timeline.TimelineManager;

import java.time.LocalDate;
import java.time.LocalTime;

public class TaskAndTimeController {

    private final TimelineManager timelineManager;
    private final TaskTracker taskTracker;

    public TaskAndTimeController(){
        timelineManager = new TimelineManager();
        taskTracker = new TaskTracker(timelineManager);
    }

    // select task form taskList
    public Task selectFromTaskList(int index){
        return taskTracker.getTaskList().getTaskList().get(index);
    }
    // select task from timeline
    public Task selectFromTimeline(String date, String time, int index){
        return timelineManager.getFromTimeline(LocalDate.parse(date),LocalTime.parse(time)).get(index);
    }

    // create and add task
    public void createTask(String name,String priority,String description,
                                String startDate,String startTime, String endDate, String endTime){

        if(startDate.equals(endDate) && startTime.equals(endTime)){
            taskTracker.creatToDoTask(name,priority,description,endDate,startTime);
        }
        else taskTracker.creatEventTask(name,priority,description,startDate,startTime,endDate,endTime);
    }

    //add task to from taskList to Timeline manually by index
    public void addFromTaskListToTimeline(int index){
        taskTracker.addTask(selectFromTaskList(index));
    }

    public void addToTimeline(Task task){
        taskTracker.addTask(task);
    }

    // delete task from this system
    public void deleteTaskFromTaskList(int index){
        taskTracker.deleteTask(taskTracker.getTaskList().getTaskList().get(index));
    }

    // remove task from timeline only, but still in the task list
    public void removeTaskFromTimeline(int index){
        timelineManager.deleteFromTimeLine(taskTracker.getTaskList().getTaskList().get(index));
    }

    public void removeTaskFromTimeline(String date, String time, int index){
        Task task = timelineManager.getFromTimeline(LocalDate.parse(date),LocalTime.parse(time)).get(index);
        timelineManager.deleteFromTimeLine(task);
    }

    public void removeTaskFromTimeline(Task task){
        timelineManager.deleteFromTimeLine(task);
    }


    // edit task
    public void editName(Task task, String newName){
        TaskEditor.editTask(task, new EditTaskText(new TaskName(newName)));
    }

    public void editPriority(Task task, String newPriority){
        TaskEditor.editTask(task, new EditTaskText(new TaskPriority(newPriority)));
    }

    public void editDescription(Task task, String newDescription){
        TaskEditor.editTask(task, new EditTaskText(new TaskDescription(newDescription)));
    }

    public void editAllDay(Task task, boolean newBool){
        TaskEditor.editTask(task, new EditTaskStatus(new AllDay(newBool)));
    }

    public void editFinished(Task task, boolean newBool){
        TaskEditor.editTask(task, new EditTaskStatus(new Finished(newBool)));
    }

    public void editRecurring(Task task, boolean newBool){
        TaskEditor.editTask(task, new EditTaskStatus(new Recurring(newBool)));
    }

    // The time editing will remove the task form timeline first then put it back
    public void editEventTaskDate(Task task, String newStartDate, String newEndDate){
            removeTaskFromTimeline(task);
            DateRange newDateRange = new DateRange(LocalDate.parse(newStartDate), LocalDate.parse(newEndDate));
            TaskEditor.editTask(task, new EditTaskDateAndTime(newDateRange));
            addToTimeline(task);
    }
    public void editTime(Task task, String newStartTime, String newEndTime){
            removeTaskFromTimeline(task);
            TimeRange newTimeRange = new TimeRange(LocalTime.parse(newStartTime), LocalTime.parse(newEndTime));
            TaskEditor.editTask(task, new EditTaskDateAndTime(newTimeRange));
            addToTimeline(task);
    }


}
