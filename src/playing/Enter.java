package playing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Enter implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String text = MainPanel.getData().getText();
		//MainPanel.update(text);
		MainPanel.getData().setText("");

		// If not in a battle and user is asked, enters a battle 
		if (!Main.battle && Main.asked){
			if (text.equals("yes") || text.equals("y") || text.equals("Y") || text.equals("Yes")) {
				MainPanel.space();
				MainPanel.update("Entering battle...");
				MainPanel.getInfo().setForeground(Color.yellow);
				Main.battle = true;
			}
			else if (text.equals("no") || text.equals("No") || text.equals("n") || text.equals("N")){
				Main.run = false;
				System.exit(0);
			}
			else if (text.equals("stats")){
				MainPanel.update(Main.player.toString());
			}
		}
		
		if (Main.battle && Main.inBattle) {
			// if in the first battle screen
			if (Main.screen == 1) {
				// if the user presses 1 while in battle
				if (text.equals("1") || text.equalsIgnoreCase("battle")) {
					MainPanel.space();
					MainPanel.update(Main.currScreen.second());
					Main.screen = 2;
			  } else if (text.equals("2") || (text.equals("flee"))) {
					MainPanel.update("Ran away safely");
					MainPanel.space();
					MainPanel.getInfo().setForeground(Color.GRAY);
					Main.screen = 0;
					Main.asked = false;
					Main.battle = false;
					Main.inBattle = false;
				}
			}
			else if (Main.screen == 2){
				if (text.equals("0") || text.equalsIgnoreCase("back")) {
					Main.screen = 1;
					MainPanel.update(Main.currScreen.first());
				}
				else if (text.equals("1") || text.equals("punch")) {
					Main.player.attack1(10, Main.enemy);
					Main.screen = 1;
					MainPanel.update("You punch the robot for 10 damage.");
					MainPanel.space();
					MainPanel.update(Main.enemy.rep());
					Main.battleCheck();
					if (Main.enemy.getHp() != 0){
						MainPanel.update(Main.currScreen.first());
					}
				}
			}
		}
	}	

}
