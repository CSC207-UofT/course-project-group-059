package timeline;

import java.time.LocalDate;

//UseCase's Calender
public class TimelineTracker {
    // Every TimeLineManager share the same Calendar
    private static final Calender calender = new Calender();

    //Constructor will create a today's timeline is there is not one in the calendar.
    public TimelineTracker() {
        LocalDate today = LocalDate.now();
        if (!calender.getCalender().containsKey(today)){
            calender.add(today);
        }
    }

    // This will create a new timeline if there is
    public Timeline getFromCalender(LocalDate date){
        if (!calender.getCalender().containsKey(date)){
            calender.add(date);
        }

        return calender.get(date);
    }

    public Timeline getTodayTimeline(){
        return calender.get(LocalDate.now());
    }

    public Calender getCalender(){
        return calender;
    }
}
