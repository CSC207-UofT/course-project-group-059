import abstractClasses.Task;
import org.junit.Test;
import taskEntities.*;
import taskEntities.SubTask;
import timeEntities.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

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
    public void runTest() {

        //Test EventTask
        TestEventTask();


        //Test TodoTask
        TestTodoTask();

        //Test SubTask
        TestSubTask();



    }

    void TestEventTask(){
        Task newTask = new EventTask(name,priority,description,dateRange,timeRange);

        String expected = "Task{name='Math Work', priority='', description='', evaluation='', subTasks=null, " +
                "date=DateRange{startDate=2021-10-17, endDate=2021-10-17}, time=TimeRange{startTime=14:00, endTime=15:00}, "+
                "remind=null, finished=false, recurring=false, allDay=false}";

        assertEquals(expected, newTask.toString());


    }

    void TestTodoTask(){
        Task newTask= new TodoTask(name,priority,description,oneDay,oneTime);


        String expected = "Task{name='Math Work', priority='', description='', evaluation='', subTasks=null, " +
                "date=Oneday{Date=2021-10-17}, time=Onetime{endTime=15:00}, "+
                "remind=null, finished=false, recurring=false, allDay=false}";
    }

    void TestSubTask(){
        Task newTask = new SubTask(name,priority,description);

        String expected = "Task{name='Math Work', priority='', description='', evaluation='', subTasks=null";


    }

}