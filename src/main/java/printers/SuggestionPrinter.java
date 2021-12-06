package printers;

import suggestion.SuggesterList;

public class SuggestionPrinter extends Printer {
    public static void print(SuggesterList suggesterList) {
        System.out.println(suggesterList);
    }
}
