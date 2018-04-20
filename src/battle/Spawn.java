package battle;


import characters.*;


public class Spawn {
	
	public Robot SpawnRobot() {
		String[] soft = {"v1"};
		Robot enemyRobot = new Robot("Robot1", 50, 50, "117", soft);
		return enemyRobot;
	}
	
	public Nanobot SpawnNanobot() {
		String[] soft = {"v1"};
		Nanobot enemyRobot = new Nanobot("Robot1", 50, 50, "117", soft, 0);
		return enemyRobot;
	}

}
