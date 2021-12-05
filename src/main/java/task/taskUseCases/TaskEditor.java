package task.taskUseCases;

import task.taskEntities.Task;
import editStrategies.EditStrategy;
import task.taskEntities.SubTask;

public class TaskEditor{

    public static void editTask(Task task, EditStrategy strategy){
        strategy.edit(task);
    }

    public static void creatSubTask(Task task, String name, String priority, String description){
        addSubTask(task, new SubTask(name,priority,description));
    }

    public static void addSubTask(Task task, SubTask subTask){
        task.getSubTasks().add(subTask);
    }

    public static void deleteSubTask(Task task, SubTask subTask){
        task.getSubTasks().remove(subTask);
    }
}
