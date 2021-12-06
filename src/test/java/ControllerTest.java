import controllers.Controller;
import dateAndTime.dateAndTimeAttributes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.taskEntities.EventTask;
import task.taskEntities.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class ControllerTest {
    String name = "Math Work";
    String priority = "";
    String description = "";
    String startDate = "2021-12-15";
    String startTime = "14:00";
    String endDate = "2021-12-16";
    String endTime = "17:00";

    DateRange dateRange = new DateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
    OneDay oneDay = new OneDay(LocalDate.parse(endDate));
    TimeRange timeRange = new TimeRange(LocalTime.parse(startTime), LocalTime.parse(endTime));
    OneTime oneTime = new OneTime(LocalTime.parse(endTime));

    @Test
    public void selectFromTaskListTest(){
        Controller controller = new Controller();

        controller.createEventTask(name,priority,description,startDate,startTime,endDate,endTime);

        Task expected = new EventTask(name,priority,description,dateRange,timeRange);
        Assertions.assertEquals(expected.toString(),controller.selectFromTaskList(0).toString());
    }

    @Test
    public void selectFromTimelineTest(){
        Controller controller = new Controller();

        controller.createEventTask(name,priority,description,startDate,startTime,endDate,endTime);

        Task expected = new EventTask(name,priority,description,dateRange,timeRange);

        Task output = controller.selectFromTimeline(startDate,startTime,0);

        Assertions.assertEquals(expected.toString(),output.toString());
    }

    //TODO:
    @Test
    public void removeTaskFromTimeLineTest(){

    }

    @Test
    public void editTaskTest(){
        Controller controller = new Controller();

        controller.createEventTask(name,priority,description,startDate,startTime,endDate,endTime);

        controller.editName(controller.selectFromTaskList(0),"newName");

        Task expected = new EventTask("newName",priority,description,dateRange,timeRange);


        Task output = controller.selectFromTimeline(startDate,startTime,0);

        System.out.println(expected);
        System.out.println(output);

        Assertions.assertEquals(expected.toString(),output.toString());
    }
}
