package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;

public class TetrisViewerTest
{

    private static int ONE_SECOND = 1000;

    private static Timer clockTimer;

    public static void main(String[] args) {

	Board board = new Board(5, 5);



	TetrisComponent comp = new TetrisComponent(board);

	TetrisViewer test = new TetrisViewer(board, comp);

	Game game = new Game(board, comp, test);

	clockTimer = new Timer(ONE_SECOND, game.oneGameStep);

	clockTimer.setCoalesce(true);

	clockTimer.start();

	//clockTimer.stop();

    }
}
