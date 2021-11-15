import abstractClasses.Task;
import interfaces.EditStrategy;
//import taskEntities.SubTask;

public class TaskEditor{

    public static void editTask(Task task, EditStrategy strategy){
        strategy.edit(task);
    }

//    public static void addSubTask(Task task, SubTask subTask){
//        task.getSubTasks().add(subTask);
//    }
//
//    public static void deleteSubTask(Task task, SubTask subTask){
//        task.getSubTasks().remove(subTask);
//    }
}
