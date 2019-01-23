package se.liu.ida.gussv907.tddd78.from_2017.lab2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by svennas on 1/29/17.
 */
public class Stack {

    private List<Person> elements = new ArrayList<Person>();

    public int size() {
        return elements.size();
    }

    public Boolean isEmpty() {
        return elements.isEmpty();
    }

    public void clear() {
        elements.clear();
    }

    public Boolean contains(Object o) {
        return elements.contains(o);
    }

    public void push(Person person) {
        elements.add(person);
    }

    public Person pop() {
        return elements.remove(size()-1);
    }

    public static void main(String[] args) {
        Stack people = new Stack();
        Person gustav = new Person("Gustav", LocalDate.of(1996, 9, 8));
        people.push(gustav);
        Person albert = new Person("Albert", LocalDate.of(1872, 6, 16));
        people.push(albert);
        Person erik = new Person("Erik", LocalDate.of(1990, 1, 1));
        people.push(erik);
        Person charlie = new Person("Charlie", LocalDate.of(1953, 3, 27));
        people.push(charlie);
        Person anders = new Person("Anders", LocalDate.of(2000, 12, 24));
        people.push(anders);

        while(!people.isEmpty()) {
            System.out.println(people.pop().toString());
        }
    }
}
