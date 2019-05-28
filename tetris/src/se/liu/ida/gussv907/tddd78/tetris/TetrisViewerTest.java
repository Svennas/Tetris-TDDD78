package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;

/**
 * Viewer test class from early in the project. It is not used anymore.
 */
public final class TetrisViewerTest
{

    private TetrisViewerTest() {}

    public static void main(String[] args) {

	Board board = new Board();

	board.setPolyIsFalling(false);

	//board.setPolyType(0);



	TetrisComponent comp = new TetrisComponent(board);

	TetrisViewer test = new TetrisViewer(comp, board);

	Game game = new Game(board, test);

	//Game keypress = new Game();

	board.addBoardListener(comp);

	final int gameSpeed = 200;

	final Timer clockTimer = new Timer(gameSpeed, game.getOneGameStep());

	clockTimer.setCoalesce(true);

	clockTimer.start();

	//clockTimer.stop();

    }
}

