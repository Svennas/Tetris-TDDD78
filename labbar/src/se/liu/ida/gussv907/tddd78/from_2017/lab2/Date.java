package se.liu.ida.gussv907.tddd78.from_2017.lab2;

/**
 * Created by svennas on 1/28/17.
 */
public class Date {

    private int year;
    private Month month;
    private int day;

    public Date(int year, Month month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return day + "-" + month.getNumber() + "-" + year;
    }
}



