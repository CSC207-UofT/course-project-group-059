import java.util.ArrayList;

public class TaskTracker {
    private ArrayList<Task> listOfTask;

    //constructor
    public TaskTracker() {
        this.listOfTask = new ArrayList<Task>();

    }

    public void addTask(Task task){
        this.listOfTask.add(task);
    }

    public void deleteTask(Task task){
        this.listOfTask.remove(task);
    }

    public void editTask(Task task, char ACTION){
        //to be implemented
    }

    // access some method in TimeLine to add tasks that are recurring or already have time in to timeline
    public void AddToTime(){

    }

    @Override
    public String toString() {
        return "";
    }
}