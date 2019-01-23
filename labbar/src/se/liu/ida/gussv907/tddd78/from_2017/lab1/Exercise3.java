package se.liu.ida.gussv907.tddd78.from_2017.lab1;

import javax.swing.*;

/**
 * Created by svennas on 1/19/17.
 */
public class Exercise3 {
    private final static int TABELL = 5;

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Please input a value");
        int tabell = Integer.parseInt(input);
        for(int i = 0; i <= 10; i++) {
            System.out.println(i + " * " + tabell + " = " + i * tabell);
        }

    }
}
