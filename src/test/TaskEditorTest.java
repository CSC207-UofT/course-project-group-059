import abstractClasses.Task;
import editStrategies.EditTaskStatus;
import editStrategies.EditTaskText;
import editStrategies.EditTime;
import org.junit.Test;
import taskAttributes.*;
import taskEntities.EventTask;
import taskEntities.SubTask;
import taskEntities.TodoTask;
import timeEntities.DateRange;
import timeEntities.OneDay;
import timeEntities.OneTime;
import timeEntities.TimeRange;

import javax.naming.Name;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TaskEditorTest {

    String name = "Math Work";
    String priority = "LOW";
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

        // test the editTaskText strategy
        editNameTest();
        editPriorityTest();
        editDescriptionTest();

        // test the editStatus strategy
        editAllDayTest();
        editFinishedTest();
        editRecurringTest();

        // test the editTime strategy
        editDateTest();
        editTimeTest();
        editDateAndTimeTest();

    }



    void editNameTest(){
        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskText(new TaskName("CSC207 Project")));

        EventTask expected = new EventTask("CSC207 Project", priority,description,dateRange,timeRange);

        assertEquals(expected.getName().toString(),eventTask.getName().toString());

    }

    void editPriorityTest(){
        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskText(new TaskPriority("HIGH")));

        EventTask expected = new EventTask(name, "HIGH",description,dateRange,timeRange);

        assertEquals(expected.getPriority().toString(),eventTask.getPriority().toString());

    }

    void editDescriptionTest(){
        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskText(new TaskDescription("Monday is the due day!!!")));

        EventTask expected = new EventTask(name, priority,"Monday is the due day!!!",dateRange,timeRange);

        assertEquals(expected.getDescription().toString(),eventTask.getDescription().toString());

    }

    void editAllDayTest() {
        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskStatus(new AllDay(true)));

        EventTask expected = new EventTask(name, priority,description,dateRange,timeRange);

        assertNotEquals(expected.getAllDay().getValue(), eventTask.getAllDay().getValue());
    }

    void editFinishedTest(){
        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskStatus(new Finished(true)));

        EventTask expected = new EventTask(name, priority,description,dateRange,timeRange);

        assertNotEquals(expected.getFinished().getValue(), eventTask.getFinished().getValue());
    }

    void editRecurringTest(){
        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskStatus(new Recurring(true)));

        EventTask expected = new EventTask(name, priority,description,dateRange,timeRange);

        assertNotEquals(expected.getRecurring().getValue(), eventTask.getRecurring().getValue());
    }


    void editDateTest(){

        String newStart = "2021-11-07";
        String newEnd = "2021-11-15";

        DateRange newDateRange = new DateRange(LocalDate.parse(newStart), LocalDate.parse(newEnd));

        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTime(newDateRange));

        EventTask expected = new EventTask(name, priority,description,newDateRange,timeRange);

        assertEquals(expected.getDate().toString(), eventTask.getDate().toString() );


    }

    void editTimeTest(){

        String newStart = "16:00";
        String newEnd = "18:00";

        TimeRange newTimeRange = new TimeRange(LocalTime.parse(newStart), LocalTime.parse(newEnd));

        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTime(newTimeRange));

        EventTask expected = new EventTask(name, priority,description,dateRange,newTimeRange);

        assertEquals(expected.getTime().toString(), eventTask.getTime().toString() );

    }

    void editDateAndTimeTest(){

        String newStartDate = "2021-11-07";
        String newEndDate = "2021-11-15";
        String newStartTime = "16:00";
        String newEndTime = "18:00";


        DateRange newDateRange = new DateRange(LocalDate.parse(newStartDate), LocalDate.parse(newEndDate));
        TimeRange newTimeRange = new TimeRange(LocalTime.parse(newStartTime), LocalTime.parse(newEndTime));


        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTime(newDateRange,newTimeRange));

        EventTask expected = new EventTask(name, priority,description,newDateRange,newTimeRange);

        assertEquals(expected.getDate().toString(), eventTask.getDate().toString() );
        assertEquals(expected.getTime().toString(), eventTask.getTime().toString());

    }


}