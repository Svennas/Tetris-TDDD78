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
    private Board board;

    private static final int MENU_FONT_SIZE = 12;

    private Font menuFont= new Font("Arial", Font.PLAIN, MENU_FONT_SIZE);

    public TetrisViewer(TetrisComponent component, Board board) {
	this.frame = new JFrame("TetrisViewer");
	this.board = board;

	gameWindow(component);
    }

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

		JOptionPane.showMessageDialog(
			frame, message, "About Tetris", JOptionPane.INFORMATION_MESSAGE);
	    }
	});

	board.paused = false;

	return menuBar;
    }

    public JMenuItem createMenuBarItem(JMenu menu, String itemName, char mnemonic) {

        JMenuItem newMenuItem = new JMenuItem(itemName, mnemonic);
        newMenuItem.setFont(menuFont);

        menu.add(newMenuItem);

        return newMenuItem;
    }

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
