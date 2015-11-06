package uk.ac.ucl.cs.nterreri.methods;

import java.util.Scanner;

/** 
 * Simple calculator, sub-procedure job division practice and recursion.
 * @author nterreri
 *
 */
public class methods {

	public static void main(String[] args) {
		int choice;
		int a, b;
		char loopcontrol;
		Scanner is = new Scanner(System.in);
		
		do
		{
			System.out.println("Simple calculator. Please choose an operation:\n");
			System.out.println("\t1. Add\n");
			System.out.println("\t2. Subract\n");
			System.out.println("\t3. Multiply\n");
			System.out.println("\t4. Divide\n");
			System.out.println("\t5. Factorial\n");
			System.out.println("\t6. Exit");
			
			choice = is.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Now enter two numbers:");
				a = is.nextInt();
				b = is.nextInt();
				System.out.println("The result is:");
				System.out.println(add(a, b));
				break;
			case 2:
				System.out.println("Now enter two numbers:");
				a = is.nextInt();
				b = is.nextInt();
				System.out.println("The result is:");
				System.out.println(subtract(a, b));
				break;
			case 3:
				System.out.println("Now enter two numbers:");
				a = is.nextInt();
				b = is.nextInt();
				System.out.println("The result is:");
				System.out.println(multiply(a, b));
				break;
			case 4:
				System.out.println("Now enter two numbers:");
				a = is.nextInt();
				b = is.nextInt();
				System.out.println("The result is:");
				System.out.println(divide(a, b));
				break;
			case 5:
				System.out.println("Now enter one number:");
				a = is.nextInt();
				System.out.println("The result is:");
				System.out.println(factorial(a));
				break;
			case 6:
				System.out.println("Terminating program");
				is.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input\n");
				break;
			}
			
			System.out.println("Would you like to try another operation? y/n");
			loopcontrol = is.next().charAt(0);
			
		} while(loopcontrol == 'y' || loopcontrol == 'Y');
		
		System.out.println("Terminating program");
		is.close();
	}
	public static int add(int a, int b){
		return (a + b);
	}
	public static int subtract(int a, int b){
		return (a - b);
	}
	public static int multiply(int a, int b){
		return (a * b);
	}
	public static double divide(double a, double b){
		return (a / b);
	}
	public static long factorial(long number){
		if(number > 1)
			return (number * factorial(number - 1));
		else
			return 1;
	}
}
