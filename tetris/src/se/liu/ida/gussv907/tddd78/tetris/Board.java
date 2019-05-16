package se.liu.ida.gussv907.tddd78.tetris;

import java.util.*;

/**
 *
 */
public class Board
{
    private SquareType[][] squares;
    private int width;
    private int height;
    private int realWidth;
    private int realHeight;
    private Random rnd = new Random();
    private int numOfTypes = SquareType.values().length;

    private boolean polyIsFalling;
    private int polyX;
    private int polyY; //Starting position of Poly (left-upper corner)
    private int polyType; //Decides the Poly type
    private Poly falling = null;

    private List<BoardListener> listeners = new ArrayList<>();

    public boolean gameOver = false;

    private List<Integer> fullRows = new ArrayList<>();


    public final static int PLAYING_BOARD_HEIGHT = 27;
    public final static int PLAYING_BOARD_WIDTH = 20;
    public final static int STARTING_POLY_X = 10;
    public final static int STARTING_POLY_Y = 2;


    public void addBoardListener(BoardListener bl) {
          listeners.add(bl);
    }

    private void notifyListeners() {
         for (BoardListener listElement : listeners) {
             listElement.boardChanged();
 	 }
    }

    public void deleteRows() {


	for (Integer boardRow : fullRows) {
	    int row = boardRow;
	    System.out.println(boardRow);

	    while (row >= 2)
	    {
		System.out.println(row);

		for (int column = 2; column < realWidth - 1; column++)
		{
		    if(row == 2) {
		        squares[column][row] = SquareType.EMPTY;
		    }
		    else {
			squares[column][row] = squares[column][row - 1];
		    }
		}
		row--;
	    }

	}
	fullRows.clear();
    }

    public void checkFullRows() {

	int polyCounter = 0;

	for (int row = 2; row < realHeight - 1; row++) {
	    for (int column = 2; column < realWidth - 1; column++) {
		if (squares[column][row] != SquareType.EMPTY && squares[column][row] != SquareType.OUTSIDE) {
		    polyCounter++;

		    if (polyCounter == PLAYING_BOARD_WIDTH) {
			fullRows.add(row);
		    }
		    if (column == realWidth - 1) {
			polyCounter = 0;
		    }
		}
	    }
	}
    }

    public void rotate(boolean right) { //false for left, true for right

	int size = falling.getWidth();
	Poly rotated = new Poly(new SquareType[size][size]);

	for (int row = 0; row < size; row++) {
	    for (int column = 0; column < size; column++) {
		if (right) {
		    rotated.getPolySquares()[size - 1 - row][column] = this.falling.getPolySquares()[column][row];
		}
		else {
		    rotated.getPolySquares()[row][size - 1 - column] = this.falling.getPolySquares()[column][row];
		}
	    }
	}
	if (!(hasCollision(polyX, polyY, rotated))) {
	    this.falling = rotated;
	}
    }

    public void movePolyRight() {
        if (!(hasCollision(polyX + 1, polyY, falling))) {
	    polyX += 1;
	    notifyListeners();
	}
    }

    public void movePolyLeft() {
	if (!(hasCollision(polyX - 1, polyY, falling))) {
	    polyX -= 1;
	    notifyListeners();
	}
    }

    public void tick() {
        //Delete row if list is not empty

	checkFullRows();

	if (!(fullRows.isEmpty())) {
	    deleteRows();
	}



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
		//test
		setPolyType(0);
		//
		this.falling = poly.getPoly(polyType);
		setPolyIsFalling(true);
	    }
    	}
    }

    public boolean hasCollision(int newPolyX, int newPolyY, Poly poly) {
        for (int polyRow = 0; polyRow < poly.getWidth(); polyRow++){
            for (int polyColumn = 0; polyColumn < poly.getHeight(); polyColumn++) {
		if (poly.getPolySquares()[polyRow][polyColumn] != SquareType.EMPTY &&
		       squares[newPolyX + polyRow][newPolyY + polyColumn] != SquareType.EMPTY) {
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

	if (x < width) playX += 2;
	if (y < height) playY += 2;

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

    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;

	this.realWidth = width + 4;
	this.realHeight = height + 4;

	squares = new SquareType[realWidth][realHeight];

	for (int row = 0; row < realWidth; row++) {
	    for (int column = 0; column < realHeight; column++) {
	        if (row <= 1 || row >= realWidth - 1  ||
		column <= 1 || column >= realHeight - 1) {
		    squares[row][column] = SquareType.OUTSIDE;
		}
		else {
		    squares[row][column] = SquareType.EMPTY;
		}
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
	notifyListeners();
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public int getRealWidth() {
	//System.out.println(realWidth);
    	return realWidth;
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
