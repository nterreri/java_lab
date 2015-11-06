package uk.ac.ucl.cs.nterreri.mole;

import java.util.Random;

/**
 * Abstract class GameScore is used to store data relevant to both the game as
 * it is running, and registering highscores.
 * 
 * Finally, it is also responsible for generating random numbers for the position
 * of the next mole.
 * 
 * @author nterreri
 *
 */
abstract class GameScore {
	
	//game relevant:
	public static int evt_counter;
	public static double increment;
	public static int score;
	public static int diff_modifier;
	
	//record relevant:
	public static String name;
	public static int rank;
	
	//random position generation:
	public static int randx;
	public static int randy;
	
	public static void generateRandomPos(){
		Random generator = new Random();
		
		randx = generator.nextInt(4);
		randy = generator.nextInt(4);
	}
	
	public static void reset() {
		
		evt_counter = 0;
		increment = 0;
		score = 0;
		
		name = null;
		rank = 0;
	}
}
