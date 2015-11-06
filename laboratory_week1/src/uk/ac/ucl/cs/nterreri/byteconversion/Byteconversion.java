package uk.ac.ucl.cs.nterreri.byteconversion;

import java.util.Scanner;
import java.lang.Math;

/**
 * Simple byte unit measure conversion program.
 * 
 * @author nterreri
 *
 */
public class Byteconversion {
	
	public static String compute_bytesize(double bytes, int index){
		final String [] UNITS = {"B", "KB", "MB", "GB"};
		return ((bytes * Math.pow( 2, -(index * 10))) + " " + UNITS[index]);
	}
	
	public static void main(String[] args) {

		
		long input;
		double bytes;
		
		Scanner is = new Scanner(System.in);
		
		System.out.print("This program reads a number of bytes and\n" 
				+ "computes and outputs to console this number in four\n"
				+ "different unit measures.\n");
		System.out.println("Enter the number of bytes:\n");
		input = is.nextLong();
		
		bytes = (double)input;
		
		System.out.println("The number entered amounts to:");
		
		for(int i = 0; i < 4; i++)
			System.out.println(compute_bytesize(bytes, i));
		
		System.out.println("Terminating program.");
		is.close();
	}

}
