package se.liu.ida.gussv907.tddd78.from_2017.lab1;

import javax.swing.*;

/**
 * Created by svennas on 1/23/17.
 */
public class Exercise9 {
    public static void main(String[] args) {
        String input =
                JOptionPane.showInputDialog("Please input a value");
        double newInput = Double.parseDouble(input);
        System.out.println("Roten ur " + newInput + " är " + findRoot(newInput));
    }

    public static double findRoot(double number) {
        double x = number;
        for (int i = 1; i <= 10; i++) {
            x = x - (x * x - number) / (2 * x);
        }
        return x;
    }
}
