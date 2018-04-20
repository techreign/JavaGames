package playing;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 *  The main window for the game.
	 */
	
	private static final long serialVersionUID = 1L;
	MainPanel panel = new MainPanel();
	
	public MainFrame() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(800, 600);
		setTitle("ROBOTS");
		add(panel);
		setVisible(true);

	}

}
