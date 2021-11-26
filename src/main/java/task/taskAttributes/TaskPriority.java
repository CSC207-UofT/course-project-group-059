package task.taskAttributes;


import task.taskEntities.Task;

public class TaskPriority extends Text {

    public TaskPriority(String value) {
        super(value);
    }

    @Override
    public void overwriteToTask(Task task) {
        task.getPriority().update(this);
    }
}
