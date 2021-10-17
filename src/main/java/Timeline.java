import java.util.HashMap;
import java.time.*;

public class Timeline {
    public static HashMap<Instant, Task> timeline;

    //constructor
    public Timeline() {
        //record the days events, task will eventually be changed to list of tasks, some multi index structure will be preferred
        this.timeline = new HashMap<Instant, Task>();
//        Task t = new Task(Instant.now(),Instant.now(),"");
//        this.addTask(t);

    }

    public Duration checkOverlap(Task task1, Task task2) {
        return
                Duration.between(task1.getStart(), task2.getStart()).
                        minus(Duration.between(task1.getEnd(), task2.getEnd()));
    }

    public void changeTaskTime() {

    }

    public void addTask(Task t) {
        this.timeline.put(t.getStart(), t);
    }

    @Override
    public String toString() {
        //return the days events in order
        for (Instant i : this.timeline.keySet()) {
            return this.timeline.get(i).toString();
        }
        return null;
    }
}