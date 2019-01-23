package se.liu.ida.gussv907.tddd78.from_2017.lab3;

import javax.swing.*;
import java.awt.Shape;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by svennas on 2/2/17.
 */
public class DiagramComponent extends JComponent {
    @Override protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        for(Shape shape : shapes) {
            shape.draw(g);
        }
    }

    private List<Shape> shapes;

    public DiagramComponent() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape s) {
        shapes.add(s);
    }
}
