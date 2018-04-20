package stats;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;

public class Block extends GameObject {

	public int health = 20;
	
	public Block(int x, int y, ID id, int type) {
		
		super(x, y, id);
		
		// Depending on the type chosen, the opponent will have varying health
		if (type == 0) {
			this.health = 10;
		} else if (type == 1) {
			this. health = 20;
		} else {
			this.health = 30;
		}
		velY = -3;
	}

	@Override
	public void tick() {
		//x += velX;
		y += velY;
		
		if (y <= 0 || y >= Game.HEIGHT - 32) {
			velY = 0;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, 16, 16);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

}
