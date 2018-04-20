package main;

import java.util.Random;

import stats.Enemy;
import stats.ID;
import stats.SmartEnemy;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r = new Random();
	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick(){
		scoreKeep++;
		
		if (scoreKeep > 100){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel()+1);
			
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) +30, ID.Enemy, 1, handler));
		}
		
	}
	

}
