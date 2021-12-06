package controllers;


import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.OneDay;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import editStrategies.*;
import suggestion.Suggester;
import suggestion.SuggesterList;
import task.taskAttributes.*;
import task.taskEntities.Task;
import task.taskUseCases.*;
import timeline.TimelineManager;

import java.time.LocalDate;
import java.time.LocalTime;

public class Controller {

    private final TimelineManager timelineManager;
    private final TaskTracker taskTracker;
    private final Suggester suggester;

    public Controller(){
        timelineManager = new TimelineManager();
        suggester = new Suggester();
        taskTracker = new TaskTracker(timelineManager, suggester);


    }

    public TimelineManager getTimelineManager() {
        return timelineManager;
    }

    public TaskTracker getTaskTracker() {
        return taskTracker;
    }

    public Suggester getSuggester() {
        return suggester;
    }

    // select task form taskList
    public Task selectFromTaskList(int index){
        return taskTracker.getTaskList().getTaskList().get(index);
    }

    // select task from timeline
    public Task selectFromTimeline(String date, String time, int index){
        return timelineManager.getBlockFromTimeline(LocalDate.parse(date),LocalTime.parse(time)).get(index);
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

    //add task to from taskList to Timeline manually by index
    public void addFromTaskListToTimeline(int index){
        timelineManager.addToTimeLine(selectFromTaskList(index));
    }

    public void addToTimeline(Task task){
        timelineManager.addToTimeLine(task);
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
        Task task = timelineManager.getBlockFromTimeline(LocalDate.parse(date),LocalTime.parse(time)).get(index);
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


    public void editFinished(Task task, boolean newBool){
        TaskEditor.editTask(task, new EditTaskStatus(new Finished(newBool)));
    }

    public void editRecurring(Task task, boolean newBool){
        TaskEditor.editTask(task, new EditTaskStatus(new Recurring(newBool)));
    }

    // The time editing will remove the task form timeline first then put it back

    public void editAllDay(Task task, boolean newBool){
        removeTaskFromTimeline(task);
        TaskEditor.editTask(task, new EditTaskStatus(new AllDay(newBool)));
        addToTimeline(task);
    }

    public void editDate(Task task, String newStartDate, String newEndDate){
            removeTaskFromTimeline(task);
            DateRange newDateRange = new DateRange(LocalDate.parse(newStartDate), LocalDate.parse(newEndDate));
            TaskEditor.editTask(task, new EditTaskDateAndTime(newDateRange));
            addToTimeline(task);
    }

    public void editDate(Task task, String newDate){
        removeTaskFromTimeline(task);
        OneDay date = new OneDay(LocalDate.parse(newDate));
        TaskEditor.editTask(task, new EditTaskDateAndTime(date));
        addToTimeline(task);
    }


    public void editTime(Task task, String newStartTime, String newEndTime){
            removeTaskFromTimeline(task);
            TimeRange newTimeRange = new TimeRange(LocalTime.parse(newStartTime), LocalTime.parse(newEndTime));
            TaskEditor.editTask(task, new EditTaskDateAndTime(newTimeRange));
            addToTimeline(task);
    }


    public SuggesterList getSuggestionByDueDate(){
        return suggester.sortByDueDate();
    }

}
