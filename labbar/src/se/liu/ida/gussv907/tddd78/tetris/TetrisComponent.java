package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;
import java.awt.Color;

public class TetrisComponent extends JComponent
{
    private Board board;
    private final static int SQUARE_SIZE = 10; //Size in pixels
    EnumMap<SquareType, Color> colorMap;

    public TetrisComponent(final Board board) {
	this.board = board;
	this.colorMap = new EnumMap<>(SquareType.class);
	makeSquareTypeColors();
    }

    public Dimension getPreferredSize() {
        int width = SQUARE_SIZE * board.getWidth();
        int height = SQUARE_SIZE * board.getHeight();
        return new Dimension(width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(getSquareTypeColor(SquareType.S));
        g2d.drawRect(10, 10, 10, 10);
    }

    public void makeSquareTypeColors () {
        colorMap.put(SquareType.EMPTY, Color.BLACK);
        colorMap.put(SquareType.I, Color.BLUE);
        colorMap.put(SquareType.O, Color.RED);
        colorMap.put(SquareType.T, Color.GREEN);
        colorMap.put(SquareType.S, Color.YELLOW);
        colorMap.put(SquareType.Z, Color.MAGENTA);
        colorMap.put(SquareType.J, Color.ORANGE);
        colorMap.put(SquareType.L, Color.WHITE);
    }

    public Color getSquareTypeColor(SquareType square) {
        return colorMap.get(square);
    }

    //public void makeSquare()
}
