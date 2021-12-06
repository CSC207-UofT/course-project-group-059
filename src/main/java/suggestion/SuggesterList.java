package suggestion;

import task.taskEntities.Task;

import java.util.ArrayList;
import java.util.List;

public class SuggesterList {

    private final List<Task> suggestions = new ArrayList<>();

    public List<Task> getSuggestions() {
        return suggestions;
    }

@Override
    public String toString() {
        StringBuilder output = new StringBuilder("Your to-do list by suggestion:");

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
