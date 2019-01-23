package se.liu.ida.gussv907.tddd78.from_2017.lab2;

import java.util.Random;

/**
 * Created by svennas on 1/23/17.
 */
public class Slump {
    public static void main(String[] args) {
        Random rnd = new Random();
        for (int i = 1; i <= 25; i++) {
            System.out.println("Rad " + i + ": " + rnd.nextInt(100));
        }
    }
}
