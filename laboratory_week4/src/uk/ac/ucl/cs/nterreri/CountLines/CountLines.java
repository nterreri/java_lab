package uk.ac.ucl.cs.nterreri.CountLines;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class CountLines {
	
	public static void main(String[] args) {
	
		
		if(args.length <= 0)
		{
			System.err.println("This program must be called with existing file names as program arguments.\n"
					+"args [FILENAME1] [FILENAME2] ...");
		}
		
		int lines[] = new int[args.length];
		BufferedReader is;
		
		for(int i = 0; i < args.length; i++)
		{
			try {
				is = new BufferedReader(new FileReader(args[i]));
				lines[i] = count(is);
				is.close();
				
			} catch (FileNotFoundException e) {
				System.err.println("Could not find file " + args[i]);
				lines[i] = 0;
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println(
						"General IOException occurred while counting lines in file "
								+ args[i]);
				lines[i] = 0;
				e.printStackTrace();
				
			}
			
		}
		
		output(args, lines);
	}

	static void output(String[] args, int[] lines) {
		for (int i = 0; i < args.length; i++)
		{
			System.out.println(args[i] + " contains " + lines[i] + " lines.");
		}
	}
	
	static int count(BufferedReader is) throws IOException {
		int counter = 0;
		
		while(is.ready())
		{
			is.readLine();
			counter++;
		}
		
		return counter;
	}
	
	
}
