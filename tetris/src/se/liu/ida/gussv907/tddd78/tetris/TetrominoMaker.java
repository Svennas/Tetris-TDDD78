package se.liu.ida.gussv907.tddd78.tetris;

/**
 * Creates all the different tetris blocks used in the game.
 * This class is a so calle factory class.
 */
public class TetrominoMaker
{
    public int getNumberOfTypes() {
        return SquareType.values().length - 2;
    }

    public Poly getPoly(int typeNum) {

        Poly poly;

        if(typeNum < 0 || typeNum > getNumberOfTypes() - 1) {
	    throw new IllegalArgumentException("Invalid index: " + typeNum);
	}

	switch (typeNum) {
	    case 0: // Creates squares of type I_BLOCK.
		poly = polyI();
	    break;
	    case 1: // Creates squares of type O_BLOCK.
		poly = polyO();
	    break;
	    case 2: // Creates squares of type T_BLOCK.
		poly = polyT();
	    break;
	    case 3: // Creates squares of type S_BLOCK.
		poly = polyS();
	    break;
	    case 4: // Creates squares of type Z_BLOCK.
		poly = polyZ();
	    break;
	    case 5: // Creates squares of type J_BLOCK.
		poly = polyJ();
	    break;
	    case 6: // Creates squares of type L_BLOCK.
		poly = polyL();
	    break;
	    default:
		throw new IllegalStateException("Unexpected value: " + typeNum);
	}

	return poly;
    }

    private static void emptyBackground(SquareType[][] square, int size) {
        for(int width = 0; width < size; width++) {
            for(int height = 0; height < size; height++) {
		square[width][height] = SquareType.EMPTY;
	    }
	}
    }

    /** Creates the tetris block I:
     * 	E I E E
     * 	E E E E
     *	E I E E
     * 	E I E E
     * with the size 4x4.
     * */
    public static Poly polyI() {
        int size = 4;
        SquareType[][] iSquare = new SquareType[size][size];
	emptyBackground(iSquare, size);
        iSquare[1][0] = SquareType.I_BLOCK;
	iSquare[1][1] = SquareType.I_BLOCK;
	iSquare[1][2] = SquareType.I_BLOCK;
	iSquare[1][3] = SquareType.I_BLOCK;
        return new Poly(iSquare);
    }

    /** Creates the tetris block O:
     * 	O O
     * 	O O
     * with the size 2x2.
     * */
    public static Poly polyO() {
	int size = 2;
	SquareType[][] oSquare = new SquareType[size][size];
	oSquare[0][0] = SquareType.O_BLOCK;
	oSquare[0][1] = SquareType.O_BLOCK;
	oSquare[1][0] = SquareType.O_BLOCK;
	oSquare[1][1] = SquareType.O_BLOCK;
	return new Poly(oSquare);
    }

    /** Creates the tetris block T:
     * 	E S S
     * 	E S E
     *	S S E
     * with the size 3x3. */
    public static Poly polyT() {
        int size = 3;
        SquareType[][] tSquare = new SquareType[size][size];
	emptyBackground(tSquare, size);
	tSquare[0][0] = SquareType.T_BLOCK;
	tSquare[1][0] = SquareType.T_BLOCK;
	tSquare[1][1] = SquareType.T_BLOCK;
	tSquare[2][0] = SquareType.T_BLOCK;
	return new Poly(tSquare);
    }

    /** Creates the tetris block S:
     * 	E S S
     * 	E S E
     *	S S E
     * with the size 3x3. */
    public static Poly polyS() {
        int size = 3;
        SquareType[][] sSquare = new SquareType[size][size];
	emptyBackground(sSquare, size);
        sSquare[0][1] = SquareType.S_BLOCK;
	sSquare[1][0] = SquareType.S_BLOCK;
	sSquare[1][1] = SquareType.S_BLOCK;
	sSquare[2][0] = SquareType.S_BLOCK;
    	return new Poly(sSquare);
    }

    /** Creates the tetris block Z:
     * 	Z Z E
     * 	E Z E
     *	E Z Z
     * with the size 3x3. */
    public static Poly polyZ() {
        int size = 3;
        SquareType[][] zSquare = new SquareType[size][size];
	emptyBackground(zSquare, size);
    	zSquare[0][0] = SquareType.Z_BLOCK;
	zSquare[1][0] = SquareType.Z_BLOCK;
	zSquare[1][1] = SquareType.Z_BLOCK;
	zSquare[2][1] = SquareType.Z_BLOCK;
    	return new Poly(zSquare);
    }

    /** Creates the tetris block J:
     * 	E J E
     * 	E J E
     *	J J E
     * with the size 3x3. */
    public static Poly polyJ() {
        int size = 3;
        SquareType[][] jSquare = new SquareType[size][size];
	emptyBackground(jSquare, size);
        jSquare[1][0] = SquareType.J_BLOCK;
        jSquare[1][1] = SquareType.J_BLOCK;
	jSquare[1][2] = SquareType.J_BLOCK;
	jSquare[0][2] = SquareType.J_BLOCK;
    	return new Poly(jSquare);
    }

    /** Creates the tetris block L:
     *	E L E
     *	E L E
     *	E L L
     * with the size 3x3. */
    public static Poly polyL() {
        int size = 3;
        SquareType[][] lSquare = new SquareType[size][size];
	emptyBackground(lSquare, size);
        lSquare[1][0] = SquareType.L_BLOCK;
	lSquare[1][1] = SquareType.L_BLOCK;
	lSquare[1][2] = SquareType.L_BLOCK;
	lSquare[2][2] = SquareType.L_BLOCK;
    	return new Poly(lSquare);
    }

    public static void main (String[] args) {
        TetrominoMaker tetro = new TetrominoMaker();
        System.out.println(tetro.getNumberOfTypes());
    }
}
