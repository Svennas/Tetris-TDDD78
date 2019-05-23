package se.liu.ida.gussv907.tddd78.tetris;

import java.util.*;

/**
 * This class contains all the functions related to tetris board.
 * It contains all the information about the board and functions related to
 * getting, setting and changing the board and the poly's that is currently
 * on the board.
 */
public class Board
{
    private SquareType[][] squares;
    private int boardWidth;
    private int realHeight;
    private Random rnd = new Random();
    private int numOfTypes = SquareType.values().length;

    private boolean polyIsFalling;
    private int polyX;
    private int polyY;
    private int polyType;
    private Poly falling = null;

    /** List of Boardlistener. This list is notified if something on the board has been
     * changed, which results in the board being repainted. */
    private List<BoardListener> listeners = new ArrayList<>();

    /** Public boolean that can tell all classes with a board field that the game is over.*/
    public boolean gameOver = false;

    /** Sets the height of the playable board.*/
    public final static int PLAYING_BOARD_HEIGHT = 20; //Sets the height of the
    /** Sets the width of the playable board. */
    public final static int PLAYING_BOARD_WIDTH = 10;
    /** Sets the starting position X for the falling.  */
    public final static int STARTING_POLY_X = PLAYING_BOARD_WIDTH / 2;
    /** Sets the starting position Y for the falling. */
    public final static int STARTING_POLY_Y = 2;

    /** Constructor for Board. Takes no arguments, width and height is decided in class
     * by static int's (see above).
     * The board is constructed in the following way:
     * [column][row] ==>
     *
     *        column[0] column[1] column[2] ... column[n]
     * row[0]

     * row[1]

     * row[2]

     * ...

     * row[n]
     *
     * */
    public Board() {
   	this.boardWidth = PLAYING_BOARD_WIDTH + 4;
   	this.realHeight = PLAYING_BOARD_HEIGHT + 4;

   	squares = new SquareType[boardWidth][realHeight];

   	for (int column = 0; column < boardWidth; column++) {
   	    for (int row = 0; row < realHeight; row++) {
   	        if (column <= 1 || column >= PLAYING_BOARD_WIDTH + 2 ||
   		row <= 1 || row >= PLAYING_BOARD_HEIGHT + 2) {
   		    squares[column][row] = SquareType.OUTSIDE;
   		} else {
   		    squares[column][row] = SquareType.EMPTY;
   		}
   	    }
   	}
    }
    /** Adds class objects that implements the interface BoardListener.*/
    public void addBoardListener(BoardListener bl) {
          listeners.add(bl);
    }

    /** Class objects (that implements BoardListener) is added in this function
     * called and runs the function boardChanged, which in the class TetrisComponent
     * repaints the entire tetris board. This function is called when something
     * on the board has changed.*/
    private void notifyListeners() {
         for (BoardListener listElement : listeners) {
             listElement.boardChanged();
 	 }
    }

    /** Takes the rows to be deleted as argument and then loops through those rows,
     * making all tetris blocks to empty blocks. After making them empty,
     * the rows above are moved down to fill the empty rows. */
    public void deleteRows(List<Integer> rowsToDelete) {

        int amountOfRows = rowsToDelete.size();

        for (Integer row : rowsToDelete) {
	    for (int column = 0; column < boardWidth; column++) {
	        if (squares[column][row] != SquareType.EMPTY &&
		    squares[column][row] != SquareType.OUTSIDE)
	        {
	            squares[column][row] = SquareType.EMPTY;
	        }
	    }
	}

	//Moves down the rows above the delete ones.
	//Does not work...
	for (int row = rowsToDelete.get(amountOfRows - 1); row >= 2 + amountOfRows; row--) {
	    for (int column = 0; column < boardWidth; column++) {
	        squares[column][row] = squares[column][row - amountOfRows];
	    }
	}
	/*
	for (int column = 0; column < boardWidth; column++) {
	    for (int row = rowsToDelete.get(amountOfRows); row >= 2; row--) {
	        squares[column][row] = squares[column][row - amountOfRows];
	    }
	}*/
    }

    /** Checks if a row on board is full with poly's. If the row is full that row
     * is deleted via function deleteRow(). */
    public void checkFullRows() {

	int polyCounter = 0; // Keeps count how many poly's there is in a row.

	List<Integer> rowsToDelete = new ArrayList<>();

	for (int column = 0; column < realHeight; column++) {
	    //System.out.println(row);
	    for (int row = 0; row < boardWidth; row++) {
		if (squares[row][column] == SquareType.EMPTY ||
		    squares[row][column] == SquareType.OUTSIDE) {
		    polyCounter = 0;
		} else {
		    polyCounter++;

		    if (polyCounter == PLAYING_BOARD_WIDTH) {
			//deleteRows(column);
			rowsToDelete.add(Integer.valueOf(column));
		    }
		}
	    }
	}
	if (!rowsToDelete.isEmpty()) {
	    deleteRows(rowsToDelete);
	}

    }

    /** Function that rotates the falling poly. If the argument right is true,
     * the falling poly is rotated to the right, ex:
     * 		o o o---
     * 		o o o  |
     * 		o o o  v
     * If the argument right is false, the falling poly is
     * rotated to the left, ex:
     * 	     ---o o o
     * 	     |  o o o
     * 	     v  o o o
     * If there is no place for the poly to rotate, the function returns the
     * poly as it is.
     */
    public void rotate(boolean right) {
        /* sizeOfPoly gets the size from the falling poly (width and height is the same in a poly) */
	int sizeOfPoly = falling.getWidth();
	Poly rotatedPoly = new Poly(new SquareType[sizeOfPoly][sizeOfPoly]);

	for (int row = 0; row < sizeOfPoly; row++) {
	    for (int column = 0; column < sizeOfPoly; column++) {
		if (right) {
		    rotatedPoly.getPolySquares()[sizeOfPoly - 1 - row][column] = this.falling.getPolySquares()[column][row];
		}
		else {
		    rotatedPoly.getPolySquares()[row][sizeOfPoly - 1 - column] = this.falling.getPolySquares()[column][row];
		}
	    }
	}
	if (!(hasCollision(polyX, polyY, rotatedPoly))) {
	    this.falling = rotatedPoly;
	}
    }

    /** Moves the falling poly one step to the right. */
    public void movePolyRight() {
        if (!(hasCollision(polyX + 1, polyY, falling))) {
	    polyX += 1;
	    notifyListeners();
	}
    }

    /** Moves the falling poly one step to the left. */
    public void movePolyLeft() {
	if (!(hasCollision(polyX - 1, polyY, falling))) {
	    polyX -= 1;
	    notifyListeners();
	}
    }

    /** This function looks at...*/
    public void tick() {
	//Checks if there are any rows that are full and deletes full rows.
	checkFullRows();

        if (polyIsFalling) {
	    if (!(hasCollision(polyX, polyY + 1, falling))) {
	        polyY += 1;
	        notifyListeners();
	    }
	    else {
		for (int polyRow = 0; polyRow < falling.getWidth(); polyRow++){
		    for (int polyColumn = 0; polyColumn < falling.getHeight(); polyColumn++) {
		        if (falling.getPolySquares()[polyRow][polyColumn] != SquareType.EMPTY)
		            squares[polyX + polyRow][polyY + polyColumn] = falling.getPolySquares()[polyRow][polyColumn];
		    }
		}
		falling = null;
		polyIsFalling = false;

	    }
    	}
        else {
            if (squares[STARTING_POLY_X + 1][STARTING_POLY_Y] != SquareType.EMPTY) {
		gameOver = true;
	    }
            else {
		polyX = STARTING_POLY_X;
		polyY = STARTING_POLY_Y;
		TetrominoMaker poly = new TetrominoMaker();
		polyType = rnd.nextInt(poly.getNumberOfTypes());
		this.falling = poly.getPoly(polyType);
		setPolyIsFalling(true);
	    }
    	}
    }

    public boolean hasCollision(int newPolyX, int newPolyY, Poly poly) {
        if (poly == null) {
            return false;
	}
        for (int polyCol = 0; polyCol < poly.getWidth(); polyCol++){
            for (int polyRow = 0; polyRow < poly.getHeight(); polyRow++) {
		if (poly.getPolySquares()[polyCol][polyRow] != SquareType.EMPTY &&
		       squares[newPolyX + polyCol][newPolyY + polyRow] != SquareType.EMPTY) {
		    return true;
		}
	    }
	}
        return false;
    }

    public SquareType getSquareAt(int x, int y) {
	/* Takes a position and determines if the square at that position is
	 * falling or is still.
	 */
	int playX = x;
	int playY = y;

	if (x < PLAYING_BOARD_WIDTH) playX += 2;
	if (y < PLAYING_BOARD_HEIGHT) playY += 2;

	if (!polyIsFalling) {
	    return squares[playX][playY];
	}
	else {
	    int polyX2 = polyX + falling.getWidth() - 1;
	    int polyY2 = polyY + falling.getHeight() - 1;

	    //Checks if x and y are within the coordinates of the Poly
	    if (x >= polyX && x <= polyX2 && y >= polyY && y <= polyY2) {
		//Checks if the coordinate inside the Poly is empty or not
		if (falling.getPolySquares()[x - polyX][y - polyY] != SquareType.EMPTY) {
		    //System.out.println("poly");
		    //System.out.println(falling.getPolySquares()[x - polyX][y - polyY]);

		    return falling.getPolySquares()[x - polyX][y - polyY];

		}
		//Else if there is no square at that position
		else {
		    //System.out.println("board in poly");
		    //return squares[playX][playY];
		    return squares[x][y];
		}
	    }
	    //There is no Poly at the position
	    else {
		//System.out.println("board");
		//return squares[playX][playY];
		return squares[x][y];
	    }
	}
    }

    public void randomBoard() {
	squares = new SquareType[PLAYING_BOARD_WIDTH][PLAYING_BOARD_HEIGHT];
	for (int w = 0; w < PLAYING_BOARD_WIDTH; w++) {
	    for (int h = 0; h < PLAYING_BOARD_HEIGHT; h++) {
		squares[w][h] = SquareType.values()[rnd.nextInt(numOfTypes)];
	    }
	}
	notifyListeners();
    }

    public int getWidth() {
	return PLAYING_BOARD_WIDTH;
    }

    public int getHeight() {
	return PLAYING_BOARD_HEIGHT;
    }

    public int getBoardWidth() {
	//System.out.println(boardWidth);
    	return boardWidth;
        }

    public int getRealHeight() {
	//System.out.println(realHeight);
        return realHeight;
    }

    public void setPolyType(final int polyType) {
	this.polyType = polyType;
	notifyListeners();
    }

    public void setPolyIsFalling(final boolean polyIsFalling) {
   	this.polyIsFalling = polyIsFalling;
   	notifyListeners();
    }


    public static void main(String[] args) {
      	Board board = new Board();
      	System.out.println(board.squares[3][3]);
      	System.out.println(board.getSquareAt(1, 1));

	TetrominoMaker testpoly = new TetrominoMaker();
	Poly falling = (testpoly.getPoly(0));
	System.out.println("hej");
	System.out.println(falling.getPolySquares()[1][1]);
	System.out.println("hej");
    }
}
