package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.EnumMap;

/**
 * This class creates graphics for all the blocks in the game.
 * It also creates actions for all the keypresses.
 */

public class TetrisComponent extends JComponent implements BoardListener
{
    private Board board;
    /** Defines the size of every pixel in the game. */
    private final static int SQUARE_PIXEL_SIZE = 30;
    private EnumMap<SquareType, Color> colorMap;

    public TetrisComponent(final Board board) {
	this.board = board;
	this.colorMap = new EnumMap<>(SquareType.class);

        createKeyPresses();
	makeSquareTypeColors();
    }

    public int getWindowWidth() {
        return SQUARE_PIXEL_SIZE * (board.getBoardWidth() + 1);
    }

    public int getWindowHeight() {
        return SQUARE_PIXEL_SIZE * (board.getBoardHeight() + 2);
    }

    public Dimension getPreferredSize() {
        int width = getWindowWidth();
        int height = getWindowHeight();
        return new Dimension(width, height);
    }

    /** The paints everything that is on the board at the moment.
     * Via the repaint function this function is called everytime something
     * is changed on the board. */
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

        for (int width = 0; width < board.getBoardWidth(); width++) {
            for (int height = 0; height < board.getBoardHeight(); height++) {

                g2d.setColor(getSquareTypeColor(board.getSquareAt(width, height)));

                g2d.fillRect(width * SQUARE_PIXEL_SIZE, height * SQUARE_PIXEL_SIZE,
                             width + SQUARE_PIXEL_SIZE, height + SQUARE_PIXEL_SIZE);
            }
        }
    }

    /** Gives each block type its own specific colour. */
    public void makeSquareTypeColors () {
        colorMap.put(SquareType.OUTSIDE, Color.BLACK);
        colorMap.put(SquareType.EMPTY, Color.LIGHT_GRAY);
        colorMap.put(SquareType.I_BLOCK, Color.CYAN);
        colorMap.put(SquareType.O_BLOCK, Color.RED);
        colorMap.put(SquareType.T_BLOCK, Color.GREEN);
        colorMap.put(SquareType.S_BLOCK, Color.YELLOW);
        colorMap.put(SquareType.Z_BLOCK, Color.MAGENTA);
        colorMap.put(SquareType.J_BLOCK, Color.ORANGE);
        colorMap.put(SquareType.L_BLOCK, Color.BLUE);
    }

    public Color getSquareTypeColor(SquareType square) {
        return colorMap.get(square);
    }

    /** Called everytime something changes on the board. */
    @Override public void boardChanged() {
        repaint();
    }


    /** Creates all the keypresses and the actions to what shoukd happen when a key
     * is pressed. */
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
