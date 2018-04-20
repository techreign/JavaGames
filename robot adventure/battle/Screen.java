package battle;

public class Screen {
	
	public String first;
	public String second;

	
	public String first() {
		// first battle screen 15 spaces between 1 and 2
		first = "1. Battle               2. Flee";
		return first;
	}
	
	public String second(){
		second = "1. Punch               2. Shoot \n3.Laser                 4. Special";		
		return second;
	}

}
