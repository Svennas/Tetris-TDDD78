package se.liu.ida.gussv907.tddd78.tetris;

import java.util.Random;

public enum SquareType
{
    EMPTY, I, O, T, S, Z, J, L;


    public static void main(String[] args)
    {
        Random rnd = new Random();

        for(int i = 0; i < 25; i++) {
	    System.out.println(rnd.nextInt(100));
	}
    }
}