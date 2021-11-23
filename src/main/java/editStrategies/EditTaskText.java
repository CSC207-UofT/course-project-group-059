package editStrategies;

import task.taskEntities.Task;
import task.taskAttributes.Text;
import task.taskAttributes.*;

public class EditTaskText implements EditStrategy {

    private Text newText;

    public EditTaskText(Text newText) {
        this.newText = newText;
    }

    @Override
    public void edit(Task task) {
        if (newText instanceof TaskName){task.getName().update(newText);}
        else if(newText instanceof TaskPriority){task.getPriority().update(newText);}
        else if (newText instanceof TaskDescription){task.getDescription().update(newText);}
        else if (newText instanceof  TaskEvaluation){task.getEvaluation().update(newText);}
    }

}
