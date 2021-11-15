package printers;

import abstractClasses.Printer;
import taskEntities.Timeline;

public class TimelinePrinter extends Printer {
    public static void print(Timeline timeline) {
        // Call toString in the timeline
        System.out.println(timeline.toString());
    }
}
