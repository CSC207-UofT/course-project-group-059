package cmdUI;

import controllers.ControllerFacade;
import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.OneDay;
import dateAndTime.dateAndTimeAttributes.OneTime;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import printers.TaskListPrinter;
import printers.TimelinePrinter;

import java.time.LocalDate;
import java.time.LocalTime;


public class createTaskDemo {



    public static void createDemo(ControllerFacade controllerFacade){
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


        System.out.println("Creating demo task....\n");

        controllerFacade.getTaskListController().createEventTask(name,priority,description,"Today",startTime,"Today",endTime);

        System.out.println("Done!:\n");
        TimelinePrinter.print(controllerFacade.getTimelineController().getTimelineManager().getTimeLine(LocalDate.now()));
        System.out.println("\n");
        TaskListPrinter.print(controllerFacade.getTaskListController().getTaskTracker());
        System.out.println("\n");

    }


}
