import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import suggestion.Suggester;
import task.taskEntities.EventTask;
import task.taskEntities.Task;
import task.taskUseCases.TaskTracker;

import java.time.LocalDate;
import java.time.LocalTime;

public class SuggesterTest {

    String name = "Math Work";
    String priority = "";
    String description = "";
    String startDate = "2021-10-17";
    String startTime = "14:00";
    String endDate = "2021-10-17";
    String endTime = "15:00";

    String endDate2 = "2025-05-23";
    String endDate3 = "2012-06-18";
    String endDate4 = "2021-12-16";

    DateRange dateRange = new DateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
    TimeRange timeRange = new TimeRange(LocalTime.parse(startTime), LocalTime.parse(endTime));
    DateRange dateRange2 = new DateRange(LocalDate.parse(startDate), LocalDate.parse(endDate2));
    DateRange dateRange3 = new DateRange(LocalDate.parse(startDate), LocalDate.parse(endDate3));
    DateRange dateRange4 = new DateRange(LocalDate.parse(startDate), LocalDate.parse(endDate4));


    @Test
    public void TestSuggester(){
        TaskTracker tracker = new TaskTracker();
        Task newTask = new EventTask(name,priority,description,dateRange,timeRange);
        Task newTask2 = new EventTask(name,priority,description,dateRange2,timeRange);
        Task newTask3 = new EventTask(name,priority,description,dateRange3,timeRange);
        Task newTask4 = new EventTask(name,priority,description,dateRange4,timeRange);


        tracker.addTask(newTask);
        tracker.addTask(newTask2);
        tracker.addTask(newTask3);
        tracker.addTask(newTask4);

        Suggester suggest = new Suggester();

        String expected = "Your to-do list by suggestion:\n" +
                "Task{name='Math Work', priority='N/A', description='N/A', evaluation='N/A', date=DateRange{startDate=2021-10-17, endDate=2021-10-17}, time=TimeRange{startTime=14:00, endTime=15:00}, finished=false, recurring=false, allDay=false}\n" +
                "Task{name='Math Work', priority='N/A', description='N/A', evaluation='N/A', date=DateRange{startDate=2012-06-18, endDate=2021-10-17}, time=TimeRange{startTime=14:00, endTime=15:00}, finished=false, recurring=false, allDay=false}\n" +
                "Task{name='Math Work', priority='N/A', description='N/A', evaluation='N/A', date=DateRange{startDate=2021-10-17, endDate=2021-12-16}, time=TimeRange{startTime=14:00, endTime=15:00}, finished=false, recurring=false, allDay=false}\n" +
                "Task{name='Math Work', priority='N/A', description='N/A', evaluation='N/A', date=DateRange{startDate=2021-10-17, endDate=2025-05-23}, time=TimeRange{startTime=14:00, endTime=15:00}, finished=false, recurring=false, allDay=false}\n";

        Assertions.assertEquals(expected, suggest.sortByDueDate().toString());


    }

}
