package se.liu.ida.gussv907.tddd78.tetris;

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

    private static Poly polyI() {
        int size = 4;
        SquareType[][] iSquare = new SquareType[size][size];
        for (int w = 0; w < size; w++) {
            for (int h = 0; h < size; h++) {
                iSquare[w][h] = SquareType.I;
	    }
	}
        return new Poly(iSquare);
    }

    private static Poly polyO() {
	int size = 2;
	SquareType[][] oSquare = new SquareType[size][size];
	for (int w = 0; w < size; w++) {
	    for (int h = 0; h < size; h++) {
		oSquare[w][h] = SquareType.O;
	    }
	}
	return new Poly(oSquare);
    }

    private static Poly polyT() {
        int size = 3;
        SquareType[][] tSquare = new SquareType[size][size];
	for (int w = 0; w < size; w++) {
	    for (int h = 0; h < size; h++) {
	        tSquare[w][h] = SquareType.T;
	    }
	}
	return new Poly(tSquare);
    }

    private static Poly polyS() {
        int size = 3;
        SquareType[][] sSquare = new SquareType[size][size];
    	for (int w = 0; w < size; w++) {
    	    for (int h = 0; h < size; h++) {
    	        sSquare[w][h] = SquareType.S;
    	    }
    	}
    	return new Poly(sSquare);
    }

    private static Poly polyZ() {
        int size = 3;
        SquareType[][] zSquare = new SquareType[size][size];
    	for (int w = 0; w < size; w++) {
    	    for (int h = 0; h < size; h++) {
    	        zSquare[w][h] = SquareType.Z;
    	    }
    	}
    	return new Poly(zSquare);
    }

    private static Poly polyJ() {
        int size = 3;
        SquareType[][] jSquare = new SquareType[size][size];
    	for (int w = 0; w < size; w++) {
    	    for (int h = 0; h < size; h++) {
    	        jSquare[w][h] = SquareType.J;
    	    }
    	}
    	return new Poly(jSquare);
    }

    private static Poly polyL() {
        int size = 3;
        SquareType[][] lSquare = new SquareType[size][size];
    	for (int w = 0; w < size; w++) {
    	    for (int h = 0; h < size; h++) {
    	        lSquare[w][h] = SquareType.L;
    	    }
    	}
    	return new Poly(lSquare);
    }

    private static Poly polyEmpty() {
        SquareType[][] emptySquare = new SquareType[0][0];
        return new Poly(emptySquare);
        }

    public static void main (String[] args) {
        TetrominoMaker tetro = new TetrominoMaker();
        System.out.println(tetro.getNumberOfTypes());
    }
}
