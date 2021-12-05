
import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.OneDay;
import dateAndTime.dateAndTimeAttributes.OneTime;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import editStrategies.EditTaskStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.taskAttributes.AllDay;

import task.taskEntities.Task;
import task.taskEntities.TodoTask;
import task.taskUseCases.TaskEditor;
import timeline.Calender;
import timeline.Timeline;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

// Test that initial storableEntities.Timeline is printed correctly
public class CalenderAndTimelineTest {
    String name = "Math Work";
    String priority = "";
    String description = "";
    String startDate = "2021-10-17";
    String startTime = "14:00";
    String endDate = "2021-10-17";
    String endTime = "15:00";

    DateRange dateRange = new DateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
    OneDay oneDay = new OneDay(LocalDate.parse(endDate));
    TimeRange timeRange = new TimeRange(LocalTime.parse(startTime), LocalTime.parse(endTime));
    OneTime oneTime = new OneTime(LocalTime.parse(endTime));

    // Test the add, remove method in Calendar.class
    @Test
    public void calenderAddAndRemoveTest() {
        Calender calender = new Calender();
        calender.add(LocalDate.now());

        String expected = "calender:\n- "+ LocalDate.now();

        String output = calender.toString();

        Assertions.assertEquals(expected, output);

        calender.remove(LocalDate.now());
        expected = "calender:" ;
        output = calender.toString();

        Assertions.assertEquals(expected,output);
    }

    @Test
    public void calenderGetTest(){
        Calender calender = new Calender();
        calender.add(LocalDate.now());

        Timeline today = new Timeline(LocalDate.now());

        String expected = today.toString();
        String output = calender.get(LocalDate.now()).toString();

        Assertions.assertEquals(expected, output);
    }

    // Test the initial timeline is printed correctly
    @Test
    public void timelineInitialTest(){
        Timeline timeline = new Timeline(LocalDate.now());

        String expected = LocalDate.now()+ " timeline:\n00:00:\t\n01:00:\t\n02:00:\t\n03:00:\t\n04:00:\t\n05:00:\t\n" +
                          "06:00:\t\n07:00:\t\n08:00:\t\n09:00:\t\n10:00:\t\n11:00:\t\n" +
                          "12:00:\t\n13:00:\t\n14:00:\t\n15:00:\t\n16:00:\t\n17:00:\t\n" +
                          "18:00:\t\n19:00:\t\n20:00:\t\n21:00:\t\n22:00:\t\n23:00:\t";
        String output = timeline.toString();

        Assertions.assertEquals(expected, output);
    }



    // Test the timeline is print the task correctly
    @Test
    public void timelineAddToTimeBlocksTest(){

        Timeline timeLine = new Timeline(oneDay.getDate());
        Task newTask= new TodoTask(name,priority,description,oneDay,oneTime);

        timeLine.addToTimeBlocks(oneTime.getTime(),newTask);

        String expected = oneDay.getDate()+ " timeline:\n00:00:\t\n01:00:\t\n02:00:\t\n03:00:\t\n04:00:\t\n05:00:\t\n" +
                "06:00:\t\n07:00:\t\n08:00:\t\n09:00:\t\n10:00:\t\n11:00:\t\n" +
                "12:00:\t\n13:00:\t\n14:00:\t\n15:00:\t1. Math Work, \n16:00:\t\n17:00:\t\n" +
                "18:00:\t\n19:00:\t\n20:00:\t\n21:00:\t\n22:00:\t\n23:00:\t";

        String output = timeLine.toString();

        Assertions.assertEquals(expected, output);
    }

    @Test
    public void timelineAddToAllDayTest(){
        Timeline timeLine = new Timeline(oneDay.getDate());
        Task newTask= new TodoTask(name,priority,description,oneDay,oneTime);

        // set All day to true, although not really necessary in this test
        TaskEditor.editTask(newTask,new EditTaskStatus(new AllDay(true)));

        timeLine.getAllDayList().add(newTask);

        String expected = oneDay.getDate()+ " timeline:\n" +
                "All day: \t1. Math Work\n00:00:\t\n01:00:\t\n02:00:\t\n03:00:\t\n04:00:\t\n05:00:\t\n" +
                "06:00:\t\n07:00:\t\n08:00:\t\n09:00:\t\n10:00:\t\n11:00:\t\n" +
                "12:00:\t\n13:00:\t\n14:00:\t\n15:00:\t\n16:00:\t\n17:00:\t\n" +
                "18:00:\t\n19:00:\t\n20:00:\t\n21:00:\t\n22:00:\t\n23:00:\t";

        String output = timeLine.toString();

        Assertions.assertEquals(expected, output);


    }

}
