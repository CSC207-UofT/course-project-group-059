package suggestion;

import task.taskEntities.Task;
import task.taskUseCases.TaskObserver;
import task.taskUseCases.TaskTracker;
import task.tasklistEntities.TaskList;

import java.util.Comparator;


public class Suggester implements TaskObserver {
    private final SuggesterList suggestions;

    public Suggester() {
        suggestions = new SuggesterList();
        TaskTracker tracker = new TaskTracker();

        for (Task t : tracker.getTaskList().getTaskList()){
            suggestions.getSuggestions().add(t);
        }

    }

    // Sorting functionality
    public SuggesterList sortByDueDate(){
        suggestions.getSuggestions().sort(Comparator.comparing(obj -> obj.getDate().getEndDate()));
        return suggestions;
    }


    private void checkSuggestionList(TaskList taskList, Task task){
        //revise if any change in the taskList
        if(taskList.getTaskList().contains(task)&&
                !suggestions.getSuggestions().contains(task)){
            suggestions.getSuggestions().add(task);
        }
        else if(!taskList.getTaskList().contains(task)){
            suggestions.getSuggestions().remove(task);
        }
    }

    @Override
    public void refresh(TaskList taskList, Task task) {
        checkSuggestionList(taskList,task);
    }
}
