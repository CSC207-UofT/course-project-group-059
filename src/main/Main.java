import taskEntities.TaskList;
import taskEntities.Timeline;

public class Main {
        public static void main(String[]args){
            TaskList tasklist = new TaskList();
            TaskTracker tracker = new TaskTracker(tasklist);
            Timeline timeline = new Timeline();

            UserFunctions.mainMenu(timeline,tracker);
        }
    }