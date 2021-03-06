import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.OneDay;
import dateAndTime.dateAndTimeAttributes.OneTime;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.taskEntities.EventTask;
import task.taskEntities.Task;
import task.taskEntities.TodoTask;

import java.time.LocalDate;
import java.time.LocalTime;

// Test that abstractClasses.Task in scenario walk-through is printed correctly
public class TaskTest {

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
    public void TestEventTask(){
        Task newTask = new EventTask(name,priority,description,dateRange,timeRange);

        String expected = "Task{name='Math Work', priority='N/A', description='N/A', evaluation='N/A', subTasks=null, " +
                "date=DateRange{startDate=2021-10-17, endDate=2021-10-17}, time=TimeRange{startTime=14:00, endTime=15:00}, "+
                "finished=false, recurring=false, allDay=false}";


        Assertions.assertEquals(expected, newTask.toString());
    }
    @Test
    public void TestTodoTask(){
        Task newTask= new TodoTask(name,priority,description,oneDay,oneTime);


        String expected = "Task{name='Math Work', priority='N/A', description='N/A', evaluation='N/A', subTasks=null, " +
                "date=OneDay{date=2021-10-17}, time=OneTime{time=15:00}, "+
                "finished=false, recurring=false, allDay=false}";

        Assertions.assertEquals(expected, newTask.toString());
    }

}
