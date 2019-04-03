package se.liu.ida.gussv907.tddd78.tetris;


import java.awt.*;
import java.util.*;
import java.util.List;

public class Board
{
    private SquareType[][] squares;
    private int width, height;
    private Random rnd = new Random();
    private int numOfTypes = SquareType.values().length;

    private TetrominoMaker testpoly = new TetrominoMaker();
    private Boolean polyIsFalling;
    private int polyX = 1, polyY = 1;
    private Poly falling = (testpoly.getPoly(0));

    private List<BoardListener> listener;

    public void tick() {
        if (polyIsFalling) {
            polyX++;
            polyY++;
	}
        else {
            //add new Poly on Board
	}
    }

   /* private void notifyListeners() {
        for(BoardListener element : listener) {
            element.boardChanged();
	}
    }*/

    public void addBoardListener(BoardListener bl) {
        listener.add(bl);
    }

    public SquareType getSquareAt(int x, int y) {

        polyIsFalling = true; //For now...
	/* Takes a position and determines if the square at that position is
	 * falling or is still. If it is falling it should return at
	 * SquareType from Poly falling. Otherwise it should return a
	 * SquareType from Board.
	 */

	int polyX2 = polyX + falling.getWidth();
	int polyY2 = polyY + falling.getHeight();

	if (x >= polyX && x <= polyX2 && y >= polyY && y <= polyY2 && polyIsFalling) {
	    /*Om det är den första vill du skriva ut den första i Poly. Om x är lika
	    // med den första + 1 ska du skriva ut den andra, etc.
	    //
	    for (int i = 0; )
	    	if (x == i + polyX)

	    for (int w = 0; w < falling.getWidth(); w++) {
	        for (int h = 0; h < falling.getHeight(); h++) {
		    if (x == w + polyX && y == h + polyY) {

		    }
		}
	    }*/

	    if (falling.getPolySquares()[x - polyX][y - polyY] != SquareType.EMPTY) {
		System.out.println("poly");
		System.out.println(falling.getPolySquares()[x - polyX][y - polyY]);
		return falling.getPolySquares()[x - polyX][y - polyY];

	    }
	    else {
		System.out.println("board in poly");
		return squares[x][y];
	    }
	}
	else {
	    System.out.println("board");
	    return squares[x][y];
	}
    }

    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;
	squares = new SquareType[width][height];

	for (int w = 0; w < width; w++) {
	    for (int h = 0; h < height; h++) {
	        squares[w][h] = SquareType.EMPTY;
	    }
	}
    }

    public void randomBoard() {
	squares = new SquareType[width][height];
	for (int w = 0; w < width; w++) {
	    for (int h = 0; h < height; h++) {
		squares[w][h] = SquareType.values()[rnd.nextInt(numOfTypes)];
	    }
	}
	//notifyListeners();
    }

    public SquareType getSquareType(int posX, int posY) {
	return squares[posX][posY];
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public Poly getFalling() {
	return falling;
    }

    public int getPolyX() {
	return polyX;
    }

    public int getPolyY() {
	return polyY;
    }

    public static void main(String[] args) {
      	Board board = new Board(5, 8);
      	System.out.println(board.squares[3][3]);
      	System.out.println(board.getSquareAt(1, 1));

	TetrominoMaker testpoly = new TetrominoMaker();
	Poly falling = (testpoly.getPoly(0));
	System.out.println("hej");
	System.out.println(falling.getPolySquares()[1][1]);
	System.out.println("hej");
    }
}
