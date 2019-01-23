package se.liu.ida.gussv907.tddd78.from_2017.lab1;

/**
 * Created by svennas on 1/23/17.
 */
public class Exercise10 {
    public static void main(String[] args) {
        int tal = 16777217;
        double decimaltal = tal;
        int tillbaka = (int)decimaltal;
        int big = 2147483647;
        long bigger = (long)big + 1;
        System.out.println("tal = " + tal + ", decimaltal = " + decimaltal +
        " och tillbaka = " + tillbaka + ". big = " + big + " och bigger = "
         + bigger);
    }
}
