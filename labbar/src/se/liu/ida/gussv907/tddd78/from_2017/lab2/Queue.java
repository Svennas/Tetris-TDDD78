package se.liu.ida.gussv907.tddd78.from_2017.lab2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by svennas on 1/29/17.
 */
public class Queue {

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

    public void enqueue(Person person) {
        elements.add(person);
    }

    public Person dequeue() {
        return elements.remove(0);
    }

    public static void main(String[] args) {
        Queue people = new Queue();
        Person gustav = new Person("Gustav", LocalDate.of(1996, 9, 8));
        people.enqueue(gustav);
        Person albert = new Person("Albert", LocalDate.of(1872, 6, 16));
        people.enqueue(albert);
        Person erik = new Person("Erik", LocalDate.of(1990, 1, 1));
        people.enqueue(erik);
        Person charlie = new Person("Charlie", LocalDate.of(1953, 3, 27));
        people.enqueue(charlie);
        Person anders = new Person("Anders", LocalDate.of(2000, 12, 24));
        people.enqueue(anders);

        while(!people.isEmpty()) {
            System.out.println(people.dequeue().toString());
        }
    }

}
