package characters;

public abstract class Character {

	private String name;
	private double exp = 0.0;
	private int hp;
	private int maxHp;
	private int maxEnergy;
	private int energy;
	private int level = 1;
	
	// Constructor for top class
	public Character(String name, int hp, int energy) {
		this.name = name;
		this.hp = hp;
		this.energy = energy;
		this.maxHp = hp;
		this.maxEnergy = energy;
	}
	
	// Setters	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public void setExp(double exp) {
		this.exp = exp;
	}
	
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public void setMaxEnergy(int maxEnergy){
		this.maxEnergy = maxEnergy;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
	// Getters
	public String getName() {
		return this.name;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	public double getExp() {
		return this.exp;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getMaxEnergy() {
		return maxEnergy;
	}

	
	// attack methods
	public void attack1(int damage, Character other) {
		if (other.hp > damage) {
			other.hp -= damage;
		}
		else other.hp = 0;
	}
	
	public void attack2(int damage, Character other, Character other2) {
		if (other.hp > damage) {
			other.hp -= damage;
		}
		else other.hp = 0;
		
		if (other2.hp > damage) {
			other2.hp -= damage;
		}
		else other2.hp = 0;
	}
	
	public void attack3(int damage, Character other, Character other2, Character other3) {
		if (other.hp > damage) {
			other.hp -= damage;
		}
		else other.hp = 0;
		
		if (other2.hp > damage) {
			other2.hp -= damage;
		}
		else other2.hp = 0;
		
		if (other3.hp > damage) {
			other3.hp -= damage;
		}
		else other3.hp = 0;
	}
	
	public void attack4(int damage, Character other, Character other2, Character other3, Character other4) {
		if (other.hp > damage) {
			other.hp -= damage;
		}
		else other.hp = 0;
		
		if (other2.hp > damage) {
			other2.hp -= damage;
		}
		else other2.hp = 0;
		
		if (other3.hp > damage) {
			other3.hp -= damage;
		}
		else other3.hp = 0;
		
		if (other4.hp > damage) {
			other4.hp -= damage;
		}
		else other4.hp = 0;
	}
	
	// exp methods
	public void increaseExp(double num){
		if ((getExp() + num ) < 100){
			setExp(getExp() + num);	
		} else {
			setLevel(getLevel() + 1);
			setExp((getExp()+num) % 100);
			setHp(getHp() + 10);
			setEnergy(getEnergy() + 10);
			setMaxHp(getMaxHp() + 10);
			setMaxEnergy(getMaxEnergy() + 10);
		}
	}

}
