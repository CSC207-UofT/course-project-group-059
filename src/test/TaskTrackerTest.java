import abstractClasses.Task;
import org.junit.Test;
import taskEntities.EventTask;
import taskEntities.SubTask;
import taskEntities.TaskList;

import java.util.ArrayList;



public class TaskTrackerTest {

    TaskList taskList = new TaskList();

    @Test
    public void runTest() {

        TaskListTest();

        //TODO: test the observer implementation;

    }

    void TaskListTest(){
        TaskTracker tracker = new TaskTracker(taskList);

        Task task = new SubTask("name","priority","description");

        tracker.addTask(task);

        ArrayList<Task> expected = new ArrayList<>();
        expected.add(task);

        assert taskList.getTaskList().size() == 1;

        assert taskList.getTaskList().get(0).equals(expected.get(0));

        tracker.deleteTask(task);

        assert taskList.getTaskList().size() == 0;

        taskList.getTaskList().clear();
    }
}