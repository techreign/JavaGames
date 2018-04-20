package hanoi;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Launcher extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Hanoi hanoi;
	
	// constructor
	public Launcher(){
		super("Towers of Hanoi");
		hanoi = new Hanoi();
		
		setLayout(new BorderLayout());
		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		add(hanoi, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	
	public static void main(String args[]){
		Launcher launcher = new Launcher();
	}
	
}
