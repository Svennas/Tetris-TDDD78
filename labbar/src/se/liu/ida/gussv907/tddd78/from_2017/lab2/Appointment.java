package se.liu.ida.gussv907.tddd78.from_2017.lab2;

/**
 * Created by svennas on 1/28/17.
 */
public class Appointment {

    private String subject;
    private Date date;
    private TimeSpan timeSpan;

    public String getSubject() {
        return subject;
    }

    public Date getDate() {
        return date;
    }

    public TimeSpan getTimeSpan() {
        return timeSpan;
    }

    public Appointment(String subject, Date date, TimeSpan timeSpan) {
        this.subject = subject;
        this.date = date;
        this.timeSpan = timeSpan;
    }

    @Override
    public String toString() {
        return subject + " at " + timeSpan.toString() +
                ", " + date.toString();
    }
}
