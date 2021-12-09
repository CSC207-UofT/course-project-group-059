package controllers;

import suggestion.Suggester;

public class SuggestionController {
    // deal with suggestion features

    private final Suggester suggester;

    public SuggestionController(Suggester suggester) {
        this.suggester = suggester;
    }

    public Suggester getSuggester() {
        return suggester;
    }

    public Suggester getSuggestionByDueDate(){
        suggester.sortByDueDate();
        return getSuggester();
    }
}
