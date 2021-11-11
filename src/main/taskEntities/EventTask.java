package taskEntities;


import abstractClasses.Task;
import timeEntities.DateRange;
import timeEntities.TimeRange;

public class EventTask extends Task {

    public EventTask(String name, String priority, String description, DateRange dateRange, TimeRange timeRange) {
        super(name, priority, description, dateRange, timeRange);
    }

}
