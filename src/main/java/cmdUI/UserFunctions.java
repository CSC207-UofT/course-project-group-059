package cmdUI;

import printers.TaskListPrinter;
import printers.TimelinePrinter;
import task.taskUseCases.TaskCreator;
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
        this.tasklist = new TaskList();
        this.tracker = new TaskTracker(this.tasklist);
        this.timeline = new Timeline();
        this.timelineManager = new TimelineManager(this.timeline);
    }

    public void mainMenu() {
        System.out.println("Welcome back!");
        System.out.println("What would you like to do?");
        String msg = "\nM to manage tasks" +
                     "\nP to print information" +
                     "\nX to exit";

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

    // ask user what to do, and access the corresponding method in abstractClasses.Task tracker
    public void manageTask(){
        String msg = "\nA to create and add a task" +
                     "\nENTER to exit";

        System.out.println(msg);

        Scanner reader = new Scanner(System.in);
        String key = reader.nextLine();

        if (key.equalsIgnoreCase("A")) {
            TaskCreator.createTask(this.tracker);
        }
    }

    // print either storableEntities.Timeline, TaskList or Suggestion list
    public void printer(){
        String msg = "\nM to show timeline" +
                     "\nL to show to-do list" +
                     "\nS to show suggestion list" +
                     "\nENTER to exit";

        System.out.println(msg);

        Scanner reader = new Scanner(System.in);
        String key = reader.nextLine();

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

    // method about pomodoro



}