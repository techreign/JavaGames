package stats;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.logging.Handler;

import main.Game;
import main.HUD;

public class Character extends GameObject {
	
	public static int char_counter = 0;
	public int health = 100;
	public String name;
	public main.Handler handler;
	
	public Character(int x, int y, ID id, String name, main.Handler handler) {
		
		super(x, y, id);
		this.name = name;
		this.handler = handler;
		char_counter ++;
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		
		collision();
		
	}
	
	public void collision(){
		for (int i = 0; i < handler.object.size(); i++){
			
			if (handler.object.get(i).getId() == ID.Neutral) {
				if (getBounds().intersects(handler.object.get(i).getBounds())){
					HUD.HEALTH -= 100;
				}
			}
			
		}
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
		
	}
	

}
