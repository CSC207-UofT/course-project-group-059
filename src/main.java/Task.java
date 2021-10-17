import java.time.*;
import java.util.ArrayList;
public class Task{
    private String name;
    private String priority;
    private String description;
    private String evaluation;

    private ArrayList<SubTask> subTasks;

    private boolean finished;
    private boolean recurring;
    private boolean allDay;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;


    public Task(){
        // Empty task
    }

    // constructor that creat a task without time.
    // *This kind of task is the default to-do task.
    public Task(String name, String priority, String description) {

        if(name.equals("")){
            this.name = "Unnamed";
        }
        else{
            this.name = name;
        }

        this.priority = priority;
        this.description = description;

        this.evaluation = "";
        this.subTasks = new ArrayList<>();
        this.finished = false;
        this.recurring = false;
        this.allDay = false;
    }

    // For the date and time the parameter is String. Using format "YYYY-MM-DD" for Date, "HH : mm" for time.

    // constructor that crate a task with start/end date and time.
    public Task(String name, String priority, String description, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime){

        if(name.equals("")){
            this.name = "Unnamed";
        }
        else{
            this.name = name;
        }

        this.priority = priority;
        this.description = description;

        this.startDate = startDate;
        this.startTime = startTime;

        this.endDate = endDate;
        this.endTime = endTime;

        this.evaluation = "";
        this.subTasks = new ArrayList<>();
        this.finished = false;
        this.recurring = false;
        this.allDay = false;
    }

    // constructor that crate a task with only due date and time.
    public Task(String name, String priority, String description, LocalDate endDate, LocalTime endTime){

        if(name.equals("")){
            this.name = "Unnamed";
        }
        else{
            this.name = name;
        }

        this.priority = priority;
        this.description = description;

        this.endDate = endDate;
        this.endTime = endTime;

        this.evaluation = "";
        this.subTasks = new ArrayList<>();
        this.finished = false;
        this.recurring = false;
        this.allDay = false;
    }


    //TODO: making a constructor that deal with boolean attributes.


    //Getters and Setters

    public String getName() {
        return name;
    }

    /*public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public ArrayList<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(ArrayList<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }*/



    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }


    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", description='" + description + '\'' +
                ", evaluation='" + evaluation + '\'' +
                ", subTasks=" + subTasks +
                ", finished=" + finished +
                ", recurring=" + recurring +
                ", allDay=" + allDay +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}