package taskEntities;

//import abstractClasses.Date;
//import abstractClasses.Time;
import abstractClasses.Task;
import timeEntities.OneDay;
import timeEntities.OneTime;

public class TodoTask extends Task {
    public TodoTask(String name, String priority, String description, OneDay date, OneTime time) {
        super(name, priority, description, date, time);
    }

}
