package abstractClasses;

public abstract class Status {
    protected boolean value;

    public Status(){
        this.value = false;
    }

    // deal wih boolean attributes such as allDay etc
    public Status (boolean value){
        this.value = value;
    }

    public void update(boolean newValue){
        this.value = newValue;
    }

    public void update(Status newStatus){this.value = newStatus.getValue();}

    public boolean getValue() {
        return value;
    }
}
