package dateAndTime.dateAndTimeUseCase;

import dateAndTime.dateAndTimeAttributes.*;

import java.time.LocalDate;
import java.time.LocalTime;

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

}
