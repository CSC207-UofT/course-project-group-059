package task.taskAttributes;

import task.taskEntities.Task;

public abstract class Status {
    protected boolean value;

    public Status(){
        this.value = false;
    }

    // deal wih boolean attributes such as allDay etc
    public Status (boolean value){
        this.value = value;
    }

    public void update(String bool){ this.value = bool.equals("true");}

    public void update(boolean newValue){
        this.value = newValue;
    }

    public void update(Status newStatus){this.value = newStatus.getBool();}

    // part of the strategy pattern
    public void overwriteToTask(Task task){}

    public boolean getBool() {
        return value;
    }

    @Override
    public String toString() {
        if(value){
            return "true";
        }
        else{
            return "false";
        }
    }
}
