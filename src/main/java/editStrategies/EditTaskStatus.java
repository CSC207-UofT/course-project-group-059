package editStrategies;

import task.taskAttributes.Status;
import task.taskEntities.Task;
import task.taskAttributes.*;

public class EditTaskStatus implements EditStrategy {
    private Status newStat;

    public EditTaskStatus(Status newStat) {
        this.newStat = newStat;
    }

    @Override
    public void edit(Task task) {
      if(newStat instanceof AllDay){task.getAllDay().update(newStat);}
      else if(newStat instanceof  Finished){task.getFinished().update(newStat);}
      else if(newStat instanceof Recurring){task.getRecurring().update(newStat);}
    }

}
