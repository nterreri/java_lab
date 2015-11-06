package uk.ac.ucl.cs.nterreri.arrays;

/**
 * Array practice example.
 * 
 * @author nterreri
 *
 */
public class arrays {
	public static void main(String[] args){

		int numbers[] = new int[20];
		
		for(int i = 0; i < 20; i++)
			numbers[i] = (i + 1);
		
		int means[] = new int[20];
		
		for(int i = 0; i < 20; i++)
		{
			if(i == 0)
				means[i] = numbers[i];
			else if (i == 19)
				means[i] = numbers[i];
			else
				means[i] = (numbers[i - 1] + numbers[i + 1]) / 2;
		}
		for(int i = 0; i < 20; i++)
			System.out.print(numbers[i] + " ");
		System.out.println();
		for(int i = 0; i < 20; i++)
			System.out.print(means[i] + " ");
		
	}
}
