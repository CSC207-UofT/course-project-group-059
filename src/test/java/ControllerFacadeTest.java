import controllers.ControllerFacade;
import dateAndTime.dateAndTimeAttributes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.taskEntities.EventTask;
import task.taskEntities.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class ControllerFacadeTest {
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
        ControllerFacade controllerFacade = new ControllerFacade();

        controllerFacade.getTaskListController().createEventTask(name,priority,description,startDate,startTime,endDate,endTime);

        Task expected = new EventTask(name,priority,description,dateRange,timeRange);
        Assertions.assertEquals(expected.toString(), controllerFacade.getTaskListController().selectFromTaskList(0).toString());
    }

    @Test
    public void selectFromTimelineTest(){
        ControllerFacade controllerFacade = new ControllerFacade();

        controllerFacade.getTaskListController().createEventTask(name,priority,description,startDate,startTime,endDate,endTime);

        Task expected = new EventTask(name,priority,description,dateRange,timeRange);



        Task output = controllerFacade.getTimelineController().selectFromTimeline(startDate,startTime,0);

        Assertions.assertEquals(expected.toString(),output.toString());
    }

    @Test
    public void deleteTaskFromTaskListTest(){
        ControllerFacade controllerFacade = new ControllerFacade();

        controllerFacade.getTaskListController().createEventTask(name,priority,description,"Today",startTime,"Today",endTime);


        System.out.println(controllerFacade.getTimelineController().getTimelineManager().getTimeLine(LocalDate.now()));

        controllerFacade.getTaskListController().deleteTaskFromTaskList(0);


        System.out.println("\n"+ controllerFacade.getTimelineController().getTimelineManager().getTimeLine(LocalDate.now()));

    }
    @Test
    public void editTaskAllDayTest(){
        ControllerFacade controllerFacade = new ControllerFacade();

        controllerFacade.getTaskListController().createEventTask(name,priority,description,"Today",startTime,"Today",endTime);


        System.out.println(controllerFacade.getTaskListController().getTaskTracker().getTaskList());
        System.out.println("\n");
        System.out.println(controllerFacade.getTimelineController().getTimelineManager().getTimeLine(LocalDate.now()));

        controllerFacade.getTaskController().editAllDay(controllerFacade.getTaskListController().selectFromTaskList(0),true);

        System.out.println("\n");
        System.out.println(controllerFacade.getTaskListController().getTaskTracker().getTaskList());

        System.out.println("\n");

        System.out.println("\n"+ controllerFacade.getTimelineController().getTimelineManager().getTimeLine(LocalDate.now()));


    }


    @Test
    public void editTaskNameTest(){
        ControllerFacade controllerFacade = new ControllerFacade();

        controllerFacade.getTaskListController().createEventTask(name,priority,description,startDate,startTime,endDate,endTime);

        controllerFacade.getTaskController().editName(controllerFacade.getTaskListController().selectFromTaskList(0),"newName");

        Task expected = new EventTask("newName",priority,description,dateRange,timeRange);


        Task output = controllerFacade.getTimelineController().selectFromTimeline(startDate,startTime,0);

        System.out.println(expected);
        System.out.println(output);

        Assertions.assertEquals(expected.toString(),output.toString());
    }
}
