package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This class starts the tetris game. Every function that needs to happen needs to be called
 * from this class.
 */
public class Game extends JComponent
{
    private Board board;
    private TetrisComponent component;
    private TetrisViewer viewer;

    private final static int ONE_SECOND = 200;


    public Game(Board board, TetrisComponent component, TetrisViewer viewer)
    {
	this.board = board;
	this.component = component;
	this.viewer = viewer;
    }


    /** This Action handles one step in the game. What happens at every step of the game
     * is defined in the class Board, function tick(). If the game is over, the
     * game over window will be showed. */
    private final Action oneGameStep = new AbstractAction()
    {
	public void actionPerformed(ActionEvent event) {
	    if (board.gameOver) {
		viewer.gameOverWindow();
	    }
	    else {
		board.tick();
	    }
	}
    };

    /** This main function starts the game. It creates all the objects that needs to be created
     * and also creates a Timer that makes the game move forward. */
    public static void main(String[] args) {

	Board gameBoard = new Board();
	TetrisComponent tetrisComponent = new TetrisComponent(gameBoard);
	TetrisViewer tetrisViewer = new TetrisViewer(tetrisComponent);
	Game tetrisGame = new Game(gameBoard, tetrisComponent, tetrisViewer);

	gameBoard.addBoardListener(tetrisComponent);


	final Timer clockTimer = new Timer(ONE_SECOND, tetrisGame.oneGameStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();

    }
}


