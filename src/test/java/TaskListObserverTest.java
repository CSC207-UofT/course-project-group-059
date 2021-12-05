import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.OneDay;
import dateAndTime.dateAndTimeAttributes.OneTime;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.taskEntities.EventTask;
import task.taskUseCases.TaskTracker;
import timeline.Timeline;
import timeline.TimelineManager;

import java.time.LocalDate;
import java.time.LocalTime;

public class TaskListObserverTest {
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
    public void  timelineObserverTest(){
        TimelineManager timelineManager = new TimelineManager();
        TaskTracker taskTracker = new TaskTracker(timelineManager);

        taskTracker.creatEventTask(name,priority,description,startDate,startTime,endDate,endTime);

        Timeline timeline = new Timeline(dateRange.getStartDate());
        timeline.addToTimeBlocks(timeRange.getStartTime(),new EventTask(name,priority,description,dateRange,timeRange));

        Assertions.assertEquals(timelineManager.getTimeLine(dateRange.getStartDate()).toString(),timeline.toString());

        taskTracker.deleteTask(taskTracker.getTaskList().getTaskList().get(0));

        Assertions.assertEquals(timelineManager
                .getTimeLine(dateRange.getStartDate()).toString(),new Timeline(dateRange.getStartDate()).toString());

    }
}
