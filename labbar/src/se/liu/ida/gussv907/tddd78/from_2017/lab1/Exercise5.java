package se.liu.ida.gussv907.tddd78.from_2017.lab1;

/**
 * Created by svennas on 1/19/17.
 */
public class Exercise5 {
    public static void main(String[] args) {
        for (int i = 2; i <= 100 ; i++) {
            if (isPrime(i))
                System.out.println(i);
        }
    }

    public static boolean isPrime(int number) {
        for(int i = 2; i < number; i++) {
            int rest = number % i;
            if (rest == 0) {
                return false;
            }
        }
        return true;
    }
}
