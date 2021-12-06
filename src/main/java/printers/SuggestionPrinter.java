package printers;

import suggestion.Suggestor;
import suggestion.SuggestorList;
import task.taskUseCases.TaskTracker;

public class SuggestionPrinter extends Printer {
    public static void print(TaskTracker tracker) {
        // Create a Suggestor, and call sortByDueDate
        Suggestor suggestor = new Suggestor(tracker);
        SuggestorList suggestion = suggestor.sortByDueDate();
        System.out.println(suggestion);
    }
}
