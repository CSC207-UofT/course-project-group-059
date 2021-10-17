import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TaskTracker {
    private static ArrayList<Task> listOfTask;

    //constructor
    public TaskTracker() {
        listOfTask = new ArrayList<>();
    }

    public void addTask(Task task){
        listOfTask.add(task);
        System.out.println("You added the following task: \n" + task);
    }

    // create and add Task into list
    // Comment: This part is basic repeating constructor of the Task class, I want to know if there is any better approach.
    /*public void createTask(String name, String priority, String description){
        Task newTask = new Task(name,priority,description);
        addTask(newTask);
    }*/

    public void createTask(String name, String priority, String description, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime){
        Task newTask = new Task(name,priority,description,startDate,startTime,endDate,endTime);
        addTask(newTask);
    }

    /*public void createTask(String name, String priority, String description, LocalDate endDate, LocalTime endTime){
        Task newTask = new Task(name,priority,description,endDate,endTime);
        addTask(newTask);
    }

    public void deleteTask(Task task){
        listOfTask.remove(task);
    }


    public void editTask(Task task, char ACTION){
        //TODO: to be implemented
    }



    // add task in to time if it's the day automatically
    public void AutoAddToTime(Timeline timeline){
        for(Task task : listOfTask){
            if(task.getEndDate().equals(LocalDate.now()) || task.getStartDate().equals(LocalDate.now())){
                timeline.addTaskToTimeLine(task);
            }
        }

    }*/


    // return the entire task list in String.
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Your Task list:");
        for(Task task: listOfTask){
            output.append("\n");
            output.append(task.toString());
        }

        return output.toString();
    }
}