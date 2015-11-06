package uk.ac.ucl.cs.nterreri.pascal;

import java.util.Scanner;
/**
 * Program to print arbitrarily large Pascal triangle.
 * <p>
 * This version stores the calculated data in a simple two-dimensional int
 * array. Then copies the content of this array to another larger array.
 * This other array is then printed to screen.
 * 
 * @author salpo
 * @version 17/10/15 - 2
 * 
 */
public class PascalFixed {

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
		
		//"Stair" array declaration
		int stair[][] = new int[numRows][];
		
		/*Stair initial assignment: each subarray is initialized to hold
		 * 1, 2, 3, 4, etc. -many values
		 */
		for(int i = 0; i < numRows; i++)
			stair[i] = new int[i + 1];
		
		/*The array is then filled with Pascal triangle values by means
		 * of a recursive function:
		 */
		for(int i = 0; i < numRows; i++)
			for(int j = 0; j <= i; j++)
				stair[i][j] = computePositionValue(i, j);
		
		//prints stairs:
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j <= i; j++)
				System.out.print(stair[i][j] +" ");
			System.out.println();
		}
		
		/*Array "pyramid" is a two dimensional array graphically
		 * representing a triangle shaped representation of Pascal's
		 * triangle (as opposed to a stair)
		 */
		//numRows = numRows
		int numColumns = (numRows * 2) - 1;
		int centralPos = ((numColumns)/ 2);
		int pyramid[][] = new int[numRows][numColumns];
		int second_stair_index;
		
		//Fill in even rows:
		for(int i = 0; i < numRows; i += 2)
		{
			/*Separate indexes for pyramid and stair are necessary:
			 * stair looks something like this:
			 * [x]
			 * [x][x]
			 * [x][x][x]
			 * [x][x][x][x]
			 * [x][x][x][x][x]
			 * 
			 * pyramid looks like this:
			 * [x][x][x][x][x][x][x][x][x][x]
			 * [x][x][x][x][x][x][x][x][x][x]
			 * [x][x][x][x][x][x][x][x][x][x]
			 * [x][x][x][x][x][x][x][x][x][x]
			 * [x][x][x][x][x][x][x][x][x][x]
			 * 
			 * The size of each sub-array in stairs is smaller than
			 * any sub-array in pyramid.
			 */
			second_stair_index = 0;
			for(int j = (centralPos - i);
					j <= (centralPos + i);
					j++)
			{
				/*For even row, fill pyramid with a value in stair if the column
				 * is odd, or with a 0
				 */
				if((j%2 != 0) && (second_stair_index <= i))
				{
					pyramid[i][j] = stair[i][second_stair_index];
					++second_stair_index;
				}
				else
					pyramid[i][j] = 0;
			}
		}
		
		//Fill in odd rows:
		for(int i = 1; i < numRows; i += 2)
		{
			second_stair_index = 0;
			for(int j = (centralPos - i);
					j <= (centralPos + i);
					j++)
			{
				/* For odd row, fill pyramid with a value from stair if
				 * the column is even:
				 */
				if((j%2 == 0) && (second_stair_index <= i))
				{
					pyramid[i][j] = stair[i][second_stair_index];
					++second_stair_index;
				}
				else
					pyramid[i][j] = 0;

			}
		}


		//Print pyramid: if the value is 0, print a space instead:
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numColumns; j++)
			{
				if(pyramid[i][j] == 0)
					System.out.print("  ");
				else
					System.out.print(pyramid[i][j] + " ");
			}
			System.out.println();
		}

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
