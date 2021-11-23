package task.taskEntities;

import task.taskAttributes.*;
import dateAndTimeAttributes.Date;
import dateAndTimeAttributes.Time;
import dateAndTimeAttributes.TimeToRemind;

import java.util.ArrayList;
public abstract class Task{

    // Since there is so many attributes, I decided to implement a builder patterns,
    // which will allow a task to be easier to be edited

    protected TaskName name;
    protected TaskPriority priority;
    protected TaskDescription description;
    protected TaskEvaluation evaluation = new TaskEvaluation("");

    protected ArrayList<Task> subTasks;

    protected Date date;
    protected Time time;

    protected TimeToRemind remind;

    // The status are all false at default
    protected Finished finished = new Finished();
    protected Recurring recurring = new Recurring();
    protected AllDay allDay = new AllDay();

    public Task(){
        // Empty task
    }

    public Task(String name, String priority, String description) {
        this.name = new TaskName(name);
        this.priority = new TaskPriority(priority);
        this.description = new TaskDescription(description);
    }

    // constructor that creat a task with date and time
    public Task(String name, String priority, String description, Date date, Time time) {

        this.name = new TaskName(name);
        this.priority = new TaskPriority(priority);
        this.description = new TaskDescription(description);
        this.date = date;
        this.time = time;

    }

    public TaskName getName() {
        return name;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskDescription getDescription() {
        return description;
    }

    public TaskEvaluation getEvaluation() {
        return evaluation;
    }

    public ArrayList<Task> getSubTasks() {
        return subTasks;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {return time;}

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public TimeToRemind getRemind() {
        return remind;
    }

    public Finished getFinished() {
        return finished;
    }

    public Recurring getRecurring() {
        return recurring;
    }

    public AllDay getAllDay() {
        return allDay;
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
                ", finished=" + finished.getValue() +
                ", recurring=" + recurring.getValue() +
                ", allDay=" + allDay.getValue() +
                '}';
    }
}