package stats;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;
import main.Handler;

public class SmartEnemy extends Enemy{
	
	private Handler handler;
	private GameObject player;

	public SmartEnemy(int x, int y, ID id, int difficulty, Handler handler) {
		super(x, y, id, difficulty);
		
		this.handler = handler;
		
		for (int i= 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getId() == ID.Player){
				player = handler.object.get(i);
			}
		}
	}

	@Override
	public void tick() {
		
		x += velX;
		y += velY;
		
		if (player.getX() + 7 <= x){
			velX = -2;
		}
		if (player.getX() + 7 > x){
			velX = 2;
		}
		if (player.getY() <= y + 15){
			velY = -3;
		}
		if (player.getY() > y + 15){
			velY = 3;
		}

	
		
		//handler.addObject(new Trail(x, y, ID.Enemy, Color.green, 16, 16, 0.02f, handler));
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 16, 16);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}
	
	
	
	

}
