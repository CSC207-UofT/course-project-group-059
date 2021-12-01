package task.taskController;

import task.taskUseCases.TaskTracker;

import java.util.Scanner;

public class TaskCreator {
    public static void createTask(TaskTracker tracker) {
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

        //TODO: A task creator for TODOTask
        tracker.creatEventTask(name,priority,description,startDate,startTime,endDate,endTime);
    }
}
