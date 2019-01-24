package se.liu.ida.gussv907.tddd78.tetris;

public class BoardTest
{

    public static void main (String[] args) {

	Board board = new Board(5, 5);

	BoardToTextConverter text = new BoardToTextConverter();

        System.out.println(text.convertToText(board));

        for (int i = 0; i < 10; i++) {
            board.randomBoard();
	    System.out.println(text.convertToText(board));
	}
    }
}
