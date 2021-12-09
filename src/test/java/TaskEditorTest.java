import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.TimeRange;
import editStrategies.EditTaskDateAndTime;
import editStrategies.EditTaskStatus;
import editStrategies.EditTaskText;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.taskAttributes.*;
import task.taskEntities.EventTask;
import task.taskUseCases.TaskEditor;

import java.time.LocalDate;
import java.time.LocalTime;

public class TaskEditorTest {

    String name = "Math Work";
    String priority = "LOW";
    String description = "";
    String startDate = "2021-10-17";
    String startTime = "14:00";
    String endDate = "2021-10-17";
    String endTime = "15:00";

    DateRange dateRange = new DateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
    TimeRange timeRange = new TimeRange(LocalTime.parse(startTime), LocalTime.parse(endTime));



    @Test
    void editNameTest(){
        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskText(new TaskName("CSC207 Project")));

        EventTask expected = new EventTask("CSC207 Project", priority,description,dateRange,timeRange);

        Assertions.assertEquals(expected.getName().toString(),eventTask.getName().toString());

    }
    @Test
    void editPriorityTest(){
        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskText(new TaskPriority("HIGH")));

        EventTask expected = new EventTask(name, "HIGH",description,dateRange,timeRange);

        Assertions.assertEquals(expected.getPriority().toString(),eventTask.getPriority().toString());

    }
    @Test
    void editDescriptionTest(){
        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskText(new TaskDescription("Monday is the due day!!!")));

        EventTask expected = new EventTask(name, priority,"Monday is the due day!!!",dateRange,timeRange);

        Assertions.assertEquals(expected.getDescription().toString(),eventTask.getDescription().toString());

    }
    @Test
    void editAllDayTest() {
        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskStatus(new AllDay(true)));

        EventTask expected = new EventTask(name, priority,description,dateRange,timeRange);

        Assertions.assertNotEquals(expected.getAllDay().getBool(), eventTask.getAllDay().getBool());
    }
    @Test
    void editFinishedTest(){
        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskStatus(new Finished(true)));

        EventTask expected = new EventTask(name, priority,description,dateRange,timeRange);

        Assertions.assertNotEquals(expected.getFinished().getBool(), eventTask.getFinished().getBool());
    }
    @Test
    void editRecurringTest(){
        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskStatus(new Recurring(true)));

        EventTask expected = new EventTask(name, priority,description,dateRange,timeRange);

        Assertions.assertNotEquals(expected.getRecurring().getBool(), eventTask.getRecurring().getBool());
    }

    @Test
    void editDateTest(){

        String newStart = "2021-11-07";
        String newEnd = "2021-11-15";

        DateRange newDateRange = new DateRange(LocalDate.parse(newStart), LocalDate.parse(newEnd));

        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskDateAndTime(newDateRange));

        EventTask expected = new EventTask(name, priority,description,newDateRange,timeRange);

        Assertions.assertEquals(expected.getDate().toString(), eventTask.getDate().toString() );


    }
    @Test
    void editTimeTest(){

        String newStart = "16:00";
        String newEnd = "18:00";

        TimeRange newTimeRange = new TimeRange(LocalTime.parse(newStart), LocalTime.parse(newEnd));

        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskDateAndTime(newTimeRange));

        EventTask expected = new EventTask(name, priority,description,dateRange,newTimeRange);

        Assertions.assertEquals(expected.getTime().toString(), eventTask.getTime().toString() );

    }
    @Test
    void editDateAndTimeTest(){

        String newStartDate = "2021-11-07";
        String newEndDate = "2021-11-15";
        String newStartTime = "16:00";
        String newEndTime = "18:00";


        DateRange newDateRange = new DateRange(LocalDate.parse(newStartDate), LocalDate.parse(newEndDate));
        TimeRange newTimeRange = new TimeRange(LocalTime.parse(newStartTime), LocalTime.parse(newEndTime));


        EventTask eventTask = new EventTask(name,priority,description,dateRange,timeRange);

        TaskEditor.editTask(eventTask, new EditTaskDateAndTime(newDateRange,newTimeRange));

        EventTask expected = new EventTask(name, priority,description,newDateRange,newTimeRange);

        Assertions.assertEquals(expected.getDate().toString(), eventTask.getDate().toString() );
        Assertions.assertEquals(expected.getTime().toString(), eventTask.getTime().toString());

    }


}
