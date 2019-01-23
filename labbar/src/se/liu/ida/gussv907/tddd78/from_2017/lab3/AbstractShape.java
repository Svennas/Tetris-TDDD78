package se.liu.ida.gussv907.tddd78.from_2017.lab3;

import java.awt.*;

/**
 * Created by svennas on 2/2/17.
 */
public abstract class AbstractShape implements Shape{

    protected int x;
    protected int y;
    protected Color color;

    public AbstractShape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractShape that = (AbstractShape) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        return color.equals(that.color);
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + color.hashCode();
        return result;
    }
}
