package cmdUI;

import alarm.alarmUseCase.Pomodoro;
import controllers.TaskAndTimeController;
import printers.TaskListPrinter;
import printers.TimelinePrinter;

import java.time.LocalDate;
import java.util.Scanner;

public class UserFunctions{
    private final TaskAndTimeController controller;

    public UserFunctions() {

        controller = new TaskAndTimeController();

        // Load saved CSV file if it exists
        loadCSV();

        System.out.println("Welcome back!");
        System.out.println("What would you like to do?");
    }

    // Begin prompt which allows user to access features
    public void mainMenu() {
        String msg = "\n1: Manage tasks" +
                "\n2: Print information" +
                "\n3: Start Pomodoro timer" +
                "\n4: Save and exit program" +
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
        // TODO: Implement when CSVManager is completed
        // CSVManager.load();
    }

    public void saveCSV() {
        // TODO: Implement when CSVManager is completed
        // CSVManager.save(this.tracker, this.timelineManager);
    }

    // Ask user what to do, and access the corresponding method in the TaskTracker
    public void manageTask(){
        String msg = "\n1: Create and add a task" +
                "\n2: Edit tasks" +
                "\n3: Return to main menu";

        System.out.println(msg);

        Scanner reader = new Scanner(System.in);
        String key = reader.nextLine();

        // Call createTask
        if (key.equalsIgnoreCase("1")) {
            TaskCreator.createTask();
        }
        else if (key.equalsIgnoreCase("2")) {
            // TODO: Implement when task editing is completed
            System.out.println("Not implemented yet");
            TaskCreator.createTask();
        }
        else if (key.equalsIgnoreCase("3")) {
            // TODO: Implement when task editing is completed
            System.out.println("Not implemented yet");
        }
    }

    // Print either Timeline, TaskList or Suggestion list
    public void printer(){
        String msg = "\n1: Show timeline" +
                "\n2: Show to-do list" +
                "\n3: Show suggestion list" +
                "\n4: Return to main menu";

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
            // TODO: Implement when suggestions are completed
            System.out.println("Not implemented yet");
        }
    }

    // Creates and starts an instance of Pomodoro
    public void startPomodoro(){
        int workIntervals = 2;
        int shortDur = 5;
        int longDur = 20;
        int workDur = 25;
        Pomodoro pomodoro = new Pomodoro(workIntervals, shortDur, longDur, workDur);
        System.out.println("Pomodoro started.");
    }
}