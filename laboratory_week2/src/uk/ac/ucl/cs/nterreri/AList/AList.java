package uk.ac.ucl.cs.nterreri.AList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * ArrayList practice.
 * 
 * @author nterreri
 *
 */
public class AList {
	
	public static void main(String[] args){
		ArrayList<Integer> aList = new ArrayList<Integer>(100);
		Random randomInt = new Random();
		System.out.println("Adding 100 random integers to aList.");
		
		System.out.println("Printing the content of aList:");
		for(int i = 0; i < 100; i++)
			aList.add(randomInt.nextInt(500));
		for(int i = 0; i < 100; i++)
			System.out.println(aList.get(i));
		
		System.out.println("Storing the even numbers in aList ...");
		ArrayList<Integer> evens = new ArrayList<Integer>(65);
		for(int i = 0; i < 100; i++)
			if(aList.get(i)%2 == 0)
				evens.add(aList.get(i));
		/*System.out.println("----------------------------------------------");
		for(int i = 0; i < evens.size(); i++)
			System.out.println(evens.get(i)); //debug*/
		
		int sum = 0;
		for(int i = 0; i < evens.size(); i++)
			sum += evens.get(i);
		System.out.println("The sum of the even numbers in aList = " + sum);
		
		evens.clear();
		System.out.println("Adding the even numbers in aList to a separate "
				+ " list, and removing them from aList ...");
		for(int i = 0; i < aList.size(); i++)
			if(aList.get(i)%2 == 0)
			{
				evens.add(aList.get(i));
				aList.remove(i);
			}
		System.out.println("Now, adding them back to the end of aList ...");
		for(int i = 0; i < evens.size(); i++)
			aList.add(evens.get(i));
		
		System.out.println("Copying the content of aList to an int array,"
				+ " then printing them:");
		int a[] = new int[100];
		for(int i = 0; i < 100; i++)
			a[i] = aList.get(i);
		System.out.println(Arrays.toString(a));
		
		System.out.println("Terminating program.");
	}
	
}
