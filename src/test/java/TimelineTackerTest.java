import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import timeline.Calender;
import timeline.TimelineTracker;

import java.time.LocalDate;

public class TimelineTackerTest {
    @Test
    //test if the timelineTracker of today's timeline when initiate
    public void initialWithTodayTest(){
        TimelineTracker tracker = new TimelineTracker();

        String expected = LocalDate.now()+ " timeline:\n00:00:\t\n01:00:\t\n02:00:\t\n03:00:\t\n04:00:\t\n05:00:\t\n" +
                "06:00:\t\n07:00:\t\n08:00:\t\n09:00:\t\n10:00:\t\n11:00:\t\n" +
                "12:00:\t\n13:00:\t\n14:00:\t\n15:00:\t\n16:00:\t\n17:00:\t\n" +
                "18:00:\t\n19:00:\t\n20:00:\t\n21:00:\t\n22:00:\t\n23:00:\t";

        String output = tracker.getTodayTimeline().toString();

        Assertions.assertEquals(expected, output);
    }

    @Test
    //Test if the timelineTracker will create a new timeline if there is not one.
    public void getFromCalenderTest(){
        TimelineTracker tracker = new TimelineTracker();
        LocalDate date = LocalDate.parse("2021-10-17");
        tracker.getFromCalender(date);
        String expected = "calender:\n" +
                "- 2021-10-17\n" +
                "- 2021-12-04";

        Assertions.assertEquals(expected, tracker.getCalender().toString());
    }

    @Test
    //Test if all the tracker share the same calendar.
    public void staticCalenderTest(){
        TimelineTracker tracker1 = new TimelineTracker();
        TimelineTracker tracker2 = new TimelineTracker();

        LocalDate date = LocalDate.parse("2021-10-17");
        tracker1.getFromCalender(date);

        Assertions.assertEquals(tracker1.getCalender(), tracker2.getCalender());
    }
}
