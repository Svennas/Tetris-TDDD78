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
    private TetrisViewer viewer;

    private final static int GAME_SPEED = 400;


    public Game(Board board, TetrisViewer viewer)
    {
	this.board = board;
	this.viewer = viewer;
    }


    /** This Action handles one step in the game. What happens at every step of the game
     * is defined in the class Board, function tick(). If the game is over, the
     * game over window will be showed. */
    private final Action oneGameStep = new AbstractAction()
    {
	public void actionPerformed(ActionEvent event) {
	    if (board.isGameOver()) {
		viewer.gameOverWindow();
	    }
	    if (!board.isPaused()) {
		board.tick();
	    }
	}
       };


    public Action getOneGameStep() {
	return oneGameStep;
    }

    /** This main function starts the game. It creates all the objects that needs to be created
     * and also creates a Timer that makes the game move forward. */
    public static void main(String[] args) {

	Board gameBoard = new Board();
	TetrisComponent tetrisComponent = new TetrisComponent(gameBoard);
	TetrisViewer tetrisViewer = new TetrisViewer(tetrisComponent, gameBoard);
	Game tetrisGame = new Game(gameBoard, tetrisViewer);

	gameBoard.addBoardListener(tetrisComponent);


	final Timer clockTimer = new Timer(GAME_SPEED, tetrisGame.oneGameStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();

    }
}


