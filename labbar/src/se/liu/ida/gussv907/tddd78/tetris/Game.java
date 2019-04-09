package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

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


    /* ----------------- For one step in the game ----------------- */
    final Action oneGameStep = new AbstractAction()
    {
	public void actionPerformed(ActionEvent event) {
	    board.tick();
	    viewer.boardUpdater(board, component);
	    //board.randomBoard();
	}
    };
    /* --------------- End for one step in the game --------------- */
    public void KeyAction() {
        JComponent pane = viewer.getFrame().getRootPane();

      	final InputMap in = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
      	in.put(KeyStroke.getKeyStroke("LEFT"), "left");

      	final ActionMap act = pane.getActionMap();
	act.put("left", new MoveLeft());
    }

    private class MoveLeft extends AbstractAction {
	@Override public void actionPerformed(final ActionEvent e) {
	    board.movePolyLeft();
	}
    }


}