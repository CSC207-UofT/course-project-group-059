package editStrategies;

import task.taskEntities.Task;
import task.taskAttributes.Text;
import task.taskAttributes.*;

public class EditTaskText implements EditStrategy {

    private final Text newText;

    public EditTaskText(Text newText) {
        this.newText = newText;
    }

    @Override
    public void edit(Task task) {
        newText.overwriteToTask(task);
    }

}
