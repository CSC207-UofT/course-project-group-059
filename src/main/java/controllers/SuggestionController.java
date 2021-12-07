package controllers;

import suggestion.Suggester;
import suggestion.SuggesterList;

public class SuggestionController {
    // deal with suggestion features

    private final Suggester suggester;

    public SuggestionController(Suggester suggester) {
        this.suggester = suggester;
    }

    public Suggester getSuggester() {
        return suggester;
    }

    public SuggesterList getSuggestionByDueDate(){
        return suggester.sortByDueDate();
    }
}
