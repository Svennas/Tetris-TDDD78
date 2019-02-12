package se.liu.ida.gussv907.tddd78.tetris;
import javax.swing.*;
import java.awt.*;

public class TetrisViewer
{
    public static GraphicsConfiguration gc;
    private final static String newline = "\n";
    private final static String text = "Hejsan Svejsan";

    public TetrisViewer(Board viewer) {
    	JFrame frame = new JFrame(gc);
    	frame.setTitle("Testing JFrame");
    	frame.setSize(600, 400);
    	frame.setVisible(true);
	JTextArea area = new JTextArea(5, 5);
	area.append(text + newline);
	area.setEditable(false);
    }

    public static void main(String[] args) {
        Board board = new Board(5, 5);
        TetrisViewer test = new TetrisViewer(board);
    }
}
