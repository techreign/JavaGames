package characters;

public class Aliens extends Character {
	
	public String race;
	
	public Aliens(String name, int hp, int energy, String race) {
		super(name, hp, energy);
		this.race = race;
	}	

}
