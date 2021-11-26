package task.taskAttributes;

import task.taskEntities.Task;

public abstract class Text {
    protected String value;

    // deal with String-based attributes
    // Ex: name description
    public Text(String value){
        if(value.equals("")){
            this.value = "N/A";
        }
        else this.value = value;
    }

    public void update(String newValue){
        this.value = newValue;
    }

    public void update(Text text){this.value = text.toString(); }

    // part of the strategy pattern
    public void overwriteToTask(Task task){}

    @Override
    public String toString() {
        return value;
    }
}
