package se.liu.ida.gussv907.tddd78.tetris;

/**
 * This class defines a poly. A poly is what falls through the board.
 */
public class Poly
{
    private SquareType[][] polySquares;
    private int width, height;

    public Poly(final SquareType[][] polySquares) {
	this.polySquares = polySquares;
	this.width = polySquares[1].length;
	this.height = polySquares.length;
    }

    public SquareType[][] getPolySquares() {
	return polySquares;
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }
}

