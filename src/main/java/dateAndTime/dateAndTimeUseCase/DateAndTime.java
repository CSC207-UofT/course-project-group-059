package dateAndTime.dateAndTimeUseCase;

import dateAndTime.dateAndTimeAttributes.*;
import task.taskEntities.Task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.HOURS;

public class DateAndTime {


//Deal with LocalDate and time with actual date and time

    //return if the actual Date is in the range of localDate
    public static boolean isToday(Date date){
        LocalDate today = LocalDate.now();
        if(date.isOneday()){
            return date.getDate().isEqual(today);
        }
        else return date.getStartDate().isEqual(today) || date.getStartDate().isBefore(today)||
                date.getEndDate().isEqual(today) ||date.getEndDate().isAfter(today);
    }

    //return if the actual time is in the range of localTime
    public static boolean isNow(Time time){
        LocalTime now = LocalTime.now();
        if(time.isOneTime()){
            return time.getTime().equals(now);
        }
        else return time.getStartTime().equals(now) || time.getStartTime().isBefore(now)||
                time.getEndTime().equals(now)|| time.getEndTime().isAfter(now);
    }

// will implement more base on the need....
    public static List<LocalDate> datesInRange(Date date){
        List<LocalDate> dates = date.getStartDate().datesUntil(date.getEndDate()).collect(Collectors.toList());
        dates.add(date.getEndDate());
        return dates;
    }

    // return the time difference between start and end in hours.
    public static List<LocalTime> hoursInRange(Time time){
        List<LocalTime> hours = new ArrayList<>();


        //Deal with cases like 12:00 - 12:30
        if(time.getStartTime().getHour() == time.getEndTime().getHour()
        && !time.isOneTime()){

            String formatted = String.format("%02d", time.getStartTime().getHour());
            String hour = formatted + ":00";

            hours.add(LocalTime.parse(hour));

            return hours;
        }

        // return localTime between start and end in hour, not include end
        for (int i = time.getStartTime().getHour(); i < time.getEndTime().getHour(); i++) {
            String formatted = String.format("%02d", i);
            String hour = formatted + ":00";
            hours.add(LocalTime.parse(hour));
        }

        //Deal with cases like task with end time 14:30, and put the task into block 14:00
        if(time.getEndTime().getMinute() >= 1){
            String formatted = String.format("%02d", time.getEndTime().getHour());
            String hour = formatted + ":00";

            hours.add(LocalTime.parse(hour));
        }

        return hours;
    }


}
