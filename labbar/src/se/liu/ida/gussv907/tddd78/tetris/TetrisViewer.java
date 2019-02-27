package se.liu.ida.gussv907.tddd78.tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    private final static int ONE_SECOND = 1000;
    private static Timer clockTimer;
    private static JFrame frame = new JFrame("TetrisViewer");
    //public static Board board = new Board(5, 5);

    /* --------------- For one step in the game --------------- */
    final static Action oneGameStep = new AbstractAction()
    {
	public void actionPerformed(ActionEvent event) {
	    Board board = new Board(5, 5);
	    board.randomBoard();
	    JTextArea textarea = new JTextArea(board.getWidth(), board.getHeight());
	    JFrameUpdater(board, frame);
	    //new TetrisViewer(board);
	}
    };

    /* --------------- End for one step in the game --------------- */

    public TetrisViewer(Board board) {
	//BoardToTextConverter text = new BoardToTextConverter();
	//JFrame frame = new JFrame("TetrisViewer");


	//JTextArea textarea = new JTextArea(board.getWidth(), board.getHeight());
	JFrameUpdater(board, frame);
	/*
	//textarea.setText(text.convertToText(board));

    	frame.setLayout(new BorderLayout());
    	frame.add(textarea, BorderLayout.CENTER);
    	textarea.setFont(new Font("Monospaced", Font.PLAIN, 20));
    	frame.pack();
    	frame.setVisible(true);
    	*/
    }

    public static void JFrameUpdater(Board board, JFrame frame) {
	JTextArea textarea = new JTextArea(board.getWidth(), board.getHeight());

	BoardToTextConverter text = new BoardToTextConverter();
	textarea.setText(text.convertToText(board));

	frame.setLayout(new BorderLayout());
	frame.add(textarea, BorderLayout.CENTER);
	textarea.setFont(new Font("Monospaced", Font.PLAIN, 20));
	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String[] args) {

	Board board = new Board(5, 5);

	TetrisViewer test = new TetrisViewer(board);

	clockTimer = new Timer(ONE_SECOND, oneGameStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();

        //clockTimer.stop();

        //Board board = new Board(5, 5);
        //board.randomBoard();

    }
}
