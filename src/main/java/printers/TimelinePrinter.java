package printers;

import timeline.Timeline;

public class TimelinePrinter extends Printer {
    public static void print(Timeline timeline) {
        // Call toString in the timeline
        System.out.println(timeline.toString());
    }
}
