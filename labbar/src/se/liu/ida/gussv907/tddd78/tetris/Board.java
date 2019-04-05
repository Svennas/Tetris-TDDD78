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

    private boolean polyIsFalling;
    private int polyX, polyY = 0; //Starting position of Poly (left-upper corner)
    private int polyType; //Decides the Poly type
    private Poly falling = null;

    private ArrayList<BoardListener> listeners = new ArrayList<BoardListener>();


    public void addBoardListener(BoardListener bl) {
          listeners.add(bl);
    }

    private void notifyListeners() {
         for (BoardListener listElement : listeners) {
             listElement.boardChanged();
 	}
     }

    public void tick() {
        if (polyIsFalling) {
            polyY++;
    	}
        else {
               //add new Poly on Board
    	}
    }

    public void fallingPoly() {
	TetrominoMaker poly = new TetrominoMaker();
        if (polyIsFalling) {
            this.falling = poly.getPoly(polyType);
	}
    }

    public SquareType getSquareAt(int x, int y) {
	/* Takes a position and determines if the square at that position is
	 * falling or is still. If it is falling it should return at
	 * SquareType from Poly falling. Otherwise it should return a
	 * SquareType from Board.
	 */

	fallingPoly(); //Initiates a falling Poly

	if (falling == null) {
	    return squares[x][y];
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
		    return squares[x][y];
		}
	    }
	    //There is no Poly at the position
	    else {
		//System.out.println("board");
		return squares[x][y];
	    }
	}
    }

    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;
	this.polyX = (height / 2) - 1;
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
	notifyListeners();
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public int getPolyX() {
	return polyX;
    }

    public int getPolyY() {
	return polyY;
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
