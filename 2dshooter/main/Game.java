package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import stats.Enemy;
import stats.GameObject;
import stats.Character;
import stats.ID;

public class Game extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private Boolean running = false;
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	
	private Handler handler;
	//private Random r;
	private HUD hud;
	private Spawn spawn;
	public static int counter = 0;
	private Menu menu;
	
	public enum State {
		Menu,
		Options,
		Game;
	}
	
	public State gameState = State.Menu;

	public Game() {
		
		handler = new Handler();
		hud = new HUD();
		spawn = new Spawn(handler, hud);
		menu = new Menu(this, handler);
		
		this.addMouseListener(menu);
		this.addKeyListener(new KeyInput(handler));
		
		MainFrame main = new MainFrame(WIDTH, HEIGHT, this);

	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
		    delta += (now - lastTime) / ns;
		    lastTime = now;
		    while(delta >=1) {
		    	tick();
		        delta--;
		    }
		    if(running)
		    	render();
		    frames++;
		                            
		    if(System.currentTimeMillis() - timer > 1000) {
		           timer += 1000;
		           //System.out.println("FPS: "+ frames);
		           frames = 0;
		     }
		}
	stop();
	}
	
	private void tick() {
		handler.tick();
		
		if (gameState == State.Game) {
			hud.tick();
			spawn.tick();
			counter++;
		
			for (int i = 0; i < handler.object.size(); i++) {
			
				if (handler.object.get(i).getId() == ID.Neutral && (handler.object.get(i).getVelY() == 0 || handler.object.get(i).getVelY() == Game.HEIGHT)) {
				handler.removeObject(handler.object.get(i));
				}
			}
		} else {
			menu.tick();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH, HEIGHT);
		
		handler.render(g);
		if (gameState == State.Game) {
			hud.render(g);
		} else {
			menu.render(g);
		}
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min){
			return var = min;
		} else {
			return var;
		}
	}
	
	public static void main(String[] args) {
		new Game();
	}

}
