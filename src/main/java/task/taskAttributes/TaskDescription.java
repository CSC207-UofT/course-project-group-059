package task.taskAttributes;


import task.taskEntities.Task;

public class TaskDescription extends Text {

    public TaskDescription(String value) {
        super(value);
    }

    @Override
    public void overwriteToTask(Task task) {
        task.getDescription().update(this);
    }
}
