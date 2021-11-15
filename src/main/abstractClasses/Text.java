package abstractClasses;

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

    @Override
    public String toString() {
        return value;
    }
}
