package printers;

import task.taskUseCases.TaskTracker;
import task.tasklistEntities.TaskList;

public class TaskListPrinter extends Printer {
    public static void print(TaskTracker tracker) {
        // Call toString in the tasklist
        TaskList tasklist = tracker.getTaskList();
        System.out.println(tasklist.toString());
    }
}
