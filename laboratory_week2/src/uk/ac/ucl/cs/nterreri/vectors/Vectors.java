package uk.ac.ucl.cs.nterreri.vectors;

import java.util.Scanner;
import java.util.Vector;

/**
 * Practice vector program.
 * 
 * @author nterreri
 *
 */
public class Vectors {
	
	public static void swap(final Vector<Double> v, int index1, 
			int index2){
		double temp = v.get(index1);
		v.set(index1, v.get(index2));
		v.set(index2, temp);
	}
	
	public static int index_of_smallest(final Vector<Double> v, 
			int start_index){
		double min = v.get(start_index);
		int	index_of_smallest = start_index;
		for (int i = start_index + 1; i < v.size(); i++)
			if(v.get(i) < min)
			{
				min = v.get(i);
				index_of_smallest = i;
			}

		return index_of_smallest;
	}
	
	public static void sort(Vector<Double> v){
		
		int index_of_smallest = 0;
		for(int i = 0; i < v.size(); i++)
		{
				index_of_smallest = index_of_smallest(v, i);
			swap(v, i, index_of_smallest);
		}
	}
	
	public static void getinput(Vector<Double> v){
		Scanner is = new Scanner(System.in);
		double input;
		
		System.out.println("Enter some positive real numbers:");
		do
		{
			input = is.nextDouble();
			if(input < 0.0)
				System.err.println("Error: please enter either positive"
						+ " numbers or 0.");
			else if (input == 0.0){
				//do nothing
			}
			else{
				v.add(input);
			}

		} while(input != 0.0);
		is.close();
	}
	
	public static void main(String[] args){
		Vector<Double> v = new Vector<Double>(50);
		
		getinput(v);
		sort(v);
		
		for(int i = 0; i < v.size(); i++)
			System.out.print(v.get(i) + " ");
		
		System.out.println("Terminating program.");
	}
	
}
