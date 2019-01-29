package se.liu.ida.gussv907.tddd78.tetris;

public class TetrominoMaker
{
    public int getNumberOfTypes() {
        return SquareType.values().length - 1;
    }

    public static void main (String[] args) {
        TetrominoMaker tetro = new TetrominoMaker();
        System.out.println(tetro.getNumberOfTypes());
    }
}
