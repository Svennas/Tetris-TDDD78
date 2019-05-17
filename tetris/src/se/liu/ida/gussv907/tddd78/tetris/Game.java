package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 *
 */
public class Game extends JComponent
{
    private Board board;
    private TetrisComponent component;
    private TetrisViewer viewer;

    private final static int ONE_SECOND = 400;


    public Game(Board board, TetrisComponent component, TetrisViewer viewer)
    {
	this.board = board;
	this.component = component;
	this.viewer = viewer;
    }


    //For one step in the game
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


