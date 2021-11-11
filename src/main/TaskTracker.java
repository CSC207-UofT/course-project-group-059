import abstractClasses.Task;

import java.util.ArrayList;

public class TaskTracker {
    private static ArrayList<Task> listOfTasks;

    //constructor
    public TaskTracker() {
        listOfTasks = new ArrayList<>();
    }

    public void addTask(Task task){
        listOfTasks.add(task);
        System.out.println(this);
    }

    // create and add abstractClasses.Task into list
    // Comment: This part is basic repeating constructor of the abstractClasses.Task class, I want to know if there is any better approach.
    /*public void createTask(String name, String priority, String description){
        abstractClasses.Task newTask = new abstractClasses.Task(name,priority,description);
        addTask(newTask);
    }*/

//    public void createTask(String name, String priority, String description, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime){
//        abstractClasses.Task newTask = new abstractClasses.Task(name,priority,description,startDate,startTime,endDate,endTime);
//        addTask(newTask);
//    }

    /*public void createTask(String name, String priority, String description, LocalDate endDate, LocalTime endTime){
        abstractClasses.Task newTask = new abstractClasses.Task(name,priority,description,endDate,endTime);
        addTask(newTask);
    }

    public void deleteTask(abstractClasses.Task task){
        listOfTask.remove(task);
    }


    public void editTask(abstractClasses.Task task, char ACTION){
        //TODO: to be implemented
    }



    // add task in to time if it's the day automatically
    public void AutoAddToTime(Timeline timeline){
        for(abstractClasses.Task task : listOfTask){
            if(task.getEndDate().equals(LocalDate.now()) || task.getStartDate().equals(LocalDate.now())){
                timeline.addTaskToTimeLine(task);
            }
        }

    }*/


    // return the entire task list in String.
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Your abstractClasses.Task list:");
        for(Task task: listOfTasks){
            output.append("\n");
            output.append(task.toString());
        }

        return output.toString();
    }
}