package timeline;

import task.taskEntities.Task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;

public class Calender {
    private final LinkedHashMap<LocalDate, Timeline> calender;

    public Calender() {
        calender = new LinkedHashMap<>();
    }

    public void add(LocalDate date) {
        calender.put(date, new Timeline(date));
    }

    public void remove(LocalDate date){
        calender.remove(date);
    }

    public Timeline get(LocalDate date){
        return calender.get(date);
    }

    public LinkedHashMap<LocalDate, Timeline> getCalender(){
        return this.calender;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("calender:");

        for(Timeline timeline: calender.values()){
            output.append("\n");
            output.append("- ").append(timeline.getDate());
        }

        return output.toString();
    }
}
