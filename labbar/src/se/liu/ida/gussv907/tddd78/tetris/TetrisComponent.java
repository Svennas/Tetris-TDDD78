package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;
import java.awt.Color;

public class TetrisComponent extends JComponent
{
    private Board board;
    private final static int PIXEL = 10;
    EnumMap<SquareType, Color> colorMap;

    public TetrisComponent(final Board board) {
	this.board = board;
    }

    public Dimension getPreferredSize() {
        int width = PIXEL * board.getWidth();
        int height = PIXEL * board.getHeight();
        return new Dimension(width, height);
    }
}
