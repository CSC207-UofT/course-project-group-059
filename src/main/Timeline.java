import abstractClasses.Task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.*;


// Thought: maybe we can simply just use array rather than array.
public class Timeline {
    private final LinkedHashMap<LocalTime, ArrayList<Task>> timeline;

    //constructor and assign all the time block in to timeline
    public Timeline(){
        timeline = new LinkedHashMap<>();

        // ArrayList<abstractClasses.Task> taskList = new ArrayList<>();

        // Add a key for each hour, mapped to empty lists
        for (int i = 0; i < 24; i++) {
            String formatted = String.format("%02d", i);
            String hour = formatted + ":00";
            ArrayList<Task> tasks = new ArrayList<>();
            timeline.put(LocalTime.parse(hour), tasks);
        }
    }

    // Return true if there are two tasks in the same time block and there time are overlapping
//    public static boolean checkOverlap(abstractClasses.Task task1,  abstractClasses.Task task2){
//
//    }



    /*public boolean addTaskToTimeLine(abstractClasses.Task task){

        for(LocalTime time : this.timeline.keySet()) {

            // dealing with the case that the task have star time and end time
            if(task.getStartTime() != null && task.getEndTime() != null){

                int diff = (int) task.getStartTime().until(task.getEndTime(), ChronoUnit.HOURS);

                // add task in the very first block that is the task start time is equals or after,
                // if the time interval is less than or equals to 1 hour
                if (diff <= 1 && (time.equals(task.getStartTime()) || task.getStartTime().isAfter(time))) {
                    this.timeline.get(time).add(task);
                    return true;
                }

                //TODO: find a way to deal with time interval that is greater than i


            }

            //TODO: dealing with the case that task have only end time.


        }

        return false;

    }


    // change time of task only
    public static void changeTaskTime(abstractClasses.Task task, LocalTime startTime, LocalTime endTime){
        task.setStartTime(startTime);
        task.setEndTime(startTime);
    }

    // change date the time of the task, which will affect the timeline
    public static void changeTaskTime(abstractClasses.Task task, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime){
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setStartTime(startTime);
        task.setEndTime(endTime);
    }*/

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Today's timeline:");

        for(LocalTime time: timeline.keySet()){
            output.append("\n");
            output.append(time.toString());
            output.append(":\t");

            for (Task task: timeline.get(time)){
                output.append(task);
                output.append(", ");
            }
        }

        return output.toString();
    }

}