package se.liu.ida.gussv907.tddd78.from_2017.lab3;

import java.awt.*;

/**
 * Created by svennas on 1/31/17.
 */
public class Circle extends AbstractShape{

    private int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        if (radius < 0) {
            throw new IllegalArgumentException("Negativ radie");
        }
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, radius, radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", radius=" + radius +
                ", color=" + getColor() +
                '}';
    }
}
