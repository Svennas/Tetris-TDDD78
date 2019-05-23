package se.liu.ida.gussv907.tddd78.tetris;

/**
 * Tests the Board (from early in the project).
 */
public final class BoardTest
{
    private BoardTest() {}

    public static void main (String[] args) {

	Board board = new Board();
	//board.setPolyIsFalling(true);
	//board.setPolyType(3);

	BoardToTextConverter text = new BoardToTextConverter();

        System.out.println(text.convertToText(board));

        /*for (int i = 0; i < 8; i++) {
	    BoardToTextConverter rndText = new BoardToTextConverter();
	    board.randomBoard();
	    System.out.println(rndText.convertToText(board));
	}*/
    }
}
