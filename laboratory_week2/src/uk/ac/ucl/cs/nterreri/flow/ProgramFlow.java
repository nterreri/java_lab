package uk.ac.ucl.cs.nterreri.flow;

import java.util.Scanner;

/**
 * Practice neater ways to return a value.
 * 
 * @author nterreri
 *
 */
public class ProgramFlow {
	/**
	 * Returns true if given integer is even, false otherwise
	 * @param number
	 * @version 0
	 * @return
	 */
	public static boolean isEvenOriginal (int number) {
		if (number % 2 == 0)
			return true;
		else
			return false;
	}

	/**
	 * Returns true if given integer is even, false otherwise
	 * @param number
	 * @version 1
	 * @return
	 */
	public static boolean isEvenVersion1 (int number) {
		boolean result;
		if (number % 2 == 0)
			result = true;
		else
			result = false;

		return result;
	}
	
	/**
	 * Returns true if given integer is even, false otherwise
	 * @param number
	 * @version 3/4
	 * @return
	 */
	public static boolean isEven (int number) {
		return ((number % 2 == 0) ? true : false);
	}

	 public static void main(String[] args){
		 char loopcontrol;
		 int number;
		 Scanner is = new Scanner(System.in);
		 
		 do
		 {
			 System.out.println("Please, enter a number.");
			 
			 number = is.nextInt();
			 System.out.println("The statement: " + "\"The number is even.\"" 
			 + " is "+ isEven(number) + "."); 
			 
			 System.out.println("Would you like to try again? y/n");
			 loopcontrol = is.next().charAt(0);
		 } while(loopcontrol == 'y' || loopcontrol == 'Y');
		
		 System.out.println("Terminating program.");
		 is.close();
	 }
}
