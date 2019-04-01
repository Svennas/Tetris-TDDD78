package se.liu.ida.gussv907.tddd78.tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    private JFrame frame;

    public TetrisViewer(Board board) {
	this.frame  = new JFrame("TetrisViewer");
	JFrameUpdater(board, frame);
    }

    public static void JFrameUpdater(Board board, JFrame frame) {
	TetrisComponent component = new TetrisComponent(board);

	frame.setSize(component.getPreferredSize());
	frame.setLayout(new BorderLayout());
	frame.add(component, BorderLayout.CENTER);
	frame.repaint();
	frame.pack();
	frame.setVisible(true);
    }

    /* ----------------- For one step in the game ----------------- */
    final Action oneGameStep = new AbstractAction()
    {
	public void actionPerformed(ActionEvent event) {
	    Board board = new Board(5, 5);
	    board.randomBoard();

	    JFrameUpdater(board, frame);
	}
    };
    /* --------------- End for one step in the game --------------- */
}
