package task.taskAttributes;

import task.taskEntities.Task;

public class Finished extends Status {

    public Finished() {
    }

    public Finished(boolean value) {
        super(value);
    }

    @Override
    public void overwriteToTask(Task task) {
        task.getFinished().update(this);
    }
}
