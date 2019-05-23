package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.EnumMap;

/**
 * Hello
 */

public class TetrisComponent extends JComponent implements BoardListener
{
    private Board board;
    private final static int SQUARE_PIXEL_SIZE = 30; //Size in pixels
    private EnumMap<SquareType, Color> colorMap;

    public TetrisComponent(final Board board) {
	this.board = board;
	this.colorMap = new EnumMap<>(SquareType.class);

        createKeyPresses();
	makeSquareTypeColors();
    }

    public Dimension getPreferredSize() {
        int width = SQUARE_PIXEL_SIZE * (board.getBoardWidth() + 1);
        int height = SQUARE_PIXEL_SIZE * (board.getRealHeight() + 2);
        return new Dimension(width, height);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

        for (int width = 0; width < board.getBoardWidth(); width++) {
            for (int height = 0; height < board.getRealHeight(); height++) {

                g2d.setColor(getSquareTypeColor(board.getSquareAt(width, height)));

                g2d.fillRect(width * SQUARE_PIXEL_SIZE, height * SQUARE_PIXEL_SIZE,
                             width + SQUARE_PIXEL_SIZE, height + SQUARE_PIXEL_SIZE);
            }
        }
    }

    public void makeSquareTypeColors () {
        colorMap.put(SquareType.OUTSIDE, Color.BLACK);
        colorMap.put(SquareType.EMPTY, Color.LIGHT_GRAY);
        colorMap.put(SquareType.I, Color.CYAN);
        colorMap.put(SquareType.O, Color.RED);
        colorMap.put(SquareType.T, Color.GREEN);
        colorMap.put(SquareType.S, Color.YELLOW);
        colorMap.put(SquareType.Z, Color.MAGENTA);
        colorMap.put(SquareType.J, Color.ORANGE);
        colorMap.put(SquareType.L, Color.BLUE);
    }

    public Color getSquareTypeColor(SquareType square) {
        return colorMap.get(square);
    }

    @Override public void boardChanged() {
        repaint();
    }


    public void createKeyPresses () {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"),
                                                                "left");
        this.getActionMap().put("left", moveLeft);

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"),
                                                                "right");
        this.getActionMap().put("right", moveRight);

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"),
                                                                "rotate_right");
        this.getActionMap().put("rotate_right", rotateRight);

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"),
                                                                "rotate_left");
        this.getActionMap().put("rotate_left", rotateLeft);
    }

    private final Action moveLeft = new AbstractAction() {
        @Override public void actionPerformed(final ActionEvent e) {
            board.movePolyLeft();
        }
    };

    private final Action moveRight = new AbstractAction() {
        @Override public void actionPerformed(final ActionEvent e) {
            board.movePolyRight();
        }
    };

    private final Action rotateRight = new AbstractAction() {
                    @Override public void actionPerformed(final ActionEvent e) {
                        board.rotate(true);
                    }
                };

    private final Action rotateLeft = new AbstractAction() {
                @Override public void actionPerformed(final ActionEvent e) {
                    board.rotate(false);
                }
            };
}
