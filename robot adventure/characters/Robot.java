package characters;

public class Robot extends Character {
	
	private String ID;
	public String[] software;
	private String type = "robot";
	public static int robot_counter = 0;
	
	public Robot(String name, int hp, int energy, String ID, String[] software) {
		super(name, hp, energy);
		this.ID = ID;
		this.software = software;
		robot_counter += 1;
	}

	public static String getRobotCounter() {
		return "Robot count is " + robot_counter + ".";
	}
	
	// Setters
	@SuppressWarnings("unused")
	private void setID(String ID){
		this.ID = ID;
	}
	public void setSoftware(String[] software){
		this.software = software;
	}
	// Getters
	
	@SuppressWarnings("unused")
	private String getID(){
		return this.ID;
	}

	public String[] getSoftware(){
		return this.software;
	}
	@Override
	public String toString(){
		String str = "";
		String soft = "";
		for (int i = 0; i < software.length;i++){
			if (software[i] instanceof String){
				soft += " " + software[i];
			}
		}
		str = "Name: " + getName() + "\n" + "Level: " + getLevel() + "\n" + "HP: " + getHp() + " / " + getMaxHp() + "\n" + "Energy: " +
				getEnergy() + " / " + getMaxEnergy() +  "\n" + "Software:" + soft + "\n" + "EXP: " + getExp() + " / 100";
		return str;
	}
	
	public String rep(){
		String str = "";
		str = getName() + "\n" + "HP: " + getHp() + " / " + getMaxHp();
		return str;
	}
	public String shout(){
		return "Yahoo!";
	}
	public void punch(Character other){
		if (other.getHp() > 10) {
			other.setHp(other.getHp() - 10);
		}
		else other.setHp(0);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
