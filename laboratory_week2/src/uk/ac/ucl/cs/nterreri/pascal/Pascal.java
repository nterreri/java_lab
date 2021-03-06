package uk.ac.ucl.cs.nterreri.pascal;

import java.util.Scanner;
import java.util.Vector;

/**
 * Program to print arbitrarily large Pascal triangle.
 * <p>
 * This version stores the calculated data in a simple two-dimensional int
 * array, this proves inconvenient when attempting to print the data as a
 * pyramid instead of a stair; compare:
 * <p>
 * 1 <p>
 * 1 1 <p>
 * 1 2 1 <p>
 * 1 3 3 1 <p>
 * 1 4 6 4 1 <p>
 * 1 5 10 10 5 1<p>
 * <p>
 * and<p>
 * <p>
 * {@link https://upload.wikimedia.org/wikipedia/commons/f/f6/Pascal%27s_triangle_5.svg} 
 *  <p>
 * 
 * @author salpo
 * @version 15/10/15 - 0
 * 
 */
public class Pascal {

	public static int computePositionValue(int row, int posinrow){
		if(posinrow == 0)
			return 1;
		else if (posinrow == row)
			return 1;
		else
			{
			int value = (computePositionValue(row, posinrow - 1) 
					* (row + 1 - posinrow)/posinrow);
			return value;
			}
	}
	
	public static void printPascalTriangle(int numRows){
		Vector<Vector<Integer>> stair = new Vector<Vector<Integer>>(numRows);
		for(int i = 0; i < numRows; i++)
			stair.set(i, new Vector<Integer>(numRows));
		
		Vector<Integer> temp;
		for(int i = 0; i < numRows; i++)
			for(int j = 0; j <= i; j++)
				{
					temp.add(i, computePositionValue(i, j));
					stair.set(i, temp);
				}
		
		//prints stairs:
		for(int i = 0; i < numRows; i++)
			{
			for(int j = 0; j <= i; j++)
				System.out.print(stair[i][j] +" ");
			System.out.println();
			}
		
		//numRows = numRows
		int numColumns = (numRows * 2) - 2;
		int centralPos = (numColumns / 2);
		int pyramid[][] = new int[numRows][numColumns];
		for(int i = 0; i < numRows; i++)
			for(int j = (centralPos - i); j < numColumns; j++)
				pyramid[i][j] = stair[i][j];
			
	}
	
	public static void main(String[] args) {
		int rows;
		Scanner is = new Scanner(System.in);
		
		boolean inputcorrect;
		do
		{
			inputcorrect = true;
			System.out.println("Enter the number of rows:");
			rows = is.nextInt();
			if(rows <= 0)
				{
					System.err.println("Error: please enter a positive number of rows.");
					inputcorrect = false;
				}
		} while(!inputcorrect);

		printPascalTriangle(rows);
		is.close();
		System.out.println("Terminating program.");
	}

}
