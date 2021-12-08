package controllers;

import task.taskEntities.Task;
import timeline.TimelineManager;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimelineController {
    //deal with any Timeline modifying features.

    private final TimelineManager timelineManager;

    public TimelineController(TimelineManager timelineManager) {
        this.timelineManager = timelineManager;
    }


    public TimelineManager getTimelineManager() {
        return timelineManager;
    }

    // select task from timeline
    public Task selectFromTimeline(String date, String time, int index){
        return timelineManager.getBlockFromTimeline(LocalDate.parse(date),LocalTime.parse(time)).get(index);
    }

    //add task to from taskList to Timeline manually by index
    public void addTaskToTimeline(Task task){
        timelineManager.addToTimeLine(task);
    }

    public void addToTimeline(Task task){
        timelineManager.addToTimeLine(task);
    }


    // remove task from timeline only, but still in the task list
    public void removeTaskFromTimeline(Task task){
        timelineManager.deleteFromTimeLine(task);
    }

    public void removeTaskFromTimeline(String date, String time, int index){
        Task task = timelineManager.getBlockFromTimeline(LocalDate.parse(date), LocalTime.parse(time)).get(index);
        timelineManager.deleteFromTimeLine(task);
    }
}

