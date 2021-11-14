package taskEntities;

import abstractClasses.Date;
import abstractClasses.Task;
import abstractClasses.Time;
import timeEntities.OneDay;
import timeEntities.OneTime;

public class TodoTask extends Task {
    public TodoTask(String name, String priority, String description, OneDay date, OneTime time) {
        super(name, priority, description, date, time);
    }
}
