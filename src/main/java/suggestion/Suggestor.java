package suggestion;

import task.taskEntities.Task;
import task.taskUseCases.TaskTracker;
import java.util.Comparator;


public class Suggestor {
    private SuggestorList suggestions;
    private TaskTracker tracker;

    public Suggestor(TaskTracker tracker) {
        this.suggestions = new SuggestorList();
        this.tracker = tracker;

        for (Task t : tracker.getTaskList().getTaskList()){
            suggestions.getSuggestions().add(t);
        }

    }

public SuggestorList sortByDueDate(){
    suggestions.getSuggestions().sort(Comparator.comparing(obj -> obj.getDate().getEndDate()));
    return suggestions;
}
}
