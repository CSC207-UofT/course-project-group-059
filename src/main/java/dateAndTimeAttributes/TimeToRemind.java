package dateAndTimeAttributes;

public class TimeToRemind {
    private OneDay remindDate;
    private OneTime remindTime;

    public TimeToRemind(OneDay remindDate, OneTime remindTime) {
        this.remindDate = remindDate;
        this.remindTime = remindTime;
    }

    public OneDay getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(OneDay remindDate) {
        this.remindDate = remindDate;
    }

    public OneTime getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(OneTime remindTime) {
        this.remindTime = remindTime;
    }

    @Override
    public String toString() {
        return "TimeToRemind{" +
                "remindDate=" + remindDate +
                ", remindTime=" + remindTime +
                '}';
    }
}
