package task.taskEntities;


import dateAndTime.dateAndTimeAttributes.DateRange;
import dateAndTime.dateAndTimeAttributes.TimeRange;

public class EventTask extends Task {

    public EventTask(String name, String priority, String description, DateRange dateRange, TimeRange timeRange) {
        super(name, priority, description, dateRange, timeRange);
    }

}
