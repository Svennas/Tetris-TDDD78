package se.liu.ida.gussv907.tddd78.from_2017.lab3;

import java.awt.*;

/**
 * Created by svennas on 2/2/17.
 */
public class Rectangle extends AbstractShape {

    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", width=" + width +
                ", height=" + height +
                ", color=" + getColor() +
                '}';
    }

}
