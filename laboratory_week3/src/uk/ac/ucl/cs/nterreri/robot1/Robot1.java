package uk.ac.ucl.cs.nterreri.robot1;

public class Robot1 {
	//private:
	protected double battery_charge = 5.0;
	protected int steps = 0;

	//public:
	public Robot1(){}
	public void battery_recharge(double c){
		battery_charge += c;
		System.out.println("Battery level: " + battery_charge);
	}
	public void move(int distance){
		while((distance > 0)
				&& (battery_charge >= 0.5)){
			--distance;
			battery_charge -= 0.5;

			++steps;
			System.out.print("[" + steps + "]" + " ");
		}

		if(battery_charge <= 0.5)
			System.out.println("Out of power!");
	}


}

