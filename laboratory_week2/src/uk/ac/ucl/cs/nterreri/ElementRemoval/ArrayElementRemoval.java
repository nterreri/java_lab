package uk.ac.ucl.cs.nterreri.ElementRemoval;

/**
 * Practice array manipulation.
 * 
 * @author nterreri
 *
 */
public class ArrayElementRemoval {

	final static int POSITION = 7;
	
	public static String[] remElement(String[] stringset, int index){
		if(index < stringset.length){
			String[] result = new String[stringset.length - 1];
			for(int i = 0; i < index; i++)
				result[i] = stringset[i];
			for(int i = index; i < result.length; i++)
				result[i] = stringset[i + 1];
			return result;
		}
		else {
			System.err.println("Error: remElement was passed an index out of"
					+ " range.\n"
					+ "Returning string set parameter unmodified.");

			return stringset;
		}
			
	}
	public static void main(String[] args) {
		String[] arr = {"The ", "quick ", "brown ", "fox ", "jumps ",
				"over ", "the ", "lazy ", "dog."};
		
		System.out.print("String set array initialized with: \"");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]);
		System.out.println("\"");
		
		System.out.println("Eliminating set element number " + POSITION);
		arr = remElement(arr, POSITION);

		System.out.print("String set array changed to: \"");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]);
		System.out.println("\"");
		
		System.out.println("Terminating program.");
	}

}
