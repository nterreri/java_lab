package uk.ac.ucl.cs.nterreri.robot2;

import java.util.Random;
import uk.ac.ucl.cs.nterreri.robot1.Robot1;

public class Robot2 extends Robot1 {
	//public:
	public void setSayings(String[] sayings){
		this.sayings = sayings;
	}
	public void speak(){
		Random randomint = new Random();
		int i = randomint.nextInt(sayings.length);
		System.out.println(sayings[i]);
	}
	//private:
	String[] sayings = {};
}
