package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import stats.Character;
import stats.Enemy;
import stats.ID;

public class Menu extends MouseAdapter{
	
	Game game;
	Handler handler;
	Random r;
	
	
	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if (game.gameState == Game.State.Menu) {
			// The play button
			if (mouseOver(mx,my, 160, 130,500, 64)) {
				game.gameState = Game.State.Game;
				handler.addObject(new Character(400, 500, ID.Player, "Player1", handler));
				handler.addObject(new Enemy(400, 30, ID.Enemy, 1));
			}
			// Options buttons
			if (mouseOver(mx,my, 160, 250, 500, 64)) {
				game.gameState = Game.State.Options;
			}
		
			// The quit button
			if (mouseOver(mx,my, 160, 400, 500, 64)) {
				System.exit(1);
			}
		}
		// The back button
		if (game.gameState == Game.State.Options) {
			if (mouseOver(mx,my, 160, 130,500, 64)) {
				game.gameState = Game.State.Menu;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if (mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			} else return false;
		} else return false;
	}
	public void tick(){
	}
	
	public void render(Graphics g){
		
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);
		
		if (game.gameState == Game.State.Menu) {
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Menu", 335, 70);
		
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawRect(160, 130,500, 64);
		g.drawString("Play", 355, 180);
		
		g.setColor(Color.white);
		g.drawRect(160, 250, 500, 64);
		g.drawString("Options", 335, 300);
		
		g.setColor(Color.white);
		g.drawRect(160, 400, 500, 64);
		g.drawString("Quit", 365, 450);
		
	} else if (game.gameState == Game.State.Options) {
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Options", 310, 70);
		
		g.setFont(fnt2);
		g.drawRect(160, 130,500, 64);
		g.drawString("Back", 360, 170);
	}
		
	}

}
