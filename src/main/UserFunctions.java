//import abstractClasses.Date;
import abstractClasses.Task;
import printers.TaskListPrinter;
import printers.TimelinePrinter;
import taskEntities.EventTask;
import taskEntities.TaskList;
import taskEntities.Timeline;
import timeEntities.DateRange;
import timeEntities.TimeRange;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class UserFunctions{

    public static void mainMenu(Timeline timeline, TaskTracker tracker) {
        System.out.println("Welcome back!");
        System.out.println("What would you like to do?");
        String msg = "\nM to manage tasks" +
                     "\nP to show information" +
                     "\nX to exit";

        while (true) {
            System.out.println(msg);

            Scanner reader = new Scanner(System.in);
            String key = reader.next();

            if (key.equalsIgnoreCase("M")) {
                manageTask(timeline, tracker);
            }
            else if (key.equalsIgnoreCase("P")) {
                printer(timeline,tracker);
            }
            else if (key.equalsIgnoreCase("X")) {
                break;
            }
        }
    }

    // ask user what to do, and access the corresponding method in abstractClasses.Task tracker
    public static void manageTask(Timeline timeline, TaskTracker tracker){
        String msg = "\nA to create and add a task" +
                     "\nENTER to exit";

        System.out.println(msg);

        Scanner reader = new Scanner(System.in);
        String key = reader.nextLine();

        if (key.equalsIgnoreCase("A")) {
            taskCreation(tracker);
        }
    }

    // print either taskEntities.Timeline, TaskList or Suggestion list
    public static void printer(Timeline timeline, TaskTracker tracker){
        String msg = "\nM to show timeline" +
                     "\nL to show to-do list" +
                     "\nS to show suggestion list" +
                     "\nENTER to exit";


        System.out.println(msg);

        Scanner reader = new Scanner(System.in);
        String key = reader.nextLine();

        if (key.equalsIgnoreCase("M")) {
            TimelinePrinter.print(timeline);
        }
        else if (key.equalsIgnoreCase("L")) {
            TaskList tasklist = tracker.getTaskList();
            TaskListPrinter.print(tasklist);
        }
        else if (key.equalsIgnoreCase("S")) {
            System.out.println("Not implemented yet");
        }

    }

    // method about pomodoro



    // Some helper methods
    public static void taskCreation(TaskTracker tracker){
        Scanner reader = new Scanner(System.in);

        System.out.println("Please input the task name");
        String name = reader.nextLine();
        System.out.println("Please input the priority");
        String priority = reader.nextLine();
        System.out.println("Please input the task description");
        String description = reader.nextLine();
        System.out.println("Please input the start date of the task (YYYY-MM-DD)");
        String startDate = reader.nextLine();
        System.out.println("Please input the start time of the task (HH:mm)");
        String startTime = reader.nextLine();
        System.out.println("Please input the end date of the task (YYYY-MM-DD)");
        String endDate = reader.nextLine();
        System.out.println("Please input the end time of the task (HH:mm)");
        String endTime = reader.nextLine();
        DateRange dateRange = new DateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
        TimeRange timeRange = new TimeRange(LocalTime.parse(startTime), LocalTime.parse(endTime));
        Task task = new EventTask(name,priority,description, dateRange, timeRange);
        tracker.addTask(task);
    }

}