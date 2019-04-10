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


    public void addBoardListener(BoardListener bl) {
          listeners.add(bl);
    }

    private void notifyListeners() {
         for (BoardListener listElement : listeners) {
             listElement.boardChanged();
 	}
     }

    public void movePolyRight() {
        polyX += 1;
        notifyListeners();
    }

    public void movePolyLeft() {
	polyX -= 1;
	//System.out.println("Lefti");
	notifyListeners();
    }

    public void tick() {
        if (polyIsFalling) {
	    //System.out.println("Hejsan");
            polyY += 1;
            notifyListeners();
    	}
        else {
            polyX = width / 2;
            polyY = 0;
	    TetrominoMaker poly = new TetrominoMaker();
            polyType = rnd.nextInt(poly.getNumberOfTypes());
	    this.falling = poly.getPoly(polyType);
	    setPolyIsFalling(true);
    	}
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
	        if (row <= 1 || row >= realWidth - 2  ||
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
	System.out.println(realWidth);
    	return realWidth;
        }

    public int getRealHeight() {
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
