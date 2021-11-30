package task.taskUseCases;

import dateAndTimeAttributes.DateRange;
import dateAndTimeAttributes.TimeRange;
import task.taskEntities.EventTask;
import task.taskEntities.Task;

import java.time.LocalDate;
import java.time.LocalTime;
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

        DateRange dateRange = new DateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
        TimeRange timeRange = new TimeRange(LocalTime.parse(startTime), LocalTime.parse(endTime));
        Task task = new EventTask(name, priority, description, dateRange, timeRange);
        tracker.addTask(task);
    }
}
