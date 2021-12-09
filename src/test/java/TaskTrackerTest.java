import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.taskEntities.EventTask;
import task.taskEntities.Task;
import task.taskUseCases.TaskTracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;



public class TaskTrackerTest {

    String name = "Math Work";
    String priority = "";
    String description = "";
    String startDate = "2021-10-17";
    String startTime = "14:00";
    String endDate = "2021-10-17";
    String endTime = "15:00";

    DateRange dateRange = new DateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
    TimeRange timeRange = new TimeRange(LocalTime.parse(startTime), LocalTime.parse(endTime));

    @Test
    void TaskListTest(){
        TaskTracker tracker = new TaskTracker();

        Task task = new EventTask(name,priority,description,dateRange,timeRange);

        tracker.addTask(task);

        ArrayList<Task> expected = new ArrayList<>();

        expected.add(task);

        Assertions.assertEquals(tracker.getTaskList().getTaskList().size(), 1);

        Assertions.assertEquals(expected.get(0), tracker.getTaskList().getTaskList().get(0));

        tracker.deleteTask(task);

        Assertions.assertEquals(tracker.getTaskList().getTaskList().size(), 0);

        tracker.getTaskList().getTaskList().clear();
    }
}
