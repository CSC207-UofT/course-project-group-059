package task.taskAttributes;


import task.taskEntities.Task;

public class TaskEvaluation extends Text {

    public TaskEvaluation(String value) {
        super(value);
    }


    @Override
    public void overwriteToTask(Task task) {
        task.getEvaluation().update(this);
    }
}
