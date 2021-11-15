import abstractClasses.Task;
import interfaces.TaskObserver;
import taskEntities.*;

public class TimelineManager  implements TaskObserver {
    Timeline timeline;

    public TimelineManager(Timeline timeline) {
        this.timeline = timeline;
    }

    // TaskObserver's methods
    @Override
    public void simpleRefresh(Task task) {

    }

    @Override
    public void refresh(TaskList taskList) {

    }

    // Case1: eventTask start and end today, one hr
    // Case2: eventTask start and end today two hrs
    // Case3: eventTask start and end today, all days.
    // Case4: eventTask start today and end tmr, all days
    // Case5: eventTask start today and end tmr, not all days

    //NOTE: how to deal with repeating task is not decided yet.

    // same day or not, all day or not, repeated or not


    public void addToTime(Task task){

    }

    // delete and Task from the timeline
    public void deleteFromTime(Task task){

    }

    //TODO deal with time with modified time and date
    public void shiftToTime(Task task){

    }



    // Return true if there are two tasks in the same time block and there time are overlapping
//    public static boolean checkOverlap(abstractClasses.Task task1, Task task2){
//
//    }



}
