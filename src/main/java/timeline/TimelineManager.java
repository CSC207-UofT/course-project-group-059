package timeline;

import dateAndTime.dateAndTimeAttributes.*;
import dateAndTime.dateAndTimeUseCase.DateAndTime;
import task.taskEntities.Task;
import task.taskUseCases.TaskObserver;
import task.tasklistEntities.TaskList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class TimelineManager  implements TaskObserver {

    private final TimelineTracker timelineTracker;

    public TimelineManager() {
        this.timelineTracker = new TimelineTracker();
    }

    //NOTE: how to deal with repeating task is not decided yet.
    //Maybe the observer will update the repeating task to timeline every day

    //TODO: TEST these
    public void addToTimeLine(Task task){
        // deal with all day task
        // Case1: eventTask start and end today, all days.
        // Case2: eventTask start today and end tmr, all days
        if(task.getAllDay().getBool()){
            for(LocalDate date: DateAndTime.datesInRange(task.getDate()) ){
                timelineTracker.getFromCalender(date).getAllDayList().add(task);
            }
        }
        // deal with task not for all day and not repeating.
        // Case3: eventTask start and end today, one hr
        // Case4: eventTask start and end today two hrs
        // Case5: eventTask start today and end tmr, not all days
        else{
            //Find the dates in the range
            for(LocalDate date: DateAndTime.datesInRange(task.getDate()) ){
                //Call the corresponding TimeLine
                Timeline timeline = timelineTracker.getFromCalender(date);
                //Find the time blocks in the range
                for (LocalTime time : DateAndTime.hoursInRange(task.getTime())) {
                    //Put the task in to each time block
                    timeline.getTimeBlocks().computeIfAbsent(time, k -> new ArrayList<>()).add(task);
                }
            }
        }
    }

    // delete and Task from the timeline
    public void deleteFromTimeLine(Task task){
        if(task.getAllDay().getBool()){
            for(LocalDate date: DateAndTime.datesInRange(task.getDate()) ){
                timelineTracker.getFromCalender(date).getAllDayList().remove(task);
            }
        }
        else{
            //Find the dates in the range
            for(LocalDate date: DateAndTime.datesInRange(task.getDate()) ){
                //Call the corresponding TimeLine
                Timeline timeline = timelineTracker.getFromCalender(date);
                //Find the time blocks in the range
                for (LocalTime time : DateAndTime.hoursInRange(task.getTime())) {
                    //Put the task in to each time block
                    timeline.getTimeBlocks().computeIfAbsent(time, k -> new ArrayList<>()).remove(task);
                }
            }
        }
    }


    public ArrayList<Task> getFromTimeline(LocalDate date, LocalTime time){
        return timelineTracker.getFromCalender(date).getTimeBlocks().get(time);
    }


    //TODO TEST THESE

    // TaskObserver's methods
    @Override
    public void refresh(TaskList taskList, Task task) {
        if(taskList.getTaskList().contains(task)){
            addToTimeLine(task);
        }
        else {
            deleteFromTimeLine(task);
        }
    }



}