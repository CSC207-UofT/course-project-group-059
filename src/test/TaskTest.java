import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

// Test that abstractClasses.Task in scenario walk-through is printed correctly
public class TaskTest {

    @Test
    public void runTest() {
        String name = "Math Work";
        String priority = "";
        String description = "";
        String startDate = "2021-10-17";
        String startTime = "14:00";
        String endDate = "2021-10-17";
        String endTime = "15:00";

//        abstractClasses.Task newTask = new abstractClasses.Task(name,priority,description,LocalDate.parse(startDate), LocalTime.parse(startTime),
//                LocalDate.parse(endDate),LocalTime.parse(endTime));
//
//        String expected = "abstractClasses.Task{name='Math Work', priority='', description='', evaluation='', " +
//                          "subTasks=[], finished=false, recurring=false, allDay=false, " +
//                          "startDate=2021-10-17, endDate=2021-10-17, startTime=14:00, endTime=15:00}";
//        String output = newTask.toString();
//
//        assertEquals(expected, output);


        // Test EventTask

        // Test TodoTask

        // Test SubTask


    }
}
