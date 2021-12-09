import controllers.ControllerFacade;
import gateways.CSVManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.tasklistEntities.TaskList;

public class CSVManagerTest {

    String name = "Math Work";
    String priority = "";
    String description = "";
    String startDate = "2021-10-17";
    String startTime = "14:00";
    String endDate = "2021-10-17";
    String endTime = "15:00";
    @Test
    public void testReadAndWrite(){
        ControllerFacade controllerFacade = new ControllerFacade();

        //create event
        controllerFacade.getTaskListController().createEventTask(name,priority,description,startDate,startTime,endDate,endTime);
        controllerFacade.getTaskListController().createTodoTask(name,priority,description,endDate,startTime);

        TaskList expected = controllerFacade.getTaskListController().getTaskTracker().getTaskList();

        //save to CsV
        CSVManager.save(controllerFacade.getTaskListController().getTaskTracker());

        controllerFacade.getTaskListController().deleteTaskFromTaskList(0);
        controllerFacade.getTaskListController().deleteTaskFromTaskList(0);

        CSVManager.load(controllerFacade.getTaskListController().getTaskTracker());

        Assertions.assertEquals(expected.toString(), controllerFacade.getTaskListController().getTaskTracker().getTaskList().toString());


        controllerFacade.getTaskListController().deleteTaskFromTaskList(0);
        controllerFacade.getTaskListController().deleteTaskFromTaskList(0);
        CSVManager.save(controllerFacade.getTaskListController().getTaskTracker());

    }
}
