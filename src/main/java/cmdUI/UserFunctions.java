package cmdUI;

import alarm.alarmUseCase.Pomodoro;
import controllers.TaskAndTimeController;
import gateways.CsvManager;
import printers.SuggestionPrinter;
import printers.TaskListPrinter;
import printers.TimelinePrinter;

import java.time.LocalDate;
import java.util.Scanner;

public class UserFunctions{
    private final TaskAndTimeController controller;

    public UserFunctions() {
        controller = new TaskAndTimeController();
    }

    // Load CSV and print opening message
    public void startUp() {
        // Load saved CSV file if it exists
        loadCSV();

        System.out.println("Welcome back!");
        System.out.println("What would you like to do?");
        mainMenu();
    }

    // Begin prompt which allows user to access features
    public void mainMenu() {
        String msg = "\n1: Manage tasks" +
                "\n2: Print information" +
                "\n3: Start Pomodoro timer" +
                "\nOther: Save and exit program" +
                "\nType the corresponding number: ";

        // Repeat message until user chooses to exit
        while (true) {
            System.out.println(msg);

            Scanner reader = new Scanner(System.in);
            String key = reader.next();

            if (key.equalsIgnoreCase("1")) {
                manageTask();
            }
            else if (key.equalsIgnoreCase("2")) {
                printer();
            }
            else if (key.equalsIgnoreCase("3")) {
                startPomodoro();
            }
            // Save state to CSV, then break loop
            else {
                System.out.println("Saving data...");
                saveCSV();
                System.out.println("Exiting program.");
                break;
            }
        }
    }

    public void loadCSV() {
        CsvManager.read(controller.getTaskTracker().getTaskList());
    }

    public void saveCSV() {
        CsvManager.write(controller.getTaskTracker().getTaskList());
    }

    // Ask user what to do, and access the corresponding method in the TaskTracker
    public void manageTask(){
        String msg = "\n1: Create and add a task" +
                "\n2: Edit tasks" +
                "\nOther: Return to main menu" +
                "\nType the corresponding number: ";

        System.out.println(msg);

        Scanner reader = new Scanner(System.in);
        String key = reader.nextLine();

        // Call createTask
        if (key.equalsIgnoreCase("1")) {
            TaskCreator.createTask();
        }
        // Use editing methods in TaskAndTimeController
        else if (key.equalsIgnoreCase("2")) {
            TaskEditInUI.editTask(controller);
        }
    }

    // Print either Timeline, TaskList or Suggestion list
    public void printer(){
        String msg = "\n1: Show timeline" +
                "\n2: Show to-do list" +
                "\n3: Show suggestion list" +
                "\nOther: Return to main menu" +
                "\nType the corresponding number: ";

        System.out.println(msg);

        Scanner reader = new Scanner(System.in);
        String key = reader.nextLine();

        // Call print method in respective printer classes
        if (key.equalsIgnoreCase("1")) {
            TimelinePrinter.print(controller.getTimelineManager().getTimeLine(LocalDate.now()));
        }
        else if (key.equalsIgnoreCase("2")) {
            TaskListPrinter.print(controller.getTaskTracker().getTaskList());
        }
        else if (key.equalsIgnoreCase("3")) {
            SuggestionPrinter.print(controller.getTaskTracker());
        }
    }

    // Creates and starts an instance of Pomodoro
    public void startPomodoro(){
        int workIntervals = 2;
        int shortDur = 5;
        int longDur = 20;
        int workDur = 25;
        System.out.println("Pomodoro started.");
        Pomodoro pomodoro = new Pomodoro(workIntervals, shortDur, longDur, workDur);
    }
}