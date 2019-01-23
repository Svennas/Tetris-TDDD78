package se.liu.ida.gussv907.tddd78.from_2017.lab2;

/**
 * Created by svennas on 1/28/17.
 */
public class TimePoint {

    private String time;
    private int hour;
    private int minute;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public TimePoint(String time) {
        this.time = time;
        String[] parts = time.split(":");
        hour = Integer.parseInt(parts[0]);
        minute = Integer.parseInt(parts[1]);
    }

    @Override
    public String toString() {
        return time;
    }
}
