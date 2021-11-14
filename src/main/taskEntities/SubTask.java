package taskEntities;

import abstractClasses.Date;
import abstractClasses.Task;
import abstractClasses.Time;

public class SubTask extends Task {
    public SubTask(String name, String priority, String description) {
        super(name, priority, description);
    }


    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", description='" + description + '\'' +
                ", evaluation='" + evaluation + '\'' +
                ", subTasks=" + subTasks +
                '}';
    }
}
