package playing;

import java.awt.Color;

import battle.Screen;
import battle.Spawn;
import characters.Nanobot;
import characters.Robot;


public class Main {
	
	public static boolean battle = false;
	public static boolean inBattle = false;
	public static boolean asked = false;
	public static boolean run = true;
	public static int screen = 0;
	public static Screen currScreen;
	public static Robot enemy;
	public static Robot player;
	
	public Main() {
		
		String[] softwares = new String[1];
		softwares[0] = "v1";
		player = new Robot("Atlas", 100, 100, "01", softwares);
		Nanobot Littlewig = new Nanobot("Littlewig", 10, 25, "001", softwares, 10);
		Nanobot Littlekig = new Nanobot("Littlekig", 10, 25, "002", softwares, 10);
	}
	
	
	public void ask(){
		asked = true;
		if (!battle){
			MainPanel.space();
			MainPanel.update("Do you wish to battle? (Y/N)");
		}
	}
	
	public void battleSequence() {
		inBattle = true;
		spawn();
		MainPanel.update(enemy.toString());
	}
	
	// spawns an enemy
	public void spawn() {
		Spawn spawn = new Spawn();
		enemy = spawn.SpawnRobot();
	}
	
	// displays the first battle screen
	public void battleBegin() {
		MainPanel.space();
		currScreen = new Screen();
		MainPanel.update(currScreen.first());
		screen = 1;
	}
	
	public static void battleCheck() {
		if (enemy.getHp() == 0){
			MainPanel.update("You beat " + enemy.getName());
			battle = false;
			inBattle = false;
			asked = false;
			screen = 0;
			player.increaseExp(50.0);
			MainPanel.getInfo().setForeground(Color.GRAY);
		}
	}
	
	public static void main(String[] args){
		
		// Preliminaries
		Main main = new Main();
		MainFrame window = new MainFrame();
		
		MainPanel.update(player.toString());
		
		// Game loop
		while (run == true){
			
			if (!Main.asked){
				main.ask();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (Main.battle && !Main.inBattle){
				main.battleSequence();
				main.battleBegin();
			}
		}
		
	}

}
