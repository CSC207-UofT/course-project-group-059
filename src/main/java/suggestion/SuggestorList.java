package suggestion;

import task.taskEntities.Task;

import java.util.ArrayList;
import java.util.List;

public class SuggestorList {

    private List<Task> suggestions = new ArrayList<>();

    public List<Task> getSuggestions() {
        return suggestions;
    }
    public void setSuggestions(List<Task> suggestions) {
        this.suggestions = suggestions;
    }

@Override
    public String toString() {
        StringBuilder output = new StringBuilder("Your to-do list:");

        output.append("\n");
        if (suggestions.isEmpty()) {
            output.append("(Currently Empty)");
        }
        else {
            for (Task task: suggestions) {
                output.append(task);
                output.append("\n");
            }
        }

        return output.toString();
    }
}
