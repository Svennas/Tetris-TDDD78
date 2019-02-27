package se.liu.ida.gussv907.tddd78.tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    private final static int ONE_SECOND = 1000;
    private Timer clockTimer;
    public static Board board = new Board(5, 5);

    final Action oneGameStep = new AbstractAction()
    {
	public void actionPerformed(ActionEvent event) {
	    board.randomBoard();
	}
    };
    clockTimer = new
    clockTimer = new Timer(ONE_SECOND, oneGameStep);
    clockTimer.setCoalesce(true);
    clockTimer.start();

    public TetrisViewer(Board board) {
	BoardToTextConverter text = new BoardToTextConverter();
	JFrame frame = new JFrame("TetrisViewer");

	JTextArea textarea = new JTextArea(board.getWidth(), board.getHeight());
	textarea.setText(text.convertToText(board));

    	frame.setLayout(new BorderLayout());
    	frame.add(textarea, BorderLayout.CENTER);
    	textarea.setFont(new Font("Monospaced", Font.PLAIN, 20));
    	frame.pack();
    	frame.setVisible(true);
    }

    public static void main(String[] args) {

	TetrisViewer test = new TetrisViewer(board);


        //clockTimer.stop();

        //Board board = new Board(5, 5);
        //board.randomBoard();

    }
}
