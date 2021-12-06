package cmdUI;

import controllers.TaskAndTimeController;
import printers.TaskListPrinter;

import java.util.Scanner;

public class TaskEditInUI {
    public static void editTask(TaskAndTimeController controller) {
        TaskListPrinter.print(controller.getTaskTracker().getTaskList());
        System.out.println("Type the index of the task to edit: ");
        Scanner reader = new Scanner(System.in);
        String indexStr = reader.nextLine();
        int index = Integer.parseInt(indexStr);
        index--;

        String attributes = "\nChoose what to edit: " +
                "\n1: Name" +
                "\n2: Priority" +
                "\n3: Description" +
                "\n4: All-day" +
                "\n5: Finished" +
                "\n6: Recurring" +
                "\n7: Date" +
                "\n8: Time" +
                "\n9: Delete Task" +
                "\nOther: Close editing" +
                "\nType the corresponding number: ";

        while (true) {
            System.out.println(attributes);
            String attribute = reader.nextLine();

            // TODO: Shorten this section
            if (attribute.equalsIgnoreCase("1")) {
                System.out.println("Enter new name: ");
                String newName = reader.nextLine();
                controller.editName(controller.selectFromTaskList(index), newName);
            }
            else if (attribute.equalsIgnoreCase("2")) {
                System.out.println("Enter new priority: ");
                String newPriority = reader.nextLine();
                controller.editPriority(controller.selectFromTaskList(index), newPriority);
            }
            else if (attribute.equalsIgnoreCase("3")) {
                System.out.println("Enter new description: ");
                String newDescription = reader.nextLine();
                controller.editDescription(controller.selectFromTaskList(index), newDescription);
            }
            else if (attribute.equalsIgnoreCase("4")) {
                System.out.println("Enter new status (T/F): ");
                String newAllDay = reader.nextLine();
                if (newAllDay.equalsIgnoreCase("T")) {
                    controller.editAllDay(controller.selectFromTaskList(index), true);
                }
                else {
                    controller.editAllDay(controller.selectFromTaskList(index), false);
                }
            }
            else if (attribute.equalsIgnoreCase("5")) {
                System.out.println("Enter new status (T/F): ");
                String newFinished = reader.nextLine();
                if (newFinished.equalsIgnoreCase("T")) {
                    controller.editFinished(controller.selectFromTaskList(index), true);
                }
                else {
                    controller.editFinished(controller.selectFromTaskList(index), false);
                }
            }
            else if (attribute.equalsIgnoreCase("6")) {
                System.out.println("Enter new status (T/F): ");
                String newRecurring = reader.nextLine();
                if (newRecurring.equalsIgnoreCase("T")) {
                    controller.editRecurring(controller.selectFromTaskList(index), true);
                }
                else {
                    controller.editRecurring(controller.selectFromTaskList(index), false);
                }
            }
            else if (attribute.equalsIgnoreCase("7")) {
                System.out.println("Enter new start date: ");
                String newStartDate = reader.nextLine();
                System.out.println("Enter new end date: ");
                String newEndDate = reader.nextLine();
                controller.editDate(controller.selectFromTaskList(index), newStartDate, newEndDate);
            }
            else if (attribute.equalsIgnoreCase("8")) {
                System.out.println("Enter new start time: ");
                String newStartTime = reader.nextLine();
                System.out.println("Enter new end time: ");
                String newEndTime = reader.nextLine();
                controller.editTime(controller.selectFromTaskList(index), newStartTime, newEndTime);
            }
            else if (attribute.equalsIgnoreCase("9")) {
                controller.deleteTaskFromTaskList(index);
            }
            else {
                break;
            }

            System.out.println("Edit complete.");
        }
    }
}
