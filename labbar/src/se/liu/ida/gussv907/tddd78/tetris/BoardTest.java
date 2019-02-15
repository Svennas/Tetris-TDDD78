package se.liu.ida.gussv907.tddd78.tetris;

public class BoardTest
{

    public static void main (String[] args) {

	Board board = new Board(8, 8);

	BoardToTextConverter text = new BoardToTextConverter();

        System.out.println(text.convertToText(board));

        for (int i = 0; i < 10; i++) {
	    BoardToTextConverter rndText = new BoardToTextConverter();
	    board.randomBoard();
	    System.out.println(rndText.convertToText(board));
	}
    }
}
