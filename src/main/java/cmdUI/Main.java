package cmdUI;

import task.tasklistEntities.TaskList;
import timeline.Timeline;
import task.taskUseCases.TaskTracker;

public class Main {
        public static void main(String[]args){
            TaskList tasklist = new TaskList();
            TaskTracker tracker = new TaskTracker(tasklist);
            Timeline timeline = new Timeline();

            UserFunctions.mainMenu(timeline,tracker);
        }
    }