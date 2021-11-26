package task.taskAttributes;

import task.taskEntities.Task;

public class Recurring extends Status {
    public Recurring() {
    }

    public Recurring(boolean value) {
        super(value);
    }

    @Override
    public void overwriteToTask(Task task) {
        task.getRecurring().update(this);
    }
}
