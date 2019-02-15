package se.liu.ida.gussv907.tddd78.tetris;

public class BoardToTextConverter
{
    StringBuilder boardString = new StringBuilder();

    public String convertToText(Board board) {
        for(int width = 0; width < board.getWidth(); width++) {
            for(int height = 0; height < board.getHeight(); height++) {

                switch(board.getSquareAt(width, height)) {

		    case EMPTY:
			boardString.append("-");
			break;
		    case I:
			boardString.append("I");
			break;
		    case O:
			boardString.append("O");
			break;
		    case T:
			boardString.append("T");
			break;
		    case S:
			boardString.append("S");
			break;
		    case Z:
			boardString.append("Z");
			break;
		    case J:
			boardString.append("J");
			break;
		    case L:
			boardString.append("L");
			break;
		    default:
		        boardString.append("-");
		}
	    }
	    boardString.append("\n");
	}
        return boardString.toString();
    }
}
