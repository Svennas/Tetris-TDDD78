package se.liu.ida.gussv907.tddd78.from_2017.lab2;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by svennas on 1/26/17.
 */
public class Person {

    private String name;
    private LocalDate birthDay;

    public int getAge () {
        int years = Period.between(birthDay, LocalDate.now()).getYears();
        return years;
    }

    @Override
    public String toString() {
        return "Person with " +
                "name " + name +
                ", birthday " + birthDay +
                ", and age " + getAge();
    }

    public Person(String name, LocalDate birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public static void main(String[] args) {
        Person gustav = new Person("Gustav", LocalDate.of(1996, 9, 8));
        Person albert = new Person("Albert", LocalDate.of(1872, 6, 16));
        Person erik = new Person("Erik", LocalDate.of(1990, 1, 1));
        Person charlie = new Person("Charlie", LocalDate.of(1953, 3, 27));

        System.out.println(gustav.name);
        System.out.println(gustav.birthDay);
        System.out.println(gustav.getAge());

        System.out.println(gustav);
        System.out.println(albert);
        System.out.println(erik);
        System.out.println(charlie);

    }
}
