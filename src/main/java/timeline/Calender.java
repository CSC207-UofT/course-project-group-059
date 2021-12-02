package timeline;

import java.time.LocalDate;
import java.util.LinkedHashMap;

public class Calender {
    private final LinkedHashMap<LocalDate, Timeline> calender;

    public Calender() {
        calender = new LinkedHashMap<>();
    }

    public void add(LocalDate date, Timeline timeline) {
        calender.put(date, timeline);
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
}
