package timeline;

import dateAndTime.dateAndTimeUseCase.DateAndTime;
import task.taskEntities.Task;
import task.taskUseCases.TaskObserver;
import task.tasklistEntities.TaskList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class TimelineManager  implements TaskObserver {
    // Every TimeLineManager share the same Calendar
    private static final Calender calender = new Calender();

    //Constructor will create a today's timeline is there is not one in the calendar.
    public TimelineManager() {
        LocalDate today = LocalDate.now();
        if (!calender.getCalender().containsKey(today)){
            calender.add(today,new Timeline(today));
        }
    }

    private Timeline getFromCalender(LocalDate date){
        if (!calender.getCalender().containsKey(date)){
            calender.add(date,new Timeline(date));
        }

        return calender.get(date);
    }

    public Timeline getTodayTimeline(){
        return calender.get(LocalDate.now());
    }




    //TODO Rare case
    // Case5: eventTask start today and end tmr, not all days

    // create more timeline for future or split the task if cross the date???


    //NOTE: how to deal with repeating task is not decided yet.
    //Maybe the observer will update the repeating task to timeline every day


    public void addToTimeLine(Task task){
        // deal with all day task
        // Case3: eventTask start and end today, all days.
        // Case4: eventTask start today and end tmr, all days
        if(task.getAllDay().getBool()){
            addToAllDay(task);
        }
        // deal with task not for all day and not repeating.
        // Case1: eventTask start and end today, one hr
        // Case2: eventTask start and end today two hrs
        else{
            addToTimeBlocks(task);
        }
    }

    //helper method for adding task to allday list in timelines
    private void addToAllDay(Task task){
        if(task.getDate().isOneday()){
            getFromCalender(task.getDate().getDate()).getAllDayList().add(task);
        }
        // If there is more than one date this well call the iteration, create ore add the task in to timeline
        else{
            for(LocalDate date: DateAndTime.datesInRange(task.getDate()) ){
                getFromCalender(date).getAllDayList().add(task);
            }
        }
    }

    //helper method for adding task in to timelines
    private void addToTimeBlocks(Task task){
        Timeline timeline = getFromCalender(task.getDate().getDate());
        if(task.getTime().isOneTime()){
            timeline.getTimeline().computeIfAbsent(task.getTime().getTime(), k -> new ArrayList<>()).add(task);
        }
        else{
            for(LocalTime time : DateAndTime.hoursInRange(task.getTime())){
                timeline.getTimeline().computeIfAbsent(time, k -> new ArrayList<>()).add(task);
            }
        }
    }

    // delete and Task from the timeline
    public void deleteFromTime(Task task){

    }

    //TODO deal with time with modified time and date
    public void shiftToTime(Task task){

    }


    // TaskObserver's methods
    @Override
    public void simpleRefresh(Task task) {

    }

    @Override
    public void refresh(TaskList taskList) {

    }



}
