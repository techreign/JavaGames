package hanoi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hanoi extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// creating 3 stacks to represent the hangars of the game
	private Stacker stack1;	
	private Stacker stack2;
	private Stacker stack3;
	private int level;	// determines how many pieces there will be
	private int moves;	// keeps track of the number of moves used
	private int length, width;	// size of the screen
	private JLabel moveDisplay;
	private String moveString;
	private int t1, t2;	// used to check mouse clicks
	private Boolean drop = false;		

	
	// constructor
	public Hanoi(){
		level = 9;
		length = 600;
		width = 600;
		
		moveString = "Moves: " + moves;
		moveDisplay = new JLabel(moveString);
		moveDisplay.setSize(new Dimension(100, 100));
		setLayout(null);
		add(moveDisplay);
		addMouseListener(this);
		moveDisplay.setLocation(length/2 - 30, 100);
	
		setUp(level);
	}
	
	
	// starting the game
	public void setUp(int level){
		// populate the first stack with pieces of decreasing weight and length
		stack1 = new Stacker();
		for (int i = 0; i < level; i++){
			stack1.add(new Piece((level* 40) - (i * 20), (level * 40) - (i*20)));
		}
		stack2 = new Stacker();
		stack3 = new Stacker();
		moves = 0;
		repaint();
	}
	
	
	// performing a move
	public void doMove(int fromTower, int toTower){
				
		if (fromTower == toTower){
			return;
		}
		
		Stacker fromStack;
		Stacker toStack;
		
		// setting the clicked stacks to match the appropriate stack
		switch (fromTower){
			case 1: fromStack = stack1;
					break;
			case 2: fromStack = stack2;
					break;
			case 3: fromStack = stack3;
					break;
			default: fromStack = stack1;
		}
		
		switch (toTower) {
			case 1: toStack = stack1;
					break;
			case 2: toStack = stack2;
					break;
			case 3: toStack = stack3;
					break;
			default: toStack = stack3;
		}
		
		
		if (fromStack.isEmpty()){
			return;
		}
		
		if (toStack.isEmpty()){
			toStack.add(fromStack.pop());
			moves++;
			moveString = "Moves: " + moves;
			moveDisplay.setText(moveString);
		} else if 
		// check to see if the fromTower piece can be placed on to the toTower piece
		(fromStack.lastElement().lessThan(toStack.lastElement())){
			toStack.add(fromStack.pop());
			moves++;
			moveString = "Moves: " + moves;
			moveDisplay.setText(moveString);
			
		}
		
		// checks to see if the game is won
		if (checkWin()){
			System.out.println("You win!");
		}
		repaint();
		
	}
	
	
	// checking win condition all pieces stacked on the right hangar
	public Boolean checkWin(){
		Boolean win;
		int numItems = stack3.size();
		
		// if the third stack has all the pieces, the game is won
		// this is all that needs to be checked because the move method will only perform legal moves
		if (numItems == level){
			win = true;
		} else {
			win = false;
		}
		
		return win;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		// drawing the hangars
		g.setColor(Color.black);
		for (int i = 0; i < 3; i++){
			g.drawLine((length/6) + ( i * (length/3)), (width - 200), (length/6) + (i * (length/3)), width);
		}
		
		
		g.setColor(Color.red);
		
		int size1 = stack1.size();
		int size2 = stack2.size();
		int size3 = stack3.size();
		// first hangar
		for (int i = 0; i < size1; i++){
			g.fillRect((length/6 - (20 * level)) + (i * 10), (width - 38) - (i * 15), stack1.elementAt(i).getWeight(), 10);
		}
		// second hangar	
		for (int i = 0; i < size2; i++){
			g.fillRect((length/2 + 20 - (20 * level)) + (i * 10), (width - 38) - (i * 15), stack2.elementAt(i).getWeight(), 10);
		}
		// third hangar
		for (int i = 0; i < size3; i++){
			g.fillRect(((length - 80) - (20 * level)) + (i * 10), (width - 38) - (i * 15), stack3.elementAt(i).getWeight(), 10);
		}

		
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
	
		if (drop == false){
			if (x < length/3 && y > width/2){
				t1 = 1;
				drop = true;
			} else if (x > length/3 && x < (length * 0.66) && y > width/2 ){
				t1 = 2;
				drop = true;
			} else if (x > (length * 0.66) && y > width/2){
				t1 =3;
				drop = true;
			}
		} else {
			if (x < length/3 && y > width/2){
				t2 = 1;
				doMove(t1,t2);
				drop = false;
			} else if (x > length/3 && x < (length * 0.66) && y > width/2 ){
				t2 = 2;
				doMove(t1,t2);
				drop = false;
			} else if (x > (length * 0.66) && y > width/2){
				t2 =3;
				doMove(t1,t2);
				drop = false;
			}
		}
		
		
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
}
