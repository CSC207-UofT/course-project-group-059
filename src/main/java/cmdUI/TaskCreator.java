package cmdUI;

import controllers.Controller;

import java.util.Scanner;

public class TaskCreator {
    public static void createTask() {
        Controller controller = new Controller();
        Scanner reader = new Scanner(System.in);

        System.out.println("Please Input the task Type (Event/Todo)");
        String type = reader.nextLine();
        System.out.println("Please input the task name");
        String name = reader.nextLine();
        System.out.println("Please input the priority");
        String priority = reader.nextLine();
        System.out.println("Please input the task description");
        String description = reader.nextLine();

        if(type.equals("Event")){
            System.out.println("Please input the start date of the task (YYYY-MM-DD)");
            String startDate = reader.nextLine();
            System.out.println("Please input the start time of the task (HH:mm)");
            String startTime = reader.nextLine();
            System.out.println("Please input the end date of the task (YYYY-MM-DD)");
            String endDate = reader.nextLine();
            System.out.println("Please input the end time of the task (HH:mm)");
            String endTime = reader.nextLine();

            controller.createEventTask(name,priority,description,startDate,startTime,endDate,endTime);
        }

        else{
            System.out.println("Please input the start date of the task (YYYY-MM-DD)");
            String date = reader.nextLine();
            System.out.println("Please input the start time of the task (HH:mm)");
            String time = reader.nextLine();

            controller.createEventTask(name,priority,description,date,time,date,time);
        }
    }
}
