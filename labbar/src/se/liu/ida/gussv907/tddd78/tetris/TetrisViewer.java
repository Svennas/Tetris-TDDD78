package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class TetrisViewer
{
    private JFrame frame;


    public TetrisViewer(TetrisComponent component) {
	this.frame = new JFrame("TetrisViewer");

	boardUpdater(component);
    }

    public void boardUpdater(TetrisComponent component) {
        frame.setLayout(new BorderLayout());
        frame.add(component, BorderLayout.CENTER);
        frame.setSize(component.getPreferredSize());
        frame.setVisible(true);
    }

    public void gameOverWindow() {
	JOptionPane.showMessageDialog(frame,
	    "You lost the game!", "GAMEOVER!", JOptionPane.ERROR_MESSAGE);
    }
}
