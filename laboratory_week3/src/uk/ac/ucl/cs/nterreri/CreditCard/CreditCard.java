package uk.ac.ucl.cs.nterreri.CreditCard;

import java.util.Calendar;

public class CreditCard {
	//private:
	private int expiry_month, expiry_year;
	private String first_name, last_name;
	private String ccNumber;
	private boolean isDigit(char c){
		switch(c)
		{
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			return true;
		default:
			return false;
		}
	}

	//public:
	public CreditCard(int expiry_month, int expiry_year, String first_name,
			String last_name, String ccNumber){
		if(expiry_year > 9999 || expiry_year < 1000)
		{
			System.err.println("Error: CreditCard object assigned an "
					+ "expiry_year value less or more than 4 digits long.\n"
					+ "Defaulting to 1000\n");
			this.expiry_year = 1000;
		}
		else
			this.expiry_year = expiry_year;


		if(ccNumber.length() != 16)
		{
			System.err.println("Error: CreditCard object assigned a "
					+ "ccNumber value less or more than 16 digits long.\n"
					+ "Defaulting to 1000\n");
		}
		else
			this.ccNumber = ccNumber;

		for(int i = 0; i < ccNumber.length(); i++)
			if(!isDigit(ccNumber.charAt(i)))
			{
				System.err.println("Error: CreditCard object assigned a "
						+ "non-numerical ccNumber value.\n"
						+ "Defaulting to 16 0 digits\n");
				this.ccNumber = "0000" + "0000" + "0000" + "0000";
				break;
			}

		this.expiry_month = expiry_month;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public String formatExpiryDate(){
		String formatted_year = Integer.toString(expiry_year).substring(2);
		return (Integer.toString(expiry_month) + "/" + formatted_year);
	}

	public String formatFullName(){
		return first_name +" "+ last_name;
	}

	public String formatCCNumber(){
		return ccNumber.substring(0, 4) + " "
				+ ccNumber.substring(4,  8) + " "
				+ ccNumber.substring(8, 12) + " "
				+ ccNumber.substring(12, 16);
	}

	public boolean isValid(){
		Calendar now = Calendar.getInstance();
		if((expiry_year < now.get(Calendar.YEAR)) ||
				(expiry_year == now.get(Calendar.YEAR) && 
				expiry_month < now.get(Calendar.MONTH))
				)
			return false;
		else
			return true;
	}

	public String toString(){
		return "Number: " + this.formatCCNumber() + " " +
				"Expiry date: " + this.formatExpiryDate() + " " +
				"Account holder: " + this.formatFullName() + " " +
				"Is valid: " + this.isValid();
	}


}
