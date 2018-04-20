package ttt;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TLauncher extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TGame tgame = new TGame();
	

	public TLauncher(){
		super("Tic-Tac-Toe");
		
		setLayout(new BorderLayout());
		add(tgame, BorderLayout.CENTER);
		setSize(600,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String args[]){
		TLauncher tlauncher = new TLauncher();
	}

}
