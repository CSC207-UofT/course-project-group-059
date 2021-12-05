import task.taskEntities.Task;
import org.junit.jupiter.api.Test;
import task.taskEntities.SubTask;
import task.tasklistEntities.TaskList;
import task.taskUseCases.TaskTracker;

import java.util.ArrayList;



public class TaskTrackerTest {

    @Test
    void TaskListTest(){
        TaskTracker tracker = new TaskTracker();

        Task task = new SubTask("name","priority","description");

        tracker.addTask(task);

        ArrayList<Task> expected = new ArrayList<>();

        expected.add(task);

        assert tracker.getTaskList().getTaskList().size() == 1;

        assert tracker.getTaskList().getTaskList().get(0).equals(expected.get(0));

        tracker.deleteTask(task);

        assert tracker.getTaskList().getTaskList().size() == 0;

        tracker.getTaskList().getTaskList().clear();
    }
}
