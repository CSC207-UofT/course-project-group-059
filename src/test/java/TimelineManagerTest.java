import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.OneDay;
import dateAndTime.dateAndTimeAttributes.OneTime;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.taskEntities.EventTask;
import task.taskEntities.Task;
import timeline.TimelineManager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TimelineManagerTest {
    String name = "Math Work";
    String priority = "";
    String description = "";
    String startDate = "2021-12-15";
    String startTime = "14:00";
    String endDate = "2021-12-16";
    String endTime = "15:30";

    DateRange dateRange = new DateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
    OneDay oneDay = new OneDay(LocalDate.parse(endDate));
    TimeRange timeRange = new TimeRange(LocalTime.parse(startTime), LocalTime.parse(endTime));
    OneTime oneTime = new OneTime(LocalTime.parse(endTime));


    @Test
    public void testAddTaskWithDateAndTimeRange(){
        TimelineManager manager = new TimelineManager();
        Task newTask = new EventTask(name,priority,description,dateRange,timeRange);

        manager.addToTimeLine(newTask);

        //calender
        String expectedCalender = "calender:\n- " +
                LocalDate.now()+"\n" +
                "- 2021-12-15\n" +
                "- 2021-12-16";

        String outputCalender = manager.getTimelineTracker().getCalender().toString();


        Assertions.assertEquals(expectedCalender,outputCalender);

        //start date's timeline
        String expectedStartDateTasks = startDate+" timeline:\n" +
                "00:00:\t\n" +
                "01:00:\t\n" +
                "02:00:\t\n" +
                "03:00:\t\n" +
                "04:00:\t\n" +
                "05:00:\t\n" +
                "06:00:\t\n" +
                "07:00:\t\n" +
                "08:00:\t\n" +
                "09:00:\t\n" +
                "10:00:\t\n" +
                "11:00:\t\n" +
                "12:00:\t\n" +
                "13:00:\t\n" +
                "14:00:\t1. Math Work, \n" +
                "15:00:\t1. Math Work, \n" +
                "16:00:\t1. Math Work, \n" +
                "17:00:\t\n" +
                "18:00:\t\n" +
                "19:00:\t\n" +
                "20:00:\t\n" +
                "21:00:\t\n" +
                "22:00:\t\n" +
                "23:00:\t";

        String outputStartDateTasks = manager.getTimeLine(dateRange.getStartDate()).toString();
        //end date's timeline
        String expectedEndDateTasks = endDate+" timeline:\n" +
                "00:00:\t\n" +
                "01:00:\t\n" +
                "02:00:\t\n" +
                "03:00:\t\n" +
                "04:00:\t\n" +
                "05:00:\t\n" +
                "06:00:\t\n" +
                "07:00:\t\n" +
                "08:00:\t\n" +
                "09:00:\t\n" +
                "10:00:\t\n" +
                "11:00:\t\n" +
                "12:00:\t\n" +
                "13:00:\t\n" +
                "14:00:\t1. Math Work, \n" +
                "15:00:\t1. Math Work, \n" +
                "16:00:\t1. Math Work, \n" +
                "17:00:\t\n" +
                "18:00:\t\n" +
                "19:00:\t\n" +
                "20:00:\t\n" +
                "21:00:\t\n" +
                "22:00:\t\n" +
                "23:00:\t";
        String outputEndDateTasks = manager.getTimeLine(dateRange.getEndDate()).toString();

//        Assertions.assertEquals(expectedStartDateTasks,outputStartDateTasks);
//        Assertions.assertEquals(expectedEndDateTasks,outputEndDateTasks);

        System.out.println(manager.getTimeLine(dateRange.getStartDate()).toString());
    }

    @Test
    public void TestDelete(){
        TimelineManager manager = new TimelineManager();
        Task newTask = new EventTask(name,priority,description,dateRange,timeRange);

        manager.addToTimeLine(newTask);

        String before = manager.getTimelineTracker().getCalender().toString();

        manager.deleteFromTimeLine(newTask);

        String after = manager.getTimelineTracker().getCalender().toString();
        String expected = "calender:\n- "+ LocalDate.now();

        Assertions.assertNotEquals(before,after);
        Assertions.assertEquals(expected,after);

    }
}
