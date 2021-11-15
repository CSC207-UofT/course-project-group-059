package printers;

import abstractClasses.Printer;
import taskEntities.TaskList;

public class TaskListPrinter extends Printer {
    public static void print(TaskList tasklist) {
        // Call toString in the tasklist
        System.out.println(tasklist.toString());
    }
}
