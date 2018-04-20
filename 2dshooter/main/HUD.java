package main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 760;
	
	private int score = 0;
	private int level = 1;
	
	public void tick(){
		HEALTH = Game.clamp(HEALTH, 0, 760);
		score++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 550, 760, 32);
		g.setColor(Color.green);
		g.fillRect(15, 550, HEALTH, 32);
		g.setColor(Color.white);
		g.drawRect(15, 550, 760, 32);
		
		g.drawString("score: " + score, 10, 35);
		g.drawString("level: " + level, 10, 45);
	}
	
	public int getScore(){
		return score;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
}
