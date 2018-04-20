package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import stats.GameObject;
import stats.ID;
import stats.Block;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] keyDown = new boolean[5];
	
	public KeyInput(Handler handler){
		this.handler = handler;
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		keyDown[4] = false;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++) {
			
			//GameObject tempObject = handler.object.get(i);
			
			if (handler.object.get(i).getId() == ID.Player) {
				
				if (key == KeyEvent.VK_RIGHT) {handler.object.get(i).setVelX(3); keyDown[0] = true;}
				if (key == KeyEvent.VK_LEFT) {handler.object.get(i).setVelX(-3); keyDown[1] = true;}
			}
		}
		if (Game.counter >= 5) {
			Game.counter = 0;
			keyDown[4] = false;
		}
		
		if (key == KeyEvent.VK_SPACE && keyDown[4] == false) {
			keyDown[4] = true;
			for (int i = 0; i < handler.object.size(); i++) {
				if (handler.object.get(i).getId() == ID.Player) {
					handler.addObject(new Block(handler.object.get(i).getX() + 8, handler.object.get(i).getY() + -25, ID.Neutral, 1));
				}
			}
		}
		
		if (key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
	
	}
	
	public void keyReleased(KeyEvent e){
		
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++) {
			
			if (handler.object.get(i).getId() == ID.Player) {
				
				if (key == KeyEvent.VK_RIGHT && keyDown[0] == true) {handler.object.get(i).setVelX(0); keyDown[0] = false;}
				if (key == KeyEvent.VK_LEFT && keyDown[1] == true) {handler.object.get(i).setVelX(0); keyDown[1] = false;}
				
				//horizontal movement
				if (!keyDown[0] && !keyDown[1]) {
					handler.object.get(i).setVelX(0);					
				}
			}
		}
		if (key == KeyEvent.VK_SPACE && Game.counter >= 5) {
			Game.counter = 0;
			keyDown[4] = true;
		}
	}

}
