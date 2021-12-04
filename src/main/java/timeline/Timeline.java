package timeline;

import storer.Storable;
import task.taskEntities.Task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.*;


// Thought: maybe we can simply just use array rather than arrayList.
public class Timeline{
    private final LocalDate date;
    private final LinkedHashMap<LocalTime, ArrayList<Task>> timeBlocks;
    private final ArrayList<Task> allDayList;

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
    }

    public LocalDate getDate() {
        return date;
    }

    public LinkedHashMap<LocalTime, ArrayList<Task>> getTimeBlocks() {
        return timeBlocks;
    }

    public ArrayList<Task> getAllDayList() {
        return allDayList;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(date +" timeline:");

        if(!allDayList.isEmpty()){
            for(Task task: allDayList){
                output.append("\n");
                output.append(task.getName());
            }
        }

        for(LocalTime time: timeBlocks.keySet()){
            output.append("\n");
            output.append(time.toString());
            output.append(":\t");

            for (Task task: timeBlocks.get(time)){
                output.append(task.getName());
                output.append(", ");
            }
        }

        return output.toString();
    }

}