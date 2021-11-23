package task.taskEntities;

import dateAndTimeAttributes.OneDay;
import dateAndTimeAttributes.OneTime;

public class TodoTask extends Task {
    public TodoTask(String name, String priority, String description, OneDay date, OneTime time) {
        super(name, priority, description, date, time);
    }

}
