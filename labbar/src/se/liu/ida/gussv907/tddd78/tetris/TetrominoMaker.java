package se.liu.ida.gussv907.tddd78.tetris;

/**
 *
 */
public class TetrominoMaker
{
    public int getNumberOfTypes() {
        return SquareType.values().length - 1;
    }

    public Poly getPoly(int typeNum) {

        Poly poly;

        if(typeNum < 0 || typeNum > getNumberOfTypes() - 1) {
	    throw new IllegalArgumentException("Invalid index: " + typeNum);
	}

	switch (typeNum) {
	    case 0: // Creates squares of type I.
		poly = polyI();
	    break;
	    case 1: // Creates squares of type O.
		poly = polyO();
	    break;
	    case 2: // Creates squares of type T.
		poly = polyT();
	    break;
	    case 3: // Creates squares of type S.
		poly = polyS();
	    break;
	    case 4: // Creates squares of type Z.
		poly = polyZ();
	    break;
	    case 5: // Creates squares of type J.
		poly = polyJ();
	    break;
	    case 6: // Creates squares of type L.
		poly = polyL();
	    break;
	    default:
		poly = polyEmpty();
		break;
	}

	return poly;
    }

    public static void emptyBackground(SquareType[][] square, int size) {
        for(int width = 0; width < size; width++) {
            for(int height = 0; height < size; height++) {
		square[width][height] = SquareType.EMPTY;
	    }
	}
    }

    public static Poly polyI() {
        int size = 4;
        SquareType[][] iSquare = new SquareType[size][size];
	emptyBackground(iSquare, size);
        iSquare[0][1] = SquareType.I;
	iSquare[1][1] = SquareType.I;
	iSquare[2][1] = SquareType.I;
	iSquare[3][1] = SquareType.I;
        return new Poly(iSquare);
    }

    public static Poly polyO() {
	int size = 2;
	SquareType[][] oSquare = new SquareType[size][size];
	oSquare[0][0] = SquareType.O;
	oSquare[0][1] = SquareType.O;
	oSquare[1][0] = SquareType.O;
	oSquare[1][1] = SquareType.O;
	return new Poly(oSquare);
    }

    public static Poly polyT() {
        int size = 3;
        SquareType[][] tSquare = new SquareType[size][size];
	emptyBackground(tSquare, size);
	tSquare[0][1] = SquareType.T;
	tSquare[1][0] = SquareType.T;
	tSquare[1][1] = SquareType.T;
	tSquare[1][2] = SquareType.T;
	return new Poly(tSquare);
    }

    public static Poly polyS() {
        int size = 3;
        SquareType[][] sSquare = new SquareType[size][size];
	emptyBackground(sSquare, size);
        sSquare[0][1] = SquareType.S;
	sSquare[0][2] = SquareType.S;
	sSquare[1][0] = SquareType.S;
	sSquare[1][1] = SquareType.S;
    	return new Poly(sSquare);
    }

    public static Poly polyZ() {
        int size = 3;
        SquareType[][] zSquare = new SquareType[size][size];
	emptyBackground(zSquare, size);
    	zSquare[0][0] = SquareType.Z;
	zSquare[0][1] = SquareType.Z;
	zSquare[1][1] = SquareType.Z;
	zSquare[1][2] = SquareType.Z;
    	return new Poly(zSquare);
    }

    public static Poly polyJ() {
        int size = 3;
        SquareType[][] jSquare = new SquareType[size][size];
	emptyBackground(jSquare, size);
        jSquare[0][1] = SquareType.J;
	jSquare[1][1] = SquareType.J;
	jSquare[2][0] = SquareType.J;
	jSquare[2][1] = SquareType.J;
    	return new Poly(jSquare);
    }

    public static Poly polyL() {
        int size = 3;
        SquareType[][] lSquare = new SquareType[size][size];
	emptyBackground(lSquare, size);
        lSquare[0][1] = SquareType.L;
	lSquare[1][1] = SquareType.L;
	lSquare[2][1] = SquareType.L;
	lSquare[2][2] = SquareType.L;
    	return new Poly(lSquare);
    }

    public static Poly polyEmpty() {
        SquareType[][] emptySquare = new SquareType[0][0];
        return new Poly(emptySquare);
        }

    public static void main (String[] args) {
        TetrominoMaker tetro = new TetrominoMaker();
        System.out.println(tetro.getNumberOfTypes());
    }
}
