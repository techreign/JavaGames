package stats;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;

public class Enemy extends GameObject {
	
	public static int enemy_counter = 0;
	public int health = 100;
	public String name;

	public Enemy(int x, int y, ID id, int difficulty) {
		super(x, y, id);
		
		//Depending on the difficulty chosen, the opponent will have varying health
		if (difficulty == 0) {
			this.health = 50;
		} else if (difficulty == 1) {
			this. health = 100;
		} else {
			this.health = 200;
		}
		
		velX = 3;
		enemy_counter++;
			
	}

	@Override
	public void tick() {
		
		x += velX;
		y += velY;
		
		if (x <= 0 || x >= Game.WIDTH - 32) {
			velX *= -1;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
