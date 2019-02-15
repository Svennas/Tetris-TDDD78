package se.liu.ida.gussv907.tddd78.tetris;
import javax.swing.*;
import java.awt.*;

public class TetrisViewer
{
    private JFrame frame;
    BoardToTextConverter text = new BoardToTextConverter();

    //System.out.println(text.convertToText(board));
    //private JTextPane text = new JTextPane();
    //private JTextArea area = new JTextArea(4, 5);
    //private JLabel status = new JLabel("Hallå");

    public TetrisViewer(Board board) {
	frame = new JFrame("TetrisViewer");

	JTextArea textarea = new JTextArea(board.getWidth(), board.getHeight());
	textarea.setText(text.convertToText(board));

    	//frame.setSize(600, 400);
    	frame.setLayout(new BorderLayout());
    	frame.add(textarea, BorderLayout.CENTER);
    	frame.setVisible(true);
    }

    public static void main(String[] args) {
        Board board = new Board(5, 5);
        TetrisViewer test = new TetrisViewer(board);
    }
}
