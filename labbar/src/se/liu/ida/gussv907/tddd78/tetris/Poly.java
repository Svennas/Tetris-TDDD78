package se.liu.ida.gussv907.tddd78.tetris;

public class Poly
{
    private SquareType[][] polySquares;
    private int width, height;

    public Poly(final SquareType[][] polySquares) {
	this.polySquares = polySquares;
	this.width = polySquares[0].length;
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

