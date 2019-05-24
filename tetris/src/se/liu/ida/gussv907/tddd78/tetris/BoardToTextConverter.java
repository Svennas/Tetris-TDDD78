package se.liu.ida.gussv907.tddd78.tetris;

/**
 * This class converts the SquareTypes on a board to string. It is not used in the actual game
 * but rather during the earlier stages of the project.
 */
public class BoardToTextConverter {

    public String convertToText(Board board) {

	StringBuilder boardString = new StringBuilder();

        for(int width = 0; width < board.getPlayingBoardWidth(); width++) {
            for(int height = 0; height < board.getPlayingBoardHeight(); height++) {

                switch(board.getSquareAt(width, height)) {

		    case EMPTY:
			boardString.append("-");
			break;
		    case I_BLOCK:
			boardString.append("I");
			break;
		    case O_BLOCK:
			boardString.append("O");
			break;
		    case T_BLOCK:
			boardString.append("T");
			break;
		    case S_BLOCK:
			boardString.append("S");
			break;
		    case Z_BLOCK:
			boardString.append("Z");
			break;
		    case J_BLOCK:
			boardString.append("J");
			break;
		    case L_BLOCK:
			boardString.append("L");
			break;
		    default:
		        boardString.append("||");
		}
	    }
	    boardString.append("\n");
	}
        return boardString.toString();
    }
}
