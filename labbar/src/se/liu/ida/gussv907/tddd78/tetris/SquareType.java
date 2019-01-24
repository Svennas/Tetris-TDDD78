package se.liu.ida.gussv907.tddd78.tetris;

import java.util.Random;

public enum SquareType
{
    EMPTY, I, O, T, S, Z, J, L;


    public static void main(String[] args)
    {
        Random rnd = new Random();

        int numOfTypes = SquareType.values().length;

        for(int i = 0; i < 25; i++) {
	    System.out.println(SquareType.values()[rnd.nextInt(numOfTypes)]);
	}
    }
}