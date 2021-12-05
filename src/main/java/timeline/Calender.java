package timeline;

import task.taskEntities.Task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

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
        // Making sure that the date will be print in order.
        List<LocalDate> dateInOrder = new ArrayList<>(calender.keySet());

        Collections.sort(dateInOrder);

        StringBuilder output = new StringBuilder("calender:");

        for(LocalDate date: dateInOrder) {
            output.append("\n");
            output.append("- ").append(calender.get(date).getDate());
        }

        return output.toString();
    }
}
