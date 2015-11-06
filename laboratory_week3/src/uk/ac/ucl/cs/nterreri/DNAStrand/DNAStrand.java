package uk.ac.ucl.cs.nterreri.DNAStrand;

public class DNAStrand {

	private String dna;
	
	//methods:
	public DNAStrand(String dna){
		this.dna = dna;
		if(!this.isValidDNA())
			System.err.println("Warning: initialized/assigned a DNAStrand "
					+ "with an invalid String value.\n");
	}
	
	public boolean isValidDNA(){
		if(dna.isEmpty())
			return false;
		
		for(int i = 0; i < dna.length(); i++)
			if(!isBase(dna.charAt(i)))
				return false;
		
		return true;
	}
	
	public String complementWC(){
		char[] result = dna.toCharArray();
		
		for(int i = 0; i < result.length; i++)
			result[i] = complementWCLetter(result[i]);
		
		return String.valueOf(result);
	}
	
	public String palindromeWC(){
		String complement = this.complementWC();
		char[] palindrome_charar = new char [complement.length()];
		
		int index_f = 0;
		int index_b = complement.length() - 1;
		
		while(index_f < complement.length() &&
				index_b >= 0)
			{
				palindrome_charar[index_f] = complement.charAt(index_b);
				++index_f;
				--index_b;
			}
		
		return String.valueOf(palindrome_charar);
	}

	public boolean containsSequence(String seq){
		
		for(int i = seq.length(); i < dna.length(); i++){
			if(dna.charAt(i) == seq.charAt(seq.length() - 1))
			{
				int dna_index_b = i;
				int seq_index_b = seq.length() - 1;
				while(seq_index_b >= 0 && (dna.charAt(dna_index_b) 
						== seq.charAt(seq_index_b)))
				{
					--dna_index_b;
					--seq_index_b;
				}
				
				if(seq_index_b == -1)
					return true;
			}
		}
		
		return false;
		
	}

	public String toString(){
		return  dna;
	}
	
	//private:
	private boolean isBase(char c){
		switch(c)
		{
		case 'A':
		case 'T':
		case 'C':
		case 'G':
			return true;
			default:
				return false;
		}
	}
	
	private char complementWCLetter(char c){
		switch(c)
		{
		case 'A':
			return 'T';
		case 'T':
			return 'A';
		case 'C':
			return 'G';
		case 'G':
			return 'C';
		default:
			return c;
		}
	}
	
}
