package pong;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Launcher extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game game;
	
	public Launcher(){
		super("Pong");
		
		game = new Game();
		setSize(game.getLength(), game.getHeigh());
		setResizable(false);
		setLayout(new BorderLayout());
		add(game, BorderLayout.CENTER);
		addKeyListener(game);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]) {
		Launcher launcher = new Launcher();
	}
	
}
