package java;

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

    public Task(String name, String priority, String description, boolean recurring, boolean allDay) {
        this.name = name;
        this.priority = priority;
        this.description = description;
        this.recurring = recurring;
        this.allDay = allDay;

        this.evaluation = "";
        this.subTasks = new ArrayList<>();
        this.finished = false;
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
}