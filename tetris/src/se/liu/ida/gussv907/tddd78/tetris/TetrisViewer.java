package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class TetrisViewer
{
    private JFrame frame;

    private static final int MENU_FONT_SIZE = 12;

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

        final JMenuBar menuBar = new JMenuBar();

        final JMenu game = new JMenu("Game");
        game.setFont(new Font("Arial", Font.PLAIN, MENU_FONT_SIZE));
        createMenuBarItem(game, "Restart", 'R');
        JMenuItem exit = createMenuBarItem(game, "Exit", 'E');
        menuBar.add(game);

        final JMenu help = new JMenu("Help");
	help.setFont(new Font("Arial", Font.PLAIN, MENU_FONT_SIZE));
	createMenuBarItem(help, "About Tetris", 'H');
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(help);

        frame.setJMenuBar(menuBar);

        exitGame(exit);

        frame.pack();
        frame.setVisible(true);
    }

    public JMenuItem createMenuBarItem(JMenu menu, String itemName, char mnemonic) {
        JMenuItem newMenuItem = new JMenuItem(itemName, mnemonic);
        newMenuItem.setFont(new Font("Arial", Font.PLAIN, MENU_FONT_SIZE));

        menu.add(newMenuItem);

        return newMenuItem;
    }

    public void gameOverWindow() {
        JOptionPane option = new JOptionPane();
        option.setFont(new Font("Arial", Font.PLAIN, MENU_FONT_SIZE));
	option.showMessageDialog(frame,
	    "You lost the game!", "GAMEOVER!", JOptionPane.ERROR_MESSAGE);
    }

    public void exitGame(JMenuItem exit) {
        exit.addActionListener(new ActionListener()
	{
	    @Override public void actionPerformed(final ActionEvent e) {
		Object[] options = {
		    "YES",
		    "NO"
		};

	        JOptionPane.showOptionDialog(
		    frame,
		    "Do you want to exit the game",
		     "Game Exit",
		     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
		    null, options, options[1]);
	    }
	});

    }
}
