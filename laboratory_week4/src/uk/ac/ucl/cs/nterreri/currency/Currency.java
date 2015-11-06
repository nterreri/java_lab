package uk.ac.ucl.cs.nterreri.currency;

/**
 * Class to be used in conjunction with CurrencyFrameb.java
 * @author nterreri
 *
 */
public class Currency {
	public Currency(){
		name = "Default";
		rate = 0.0;
	}
	
	public Currency(String name) throws InvalidCurrencyException{
		this.name = name;
		
		try{
		switch(name.charAt(0))
		{
		case 'U':
		case 'u':
			rate = 1.0;
			break;
		case 'G':
		case 'g':
			rate = 2.0;
			break;
		case 'Y':
		case 'y':
			rate = 3.0;
			break;
		case 'E':
		case 'e':
			rate = 4.0;
			break;
			default:
				InvalidCurrencyException e 
					= new InvalidCurrencyException("Currency constructor called with invalid string parameter.");
				throw(e);
		}
		} catch (IndexOutOfBoundsException e) {
			InvalidCurrencyException eInterpreted 
				= new InvalidCurrencyException("Currency constructor Currency(String) called with empty string paramter.");
			throw(eInterpreted);
		}
		
		
	}
	public Currency(String name, double rate){
		this.name = name;
		this.rate = rate;
	}
	
	public double compute_conversion_factor(Currency toCurrency){ 
		if(toCurrency.rate == 0.0 || this.rate == 0.0)
		{
			ArithmeticException e = new ArithmeticException("Currency conversion attempted with null currency rate");
			throw(e);
		}
		return this.rate/toCurrency.rate;
	}
	public String toString(){
		return name + " " + Double.toString(rate); 
	}
	
	public String name;
	public double rate;
}

