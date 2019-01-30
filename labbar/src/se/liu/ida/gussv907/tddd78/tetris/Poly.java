package se.liu.ida.gussv907.tddd78.tetris;

public class Poly
{
    private SquareType[][] polySquares;
    private int width, height;
    //private int falling;

    public Poly(final SquareType[][] polySquares) {
	this.polySquares = polySquares;
	width = polySquares[0].length;
	height = polySquares.length;
    }

    //Added getters just in case, dont know if they will be of use...

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

