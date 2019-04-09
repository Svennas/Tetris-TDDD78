package se.liu.ida.gussv907.tddd78.tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    public JFrame getFrame() {
        return frame;
    }

    private JFrame frame;


    public TetrisViewer(Board board, TetrisComponent component) {
	this.frame = new JFrame("TetrisViewer");

	boardUpdater(board, component);
    }

    public void boardUpdater(Board board, TetrisComponent component) {
        frame.setLayout(new BorderLayout());
        frame.add(component, BorderLayout.CENTER);
        frame.setSize(component.getPreferredSize());
        frame.setVisible(true);
    }
}
