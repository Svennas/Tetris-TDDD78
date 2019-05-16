package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;

/**
 * Viewer test
 */
public final class TetrisViewerTest
{

    private TetrisViewerTest() {}

    public static void main(String[] args) {

	Board board = new Board(20, 27);

	board.setPolyIsFalling(false);

	//board.setPolyType(0);



	TetrisComponent comp = new TetrisComponent(board);

	TetrisViewer test = new TetrisViewer(comp);

	Game game = new Game(board, comp, test);

	//Game keypress = new Game();

	board.addBoardListener(comp);

	final int ONE_SECOND = 200;

	final Timer clockTimer = new Timer(ONE_SECOND, game.getOneGameStep());

	clockTimer.setCoalesce(true);

	clockTimer.start();

	//clockTimer.stop();

    }
}
