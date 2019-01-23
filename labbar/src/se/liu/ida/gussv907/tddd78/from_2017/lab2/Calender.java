package se.liu.ida.gussv907.tddd78.from_2017.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by svennas on 1/28/17.
 */
public class Calender {

    private List<Appointment> appointments;

    public Calender() {
        appointments = new ArrayList<>();
    }

    public void show() {
        for (Appointment appointment : appointments) {
            System.out.println(appointment.toString());
        }
    }

    public void book(int year, String month, int day, String start,
                     String end, String subject) {
        if (year > 2013) {
            int startHour = new TimePoint(start).getHour();
            int startMinute = new TimePoint(start).getMinute();
            int endHour = new TimePoint(end).getHour();
            int endMinute = new TimePoint(end).getMinute();

            if (startHour >= 0 && startHour <= 23 &&
                    startMinute >= 0 && startMinute <= 59 &&
                    endHour >= 0 && endHour <= 23 &&
                    endMinute >= 0 && endMinute <= 59) {

                Month newMonth = new Month(month, Month.getMonthNumber(month),
                        Month.getMonthDays(month));

                if (newMonth.getNumber() != -1 && newMonth.getDays() != -1) {
                    Date newDate = new Date(year, newMonth, day);
                    TimePoint newStart = new TimePoint(start);
                    TimePoint newEnd = new TimePoint(end);
                    TimeSpan newSpan = new TimeSpan(newStart, newEnd);
                    Appointment newAppoint = new Appointment(subject, newDate,
                            newSpan);
                    appointments.add(newAppoint);

                }

                else {
                    throw new IllegalArgumentException("Not a valid month");
                }
            }

            else {
                throw new IllegalArgumentException("Not a valid time");
            }
        }

        else {
            throw new IllegalArgumentException("Not a valid year");
        }
    }

    public static void main(String[] args) {
        Calender newCal = new Calender();
        newCal.book(2017, "April", 13, "12:00", "13:00", "Probably eating lunch");
        newCal.book(2017, "February", 18, "19:00", "22:00", "Hockeymatch");
        newCal.book(2017, "September", 8, "00:00", "23:59", "Birthday");
        newCal.book(2017, "March", 2, "12:00", "18:00", "Parents visiting");
        newCal.book(2017, "January", 29, "21:00", "23:00", "Training");

        newCal.show();

    }
}
