package se.liu.ida.gussv907.tddd78.tetris;
import javax.swing.*;
import java.awt.*;

public class TetrisViewer_v1
{

    public TetrisViewer_v1(Board board) {
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
        Board board = new Board(5, 5);
        TetrisViewer_v1 test = new TetrisViewer_v1(board);
    }
}
