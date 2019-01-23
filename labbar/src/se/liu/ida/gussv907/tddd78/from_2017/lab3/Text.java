package se.liu.ida.gussv907.tddd78.from_2017.lab3;

import java.awt.*;

/**
 * Created by svennas on 2/2/17.
 */
public class Text extends AbstractShape{

    private int size;
    private String text;

    public Text(int x, int y, int size, Color color, String text) {
        super(x, y, color);
        this.size = size;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "x=" + x +
                ", y=" + y +
                ", size=" + size +
                ", color=" + color +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.setFont(new Font("serif", Font.PLAIN, size));
        g.drawString(text, x, y);
    }
}
