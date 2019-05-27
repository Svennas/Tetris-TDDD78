package se.liu.ida.gussv907.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class handles the window in which the game is showed.
 * This class creates everything that is not blocks (buttons etc.).
 */
public class TetrisViewer
{
    private JFrame frame;
    private Board board;

    /** Size of the text on many menu's. */
    private static final int MENU_FONT_SIZE = 12;

    /** Font used for the text on many menu's. */
    private Font menuFont= new Font("Arial", Font.PLAIN, MENU_FONT_SIZE);

    public TetrisViewer(TetrisComponent component, Board board) {
	this.frame = new JFrame("TetrisViewer");
	this.board = board;

	gameWindow(component);
    }

    /** Creates the main window for the game. The window is always placed in the middle of
     * the screen. */
    public void gameWindow(TetrisComponent component) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        int windowPlacementX = (screenSize.width / 2) - (component.getWindowWidth() / 2);
        int windowPlacementY = (screenSize.height / 2) - (component.getWindowHeight() / 2);

        frame.setLayout(new BorderLayout());
        frame.add(component, BorderLayout.CENTER);
        frame.setSize(component.getPreferredSize());
        frame.setLocation(windowPlacementX, windowPlacementY);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	frame.setJMenuBar(createGameMenuBar());

        frame.pack();
        frame.setVisible(true);
    }

    /** Creates the menu bar at the top of the main window.
     * Currently have the functions:
     *  - Restart
     *  - Exit
     *  - Help (Shows info about the game)
     *  */
    public JMenuBar createGameMenuBar() {

	final JMenuBar menuBar = new JMenuBar();

	final JMenu game = new JMenu("Game");
	game.setFont(menuFont);
	JMenuItem restart = createMenuBarItem(game, "Restart", 'R');
	JMenuItem exit = createMenuBarItem(game, "Exit", 'E');
	menuBar.add(game);

	final JMenu help = new JMenu("Help");
	help.setFont(menuFont);
	JMenuItem about = createMenuBarItem(help, "About Tetris", 'H');
	menuBar.add(Box.createHorizontalGlue());
	menuBar.add(help);

	exit.addActionListener(new ActionListener()
	{
	    @Override public void actionPerformed(final ActionEvent e) {
		exitGame();
	    }
	});

	restart.addActionListener(new ActionListener()
	{
	    @Override public void actionPerformed(final ActionEvent e) {
		board.restartGame();
	    }
	});

	about.addActionListener(new ActionListener()
	{
	    @Override public void actionPerformed(final ActionEvent e) {

	        board.paused = true;

		Object[] options = {
		    "OK"
		};

		JTextArea message = new JTextArea(
		"This is a simple version of the classic game Tetris"
		+ "\n" + "\n" + "\n" +
		"Controls:"
		+ "\n" + "\n" +
		"Left arrow - Moves the poly block to the left."
		+ "\n" +
		"Right arrow - Moves the poly block to the right"
		+ "\n" +
		"Down arrow - Rotates the poly block to the left"
		+ "\n" +
		"Up arrow - Rotates the poly block to the right"
		);
		message.setFont(menuFont);
		message.setBackground(Color.lightGray);

		int number = JOptionPane.showOptionDialog(
			frame, message, "About Tetris", JOptionPane.DEFAULT_OPTION,
			JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		if (number == 0) {
		    board.paused = false;
		}
	    }
	});

	return menuBar;
    }

    /** Help function that creates menu bar items for the menu bar. */
    public JMenuItem createMenuBarItem(JMenu menu, String itemName, char mnemonic) {

        JMenuItem newMenuItem = new JMenuItem(itemName, mnemonic);
        newMenuItem.setFont(menuFont);

        menu.add(newMenuItem);

        return newMenuItem;
    }

    /** Creates the window that is showed when the game is over.
     * Gives the options to exit the game or restart. */
    public void gameOverWindow() {

        JLabel message = new JLabel("YOU LOST THE GAME!");
        message.setFont(menuFont);

        Object[] options = {
	    "Exit",
	    "Restart"
       	};

       	int gameOverOption = JOptionPane.showOptionDialog(
	    frame, message, "GAME OVER",
	    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
	    null, options, options[1]);

       	if (gameOverOption == 0) exitGame();
       	else board.restartGame();
    }

    /** This function is used everytime the user wants to exit the game.
     * Gives a yes and no option. Shuts down the game if yes. */
    public void exitGame() {

        JLabel message = new JLabel("Are you sure you want to exit the game?");
        message.setFont(new Font("Arial", Font.PLAIN, MENU_FONT_SIZE));

        Object[] options = {
	    "Yes",
	    "No"
        };

        int optionChosen = JOptionPane.showOptionDialog(
	     frame, message, "Game Exit",
	     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
	null, options, options[1]);

        if (optionChosen == 0) {
            System.exit(0);
	}
    }
}
