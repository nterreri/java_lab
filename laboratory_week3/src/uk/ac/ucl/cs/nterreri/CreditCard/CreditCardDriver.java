package uk.ac.ucl.cs.nterreri.CreditCard;

public class CreditCardDriver {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		CreditCard cc = new CreditCard(10, 2014, "Bob", "Jones", 
				"1234567890123456");
		CreditCard broken1 = new CreditCard(24, 99999, "Santa", "Claus", 
				"1234567890123456");
		CreditCard broken2 = new CreditCard(24, 5, "Jon", "Jones",
				"1234567890123456");
		CreditCard broken3 = new CreditCard(24, 1000, "J", "J",
				"123");
		CreditCard broken4 = new CreditCard(24, 1000, "O", "O", 
				"12345678901234567890");
		
		System.out.println("Printing formatted cc expiry date:\n"
				+ cc.formatExpiryDate());
		System.out.println("Printing formatted cc name:\n"
				+ cc.formatFullName());
		System.out.println("Printing formatted cc number:\n"
				+ cc.formatCCNumber());
		
		CreditCard notExpiredSameYear = new CreditCard(12, 2015, "Bob", 
				"Jones", "1234567890123456");
		CreditCard notExpiredFutureYear = new CreditCard(12, 2019, "Bob", 
				"Jones", "1234567890123456");
		CreditCard expiredSameYear = new CreditCard(6, 2015, "Bob", "Jones", 
				"1234567890123456");
		
		System.out.println("\nIs cc expired? " + !cc.isValid() + "\n" + 
				"Is notExpiredSameYear expired? " + 
				!notExpiredSameYear.isValid() + "\n" +
				"Is notExpiredFutureYear expired? " + 
				!notExpiredFutureYear.isValid() + "\n" +
				"Is expiredSameYear expired? " + !expiredSameYear.isValid() +
				"\n");
		
		System.out.println("cc toString: " + cc.toString());
		
	}

}
