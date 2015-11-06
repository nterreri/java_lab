package uk.ac.ucl.cs.nterreri.DNAStrand;

public class DNAStrandDriver {

	public static void main(String[] args) {
		DNAStrand validdna = new DNAStrand("ATTCG");
		DNAStrand invaliddna = new DNAStrand("");
		
		System.out.println("Is validdna a valid DNA strand? " 
							+ validdna.isValidDNA() + "\n"
							+ "Is invaliddna a valid DNA strand? " 
							+ invaliddna.isValidDNA());
		
		invaliddna = new DNAStrand ("!AGGC!");
		
		System.out.println("Is invaliddna, after the new assignment, a " +
							"valid DNA strand? " + invaliddna.isValidDNA());
		
		System.out.println("The WC complement of validdna is: " 
					+ validdna.complementWC());
		
		System.out.println("The WC palindrome of validdna is: "
				+ validdna.palindromeWC());

		System.out.println("Is TTC a subsequence of validdna? "
				+ validdna.containsSequence("TTC") + "\n"
				+ "Is ATC a subsequence of validdna? " 
				+ validdna.containsSequence("ATC"));
		
		System.out.println("\nMoving on to summarise() ...\n");
		DNAStrand s1 = new DNAStrand("AAAAAAAA");
		DNAStrand s2 = new DNAStrand("AAAGTCCCTTGA");
		DNAStrand s3 = new DNAStrand("@+35ogty3�gv");
		DNAStrand s4 = new DNAStrand("GTTAB");
		
		summarise(s1);
		summarise(s2);
		summarise(s3);
		summarise(s4);
	}

	public static void summarise(DNAStrand dna){
		
		System.out.println("Original DNA Sequence: " + dna);
		
		if(dna.isValidDNA()){
			System.out.println("Is valid");
			System.out.println("Complement: " + dna.complementWC());
			System.out.println("WC Palindrome: " + 
								dna.palindromeWC());
		} else {
			System.out.println("Not valid DNA");
		}
	}
}
