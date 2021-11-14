package abstractClasses;

import timeEntities.TimeToRemind;

import java.util.ArrayList;
public abstract class Task{
    protected String name;
    protected String priority;
    protected String description;
    protected String evaluation;

    protected ArrayList<Task> subTasks;

    protected Date date;
    protected Time time;

    protected TimeToRemind remind;

    // The booleans are all false at default
    // Maybe not going to make contractors that deal with these bool.
    protected boolean finished = false;
    protected boolean recurring = false;
    protected boolean allDay = false;



    public Task(){
        // Empty task
    }

    public Task(String name, String priority, String description) {
        this.name = name;
        this.priority = priority;
        this.description = description;
    }

    // constructor that creat a task
    public Task(String name, String priority, String description, Date date, Time time) {

        if(name.equals("")){
            this.name = "Unnamed";
        }
        else{
            this.name = name;
        }

        this.priority = priority;
        this.description = description;
        this.date = date;
        this.time = time;


        this.evaluation = "";
    }





    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public ArrayList<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(ArrayList<Task> subTasks) {
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
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public TimeToRemind getRemind() {
        return remind;
    }

    public void setRemind(TimeToRemind remind) {
        this.remind = remind;
    }



    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", description='" + description + '\'' +
                ", evaluation='" + evaluation + '\'' +
                ", subTasks=" + subTasks +
                ", date=" + date +
                ", time=" + time +
                ", remind=" + remind +
                ", finished=" + finished +
                ", recurring=" + recurring +
                ", allDay=" + allDay +
                '}';
    }
}