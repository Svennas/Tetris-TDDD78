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
	    board.tick();
	    viewer.boardUpdater(component);
	}
    };

    public Action getOneGameStep() {
	return oneGameStep;
    }
}