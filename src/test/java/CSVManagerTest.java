import controllers.ControllerFacade;
import dateAndTime.dateAndTimeAttributes.*;
import gateways.CSVManager;
import org.junit.jupiter.api.Test;
import task.taskEntities.EventTask;
import task.taskEntities.Task;
import task.taskEntities.TodoTask;

import java.time.LocalDate;
import java.time.LocalTime;

public class CSVManagerTest {

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

    @Test
    public void testReadAndWrite(){
        ControllerFacade controllerFacade = new ControllerFacade();

        Task newEventTask = new EventTask(name,priority,description,dateRange,timeRange);
        Task newTodoTask= new TodoTask(name,priority,description,oneDay,oneTime);

        //create event
        controllerFacade.getTaskListController().createEventTask(name,priority,description,startDate,startTime,endDate,endTime);
        controllerFacade.getTaskListController().createTodoTask(name,priority,description,endDate,startTime);

        //save to CsV
        CSVManager.save(controllerFacade.getTaskListController().getTaskTracker());

        System.out.println("Before Delete:");
        System.out.println(controllerFacade.getTaskListController().getTaskTracker().getTaskList());


        //delete tasks
        controllerFacade.getTaskListController().deleteTaskFromTaskList(0);
        controllerFacade.getTaskListController().deleteTaskFromTaskList(0);

        System.out.println("\nAfter Delete:");
        System.out.println(controllerFacade.getTaskListController().getTaskTracker().getTaskList());

        CSVManager.load(controllerFacade.getTaskListController().getTaskTracker());

        System.out.println("\nAfter Load");
        System.out.println(controllerFacade.getTaskListController().getTaskTracker().getTaskList());

    }
}
