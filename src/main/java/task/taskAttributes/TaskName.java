package task.taskAttributes;


import task.taskEntities.Task;

public class TaskName extends Text {

    public TaskName(String value) {
        super(value);
    }


    @Override
    public void overwriteToTask(Task task) {
        task.getName().update(this);
    }
}
