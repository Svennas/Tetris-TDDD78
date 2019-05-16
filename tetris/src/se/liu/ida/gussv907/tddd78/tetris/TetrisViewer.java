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
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        frame.setLayout(new BorderLayout());
        frame.add(component, BorderLayout.CENTER);
        frame.setSize(component.getPreferredSize());
        //frame.setLocation(screenWidth / 3, screenHeight / 3);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void gameOverWindow() {
	JOptionPane.showMessageDialog(frame,
	    "You lost the game!", "GAMEOVER!", JOptionPane.ERROR_MESSAGE);
    }
}
