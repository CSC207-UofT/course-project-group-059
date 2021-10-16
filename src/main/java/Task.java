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
    private Instant begin;
    private Instant end;


    public Task(String name, String priority, String description) {
        this.name = name;
        this.priority = priority;
        this.description = description;

        this.evaluation = "";
        //this.subTasks = new ArrayList<>();
        this.finished = false;
    }
    public Task(Instant begin, Instant end, String name){
        this.name = name;
        this.begin = begin;
        this.end = end;

    }
    public Task(Instant begin, Instant end){
        this.name = "Un-named Task";
        this.begin = begin;
        this.end = end;

    }

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
    }

    public Instant getStart(){ return this.begin;}
    public Instant getEnd(){return this.end;}
    public int compare(Task task){
        return this.begin.compareTo(task.begin);
    }
}