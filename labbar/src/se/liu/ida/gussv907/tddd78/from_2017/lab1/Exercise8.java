package se.liu.ida.gussv907.tddd78.from_2017.lab1;

import javax.swing.*;

/**
 * Created by svennas on 1/23/17.
 */
public class Exercise8 {
    public static void main(String[] args) {
        while(true){
            if (askUser("Quit?") && askUser("Really?")) {
                return;
            }
        }
    }

    public static boolean askUser(String question) {
        if (JOptionPane.showConfirmDialog(null, question, "",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }
}
