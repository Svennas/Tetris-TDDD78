package se.liu.ida.gussv907.tddd78.from_2017.lab3;

import javax.swing.*;
import java.awt.*;

/**
 * Created by svennas on 2/2/17.
 */
public class DiagramViewer {
    public static void main(String[] args) {

        DiagramComponent comp = new DiagramComponent();

        Circle circRed = new Circle(452, 400, 70, Color.red);

        Rectangle rectGreen = new Rectangle(20, 300, 40, 60, Color.orange);

        Text textGray = new Text(10, 50, 30, Color.blue, "Detta är mina former");

        // Add several shapes to the component
        comp.addShape(circRed);
        comp.addShape(rectGreen);
        comp.addShape(textGray);

        JFrame frame = new JFrame("Mitt fönster");
        frame.setLayout(new BorderLayout());
        frame.add(comp, BorderLayout.CENTER);
        frame.setSize(800,600);
        frame.setVisible(true);


    }
}
