package se.liu.ida.gussv907.tddd78.from_2017.lab1;

import javax.swing.*;

/**
 * Created by svennas on 1/19/17.
 */
public class Exercise2 {

    public static void sumFor(int min, int max) {
        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void sumWhile(int min, int max) {
        int summ = 0;
        while (min <= max){
            summ += min;
            min += 1;
        }
        System.out.println(summ);
    }

    public static void main(String[] args) {
        int min = 10;
        int max = 22;
        String input = JOptionPane.showInputDialog("Input 'while' or 'for':");
        switch(input) {
            case ("while"):
                sumWhile(min, max);
                break;
            case ("for"):
                sumFor(min, max);
                break;
            default:
                System.out.println("Not a valid word, try again");
        }
    }
}
