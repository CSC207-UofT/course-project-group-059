package cmdUI;

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
    }

    // Begin prompt which allows user to access features
    public void mainMenu() {
        System.out.println("Welcome back!");
        System.out.println("What would you like to do?");
        String msg = "\nM to manage tasks" +
                "\nP to print information" +
                "\nX to exit";

        // Repeat message until user chooses to exit
        while (true) {
            System.out.println(msg);

            Scanner reader = new Scanner(System.in);
            String key = reader.next();

            if (key.equalsIgnoreCase("M")) {
                manageTask();
            }
            else if (key.equalsIgnoreCase("P")) {
                printer();
            }
            else if (key.equalsIgnoreCase("X")) {
                break;
            }
        }
    }

    // Ask user what to do, and access the corresponding method in the TaskTracker
    public void manageTask(){
        String msg = "\nA to create and add a task" +
                "\nENTER to exit";

        System.out.println(msg);

        Scanner reader = new Scanner(System.in);
        String key = reader.nextLine();

        // Call createTask
        if (key.equalsIgnoreCase("A")) {
            TaskCreator.createTask(this.tracker);
        }
    }

    // Print either Timeline, TaskList or Suggestion list
    public void printer(){
        String msg = "\nM to show timeline" +
                "\nL to show to-do list" +
                "\nS to show suggestion list" +
                "\nENTER to exit";

        System.out.println(msg);

        Scanner reader = new Scanner(System.in);
        String key = reader.nextLine();

        // Call print method in respective printer classes
        if (key.equalsIgnoreCase("M")) {
            TimelinePrinter.print(this.timeline);
        }
        else if (key.equalsIgnoreCase("L")) {
            TaskListPrinter.print(this.tracker);
        }
        else if (key.equalsIgnoreCase("S")) {
            System.out.println("Not implemented yet");
        }
    }

    // TODO: Add method for Pomodoro



}