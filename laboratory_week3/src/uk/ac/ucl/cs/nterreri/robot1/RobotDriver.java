package uk.ac.ucl.cs.nterreri.robot1;

public class RobotDriver {

	public static void main(String[] args) {
		Robot1 r = new Robot1();
		
		r.move(11);
		r.battery_recharge(2.5);
		r.battery_recharge(0.5);
		r.move(5);
		
		System.out.println("Terminating program.");
	}

}
