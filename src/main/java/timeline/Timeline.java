package timeline;

import task.taskEntities.Task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.*;

public class Timeline {

    private final LocalDate date;
    private final LinkedHashMap<LocalTime, ArrayList<Task>> timeBlocks;
    private final ArrayList<Task> allDayList;

    private int numOfTaskInBlocks;

    //constructor and assign all the time block in to timeline
    public Timeline(LocalDate date){

        this.date = date;

        timeBlocks = new LinkedHashMap<>();

        // Add a key for each hour, mapped to empty lists
        for (int i = 0; i < 24; i++) {
            String formatted = String.format("%02d", i);
            String hour = formatted + ":00";
            ArrayList<Task> tasks = new ArrayList<>();
            timeBlocks.put(LocalTime.parse(hour), tasks);
        }

        allDayList = new ArrayList<>();
        numOfTaskInBlocks = 0;
    }

    public LocalDate getDate() {
        return date;
    }

    public void addToTimeBlocks(LocalTime time, Task task){
        ArrayList<Task> inBlocks = timeBlocks.get(time);
        inBlocks.add(task);
        numOfTaskInBlocks++;
    }

    public void removeFromTime(LocalTime time, Task task){
        ArrayList<Task> inBlocks = timeBlocks.get(time);
        inBlocks.add(task);
        numOfTaskInBlocks--;
    }
    public void addToAllDayList(Task task){
        allDayList.add(task);
        numOfTaskInBlocks++;
    }

    public void removeFromAllDayList(Task task){
        allDayList.remove(task);
        numOfTaskInBlocks--;
    }

    public ArrayList<Task> getTimeBlock(LocalTime time){
        return timeBlocks.get(time);
    }

    public ArrayList<Task> getAllDayList(){
        return allDayList;
    }

    public boolean isEmpty(){
        return numOfTaskInBlocks == 0;
    }

    public boolean isToday(){
        return date.equals(LocalDate.now());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(date +" timeline:");

        if(!allDayList.isEmpty()){
            output.append("\n");
            output.append("All day: ");
            int i = 0;
            for(Task task: allDayList){
                i++;

                output.append("\t");
                output.append(i).append(". ");
                output.append(task.getName());
            }
        }

        for(LocalTime time: timeBlocks.keySet()){
            output.append("\n");
            output.append(time.toString());
            output.append(":\t");
            int i = 0;
            for (Task task: timeBlocks.get(time)){
                i++;
                output.append(i).append(". ");
                output.append(task.getName());
                output.append(", ");
            }
        }

        return output.toString();
    }

}
