package taskEntities;

import abstractClasses.*;
import interfaces.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.*;


// Thought: maybe we can simply just use array rather than arrayList.
public class Timeline implements Storable {
    private final LinkedHashMap<LocalTime, ArrayList<Task>> timeline;
    private final ArrayList<Task> allDayList;

    //constructor and assign all the time block in to timeline
    public Timeline(){
        timeline = new LinkedHashMap<>();

        // Add a key for each hour, mapped to empty lists
        for (int i = 0; i < 24; i++) {
            String formatted = String.format("%02d", i);
            String hour = formatted + ":00";
            ArrayList<Task> tasks = new ArrayList<>();
            timeline.put(LocalTime.parse(hour), tasks);
        }

        allDayList = new ArrayList<>();
    }

    public LinkedHashMap<LocalTime, ArrayList<Task>> getTimeline() {
        return timeline;
    }

    public ArrayList<Task> getAllDayList() {
        return allDayList;
    }

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