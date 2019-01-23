package se.liu.ida.gussv907.tddd78.from_2017.lab2;

/**
 * Created by svennas on 1/28/17.
 */
public class TimeSpan {

    private TimePoint start;
    private TimePoint end;

    public TimePoint getStart() {
        return start;
    }

    public TimePoint getEnd() {
        return end;
    }

    public TimeSpan(TimePoint start, TimePoint end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start.toString() + " - " + end.toString();
    }
}
