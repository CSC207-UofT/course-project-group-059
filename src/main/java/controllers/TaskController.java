package controllers;

import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import editStrategies.EditTaskDateAndTime;
import editStrategies.EditTaskStatus;
import editStrategies.EditTaskText;
import task.taskAttributes.*;
import task.taskEntities.Task;
import task.taskUseCases.TaskEditor;
import timeline.TimelineManager;

import java.time.LocalDate;
import java.time.LocalTime;

public class TaskController {

    // deal with any task editing features
    TimelineManager manager;

    public TaskController(TimelineManager manager) {
        this.manager = manager;
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
        manager.deleteFromTimeLine(task);
        TaskEditor.editTask(task, new EditTaskStatus(new AllDay(newBool)));
        manager.addToTimeLine(task);
    }

    public void editDate(Task task, String newStartDate, String newEndDate){
        manager.deleteFromTimeLine(task);
        DateRange newDateRange = new DateRange(LocalDate.parse(newStartDate), LocalDate.parse(newEndDate));
        TaskEditor.editTask(task, new EditTaskDateAndTime(newDateRange));
        manager.addToTimeLine(task);
    }

    public void editTime(Task task, String newStartTime, String newEndTime){
        manager.deleteFromTimeLine(task);
        TimeRange newTimeRange = new TimeRange(LocalTime.parse(newStartTime), LocalTime.parse(newEndTime));
        TaskEditor.editTask(task, new EditTaskDateAndTime(newTimeRange));
        manager.addToTimeLine(task);
    }
}
