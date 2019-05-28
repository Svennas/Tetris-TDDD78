package se.liu.ida.gussv907.tddd78.tetris;

/**
 * This class defines a poly. A poly is what falls through the board and is made up
 * by multiple SquareTypes to make a tetris block.
 */
public class Poly
{
    private SquareType[][] polySquares;
    private int size;

    public Poly(final SquareType[][] polySquares) {
	this.polySquares = polySquares;
	this.size = polySquares.length;
    }

    public SquareType[][] getPolySquares() {
	return polySquares;
    }

    public int getSize() {
	return size;
    }
}

