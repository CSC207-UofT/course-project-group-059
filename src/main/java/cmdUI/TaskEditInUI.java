package cmdUI;

import controllers.ControllerFacade;
import printers.Printer;
import task.taskEntities.Task;

import java.util.Scanner;

public class TaskEditInUI {
    public static void editTask(ControllerFacade controllerFacade) {
        Printer.print(controllerFacade.getTaskListController().getTaskTracker());
        System.out.println("Type the index of the task to edit: ");
        Scanner reader = new Scanner(System.in);
        String indexStr = reader.nextLine();
        int index = Integer.parseInt(indexStr);
        index--;

        Task target = controllerFacade.getTaskListController().selectFromTaskList(index);

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

            if (attribute.equalsIgnoreCase("1")) {
                System.out.println("Enter new name: ");
                String newName = reader.nextLine();
                controllerFacade.getTaskController().editName(target, newName);
            }
            else if (attribute.equalsIgnoreCase("2")) {
                System.out.println("Enter new priority: ");
                String newPriority = reader.nextLine();

                controllerFacade.getTaskController().editPriority(target, newPriority);
            }
            else if (attribute.equalsIgnoreCase("3")) {
                System.out.println("Enter new description: ");
                String newDescription = reader.nextLine();

                controllerFacade.getTaskController().editDescription(target, newDescription);
            }
            else if (attribute.equalsIgnoreCase("4")) {
                System.out.println("Enter new status (T/F): ");
                String newAllDay = reader.nextLine();

                controllerFacade.getTaskController().editAllDay(target, newAllDay.equalsIgnoreCase("T"));
            }
            else if (attribute.equalsIgnoreCase("5")) {
                System.out.println("Enter new status (T/F): ");
                String newFinished = reader.nextLine();

                controllerFacade.getTaskController().editFinished(target, newFinished.equalsIgnoreCase("T"));
            }
            else if (attribute.equalsIgnoreCase("6")) {
                System.out.println("Enter new status (T/F): ");
                String newRecurring = reader.nextLine();


                controllerFacade.getTaskController().editRecurring(target, newRecurring.equalsIgnoreCase("T"));
            }
            else if (attribute.equalsIgnoreCase("7")) {
                System.out.println("Enter new start date: ");
                String newStartDate = reader.nextLine();
                System.out.println("Enter new end date: ");
                String newEndDate = reader.nextLine();
                controllerFacade.getTaskController().editDate(target, newStartDate, newEndDate);
            }
            else if (attribute.equalsIgnoreCase("8")) {
                System.out.println("Enter new start time: ");
                String newStartTime = reader.nextLine();
                System.out.println("Enter new end time: ");
                String newEndTime = reader.nextLine();
                controllerFacade.getTaskController().editTime(target, newStartTime, newEndTime);
            }
            else if (attribute.equalsIgnoreCase("9")) {
                controllerFacade.getTaskListController().deleteTaskFromTaskList(index);
                break;
            }
            else {
                break;
            }

            System.out.println("Edit complete.");
        }
    }
}
