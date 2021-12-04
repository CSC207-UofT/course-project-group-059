package cmdUI;

import alarm.alarmUseCase.Pomodoro;
import gateways.CSVManager;
import printers.TaskListPrinter;
import printers.TimelinePrinter;

import task.taskController.TaskCreator;
import task.taskUseCases.TaskTracker;
import timeline.TimelineManager;
import task.tasklistEntities.TaskList;
import timeline.Timeline;

import java.util.Scanner;

public class UserFunctions{
    TaskList tasklist;
    TaskTracker tracker;
    Timeline timeline;
    TimelineManager timelineManager;

    public UserFunctions() {
        // TODO: Remove instances of TaskList and Timeline (Entities)
        this.tasklist = new TaskList();
        this.tracker = new TaskTracker(this.tasklist);
        this.timeline = new Timeline();
        this.timelineManager = new TimelineManager(this.timeline);

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
        CSVManager.read(this.tasklist);
    }

    public void saveCSV() {
        CSVManager.write(this.tasklist);
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
            TaskCreator.createTask(this.tracker);
        }
        else if (key.equalsIgnoreCase("2")) {
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
            TimelinePrinter.print(this.timeline);
        }
        else if (key.equalsIgnoreCase("2")) {
            TaskListPrinter.print(this.tracker);
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