package stats;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Shot extends GameObject {
	
	public int damage = 10;
	
	Shot(int x, int y, ID id, int type) {
		
		super(x, y, id);
		
		// Depending on the type chosen, the opponent will have varying damage
		if (type == 0) {
			this.damage = 10;
		} else if (type == 1) {
			this. damage = 20;
		} else {
			this.damage = 30;
		}
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
