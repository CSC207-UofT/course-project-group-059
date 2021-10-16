import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.time.*;

public class Timeline {
    private HashMap<Date, ArrayList<Task>> timeline;

    //constructor
    public Timeline(){
        this.timeline =  new HashMap<Date, ArrayList<Task>>();

    }

//    public Duration checkOverlap(Task task1, Task){
//
//
//    }

    public void changeTaskTime(){

    }

    @Override
    public String toString() {
        return "";
    }
    public static void main(String[] args) {
        String[] s = "a,ab,n".split(",");
        for(String i : s){
            System.out.println(i+s[0]);
        }
        Task t = new Task(s[0],s[1],s[2]);
        System.out.println(t.getStart());
        Date d = new Date(2021,12,20,10,10);
        Instant c = d.toInstant();
        System.out.println(d);
        System.out.println(c);

    }
}