package task.taskEntities;


import dateAndTimeAttributes.DateRange;
import dateAndTimeAttributes.TimeRange;

public class EventTask extends Task {

    public EventTask(String name, String priority, String description, DateRange dateRange, TimeRange timeRange) {
        super(name, priority, description, dateRange, timeRange);
    }

}
