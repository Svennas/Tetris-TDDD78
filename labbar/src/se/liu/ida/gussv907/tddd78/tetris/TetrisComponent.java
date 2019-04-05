package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;
import java.awt.Color;

public class TetrisComponent extends JComponent implements BoardListener
{
    private Board board;
    private final static int SQUARE_PIXEL_SIZE = 100; //Size in pixels
    EnumMap<SquareType, Color> colorMap;

    public TetrisComponent(final Board board) {
	this.board = board;
	this.colorMap = new EnumMap<>(SquareType.class);
	this.repaint();
	makeSquareTypeColors();
    }

    public Dimension getPreferredSize() {
        int width = SQUARE_PIXEL_SIZE * board.getWidth();
        int height = SQUARE_PIXEL_SIZE * board.getHeight();
        return new Dimension(width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        final int squareSize = 50;

        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

        //board.randomBoard();

        for (int width = 0; width < board.getWidth(); width++) {
            for (int height = 0; height < board.getHeight(); height++) {
                g2d.setColor(getSquareTypeColor(board.getSquareAt(width, height)));

                g2d.fillRect(width * squareSize, height * squareSize,
                             width + squareSize, height + squareSize);
            }
        }
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

    @Override public void boardChanged() {
        repaint();
    }
}
