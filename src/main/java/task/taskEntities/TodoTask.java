package task.taskEntities;

import dateAndTime.dateAndTimeAttributes.OneDay;
import dateAndTime.dateAndTimeAttributes.OneTime;

public class TodoTask extends Task {
    public TodoTask(String name, String priority, String description, OneDay date, OneTime time) {
        super(name, priority, description, date, time);
    }

}
