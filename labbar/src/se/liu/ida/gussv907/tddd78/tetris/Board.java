package se.liu.ida.gussv907.tddd78.tetris;


import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width, height;
    private Random rnd = new Random();
    private int numOfTypes = SquareType.values().length;
    private Poly falling;
    private int polyXPos, polyYPos;


    public SquareType getSquareAt(int x, int y) {
	/* Takes a position and determines if the square at that position is
	 * falling or is still. If it is falling it should return at
	 * SquareType from Poly falling. Otherwise it should return a
	 * regular(?) SquareType.
	 */
	//Read the instructions again...


        return SquareType.EMPTY;
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

    public int getPolyXPos() {
	return polyXPos;
    }

    public int getPolyYPos() {
	return polyYPos;
    }

    public static void main(String[] args) {
      	Board board = new Board(5, 8);
      	System.out.println(board.squares[3][3]);
    }
}
