import controllers.TaskAndTimeController;
import dateAndTime.dateAndTimeAttributes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.taskEntities.EventTask;
import task.taskEntities.*;
import timeline.Timeline;

import java.time.LocalDate;
import java.time.LocalTime;

public class TaskAndTimeControllerTest {
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
        TaskAndTimeController controller = new TaskAndTimeController();

        controller.createTask(name,priority,description,startDate,startTime,endDate,endTime);

        Task expected = new EventTask(name,priority,description,dateRange,timeRange);
        Assertions.assertEquals(expected.toString(),controller.selectFromTaskList(0).toString());
    }

    @Test
    public void selectFromTimelineTest(){
        TaskAndTimeController controller = new TaskAndTimeController();

        controller.createTask(name,priority,description,startDate,startTime,endDate,endTime);

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
        TaskAndTimeController controller = new TaskAndTimeController();

        controller.createTask(name,priority,description,startDate,startTime,endDate,endTime);

        controller.editName(controller.selectFromTaskList(0),"newName");

        Task expected = new EventTask("newName",priority,description,dateRange,timeRange);

        Task output = controller.selectFromTimeline(startDate,startTime,0);

        Assertions.assertEquals(expected.toString(),output.toString());
    }

    @Test
    public void editTaskDateAndTime(){
        TaskAndTimeController controller = new TaskAndTimeController();

        String newStartDate = "2021-12-20";
        String newStartTime = "11:00";
        String newEndDate = "2021-12-22";
        String newEndTime = "12:00";

        DateRange newDateRange = new DateRange(LocalDate.parse(newStartDate), LocalDate.parse(newEndDate));
        TimeRange newTimeRange = new TimeRange(LocalTime.parse(newStartTime), LocalTime.parse(newEndTime));


        controller.createTask(name,priority,description,startDate,startTime,endDate,endTime);

        Task expected = new EventTask(name,priority,description,newDateRange,newTimeRange);

        Timeline expectedTimeline = new Timeline(newDateRange.getStartDate());
        expectedTimeline.addToTimeBlocks(newTimeRange.getStartTime(),expected);



        controller.editDate(controller.selectFromTaskList(0),newStartDate,newEndDate);
        controller.editTime(controller.selectFromTaskList(0),newStartTime,newEndTime);

        Task output = controller.selectFromTaskList(0);
        Timeline outputTimeline = controller.getTimelineManager().getTimeLine(output.getDate().getStartDate());

        Assertions.assertEquals(expected.toString(),output.toString());
        Assertions.assertEquals(expectedTimeline.toString(),outputTimeline.toString());

    }
}
