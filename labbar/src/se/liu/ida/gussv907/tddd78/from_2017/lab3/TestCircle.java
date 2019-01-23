package se.liu.ida.gussv907.tddd78.from_2017.lab3;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by svennas on 1/31/17.
 */
public class TestCircle {

    public static void main(String[] args) {
        final ArrayList<Circle> circles = new ArrayList<>();
        Circle circRed = new Circle(3, 3, 3, Color.red);
        Circle circBlue = new Circle(4, 5, 2, Color.blue);
        Circle circYellow = new Circle(1, 1, 6, Color.yellow);
        circles.add(circRed);
        circles.add(circBlue);
        circles.add(circYellow);

        for (Circle circle : circles) {
            System.out.println("x = " + circle.getX() + " y = " + circle.getY());
        }
    }
}