package se.liu.ida.gussv907.tddd78.tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * The first version of the TertisViewer class.
 */
public final class TetrisViewerVersionOne
{
    private final static int ONE_SECOND = 1000;
    private final static int FONT_SIZE = 20;
    private JFrame frame = new JFrame("TetrisViewer");
    /** Board for this class. */
    public Board board = new Board();

    /* --------------- For one step in the game --------------- */
    private final Action oneGameStep = new AbstractAction()
    {
	public void actionPerformed(ActionEvent event) {
	    board.randomBoard();
	    jFrameUpdater(board, frame);
	}
    };

    /* --------------- End for one step in the game --------------- */

    private TetrisViewerVersionOne(Board board) {
	jFrameUpdater(board, frame);

    }

    public static void jFrameUpdater(Board board, JFrame frame) {
	JTextArea textarea = new JTextArea(board.getPlayingBoardWidth(), board.getPlayingBoardHeight());

	BoardToTextConverter text = new BoardToTextConverter();
	textarea.setText(text.convertToText(board));

	frame.setLayout(new BorderLayout());
	frame.add(textarea, BorderLayout.CENTER);
	textarea.setFont(new Font("Monospaced", Font.PLAIN, FONT_SIZE));
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.randomBoard();
        TetrisViewerVersionOne test = new TetrisViewerVersionOne(board);

	Timer clockTimer = new Timer(ONE_SECOND, test.oneGameStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
    }
}
