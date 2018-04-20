package characters;

public class Nanobot extends Robot {
	 
	public int size;
	
	public Nanobot(String name, int hp, int energy, String ID, String[] software, int size) {
		super(name, hp, energy, ID, software);
		this.size = size;
	}
	public void build(Nanobot other){
		if (other instanceof Nanobot) {
			setHp(getHp() + other.getHp());
			size += other.size;
		}
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString(){
		return super.toString() + "\n" + "Size: " + size;
	}
}
