package se.liu.ida.gussv907.tddd78.tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    private JFrame frame;
    //private TetrisComponent component;

    public TetrisViewer(Board board, TetrisComponent component) {
	this.frame = new JFrame("TetrisViewer");
	//this.component = new TetrisComponent(board);

	boardUpdater(board, component);
    }

    public void boardUpdater(Board board, TetrisComponent component) {
        board.randomBoard();
        //component.repaint();
        frame.setLayout(new BorderLayout());
        frame.add(component, BorderLayout.CENTER);
        frame.setSize(component.getPreferredSize());
        frame.setVisible(true);
    }
}
