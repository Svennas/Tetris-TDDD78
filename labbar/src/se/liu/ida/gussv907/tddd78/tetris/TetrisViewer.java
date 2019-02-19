package se.liu.ida.gussv907.tddd78.tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    public static Board board = new Board(5, 5);

    private static final Action action = new AbstractAction()
    {
	@Override public void actionPerformed(final ActionEvent event) {
	    board.randomBoard();
	}
    };

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

        final Timer clockTimer = new Timer(500, action);
        clockTimer.setCoalesce(true);
        clockTimer.start();
        clockTimer.stop();

        //Board board = new Board(5, 5);
        //board.randomBoard();

    }
}
