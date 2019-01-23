package se.liu.ida.gussv907.tddd78.from_2017.lab3;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by svennas on 1/31/17.
 */
public class TestShapes {

    public static void main(String[] args) {

        final ArrayList<Shape> shapes = new ArrayList<>();
        Circle circRed = new Circle(3, 3, 3, Color.red);
        Circle circBlue = new Circle(4, 5, 2, Color.blue);
        Circle circYellow = new Circle(1, 1, 6, Color.yellow);
        shapes.add(circRed);
        shapes.add(circBlue);
        shapes.add(circYellow);

        Rectangle rectBlack = new Rectangle(5, 6, 3, 4, Color.black);
        Rectangle rectGreen = new Rectangle(10, 12, 5, 2, Color.green);
        Rectangle rectPink = new Rectangle(20, 13, 12, 12, Color.pink);
        shapes.add(rectBlack);
        shapes.add(rectGreen);
        shapes.add(rectPink);

        Text textGray = new Text(9, 5, 12, Color.gray, "Hello world!");
        Text textGreen = new Text(1, 3, 12, Color.green, "Hello world!");
        Text textRed = new Text(17, 20, 12, Color.red, "Hello world!");
        shapes.add(textGray);
        shapes.add(textGreen);
        shapes.add(textRed);

        /*for (Shape shape : shapes) {
            shape.draw();
        }*/

        //System.out.println(rectBlack.getColor());

        Circle c1 = new Circle(1,1,1, Color.black);
        Circle c2 = new Circle(1,1,1, Color.black);
        if (c1.equals(c2)) System.out.println("true");
        else System.out.println("false");
    }
}