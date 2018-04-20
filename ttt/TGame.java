package ttt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TGame extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Boolean playing = false;	// shows whether the game is being played or not
	
	private int[][] board;	// a 3x3 array that will be used to represent the board
	private int X = -1; private int O = 1;	// using integers to represent X and Y
	private int EMPTY = 0;	// an empty board will be represented by a 0
	private int turn = X;	// stores the player's turn (X always starts)
	
	// constructor
	public TGame(){
		setLayout(null);
		setUp();
		addMouseListener(this);
	}
	
	// sets the board to empty at all squares
	public void setUp(){
		board = new int [3][3];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				board[i][j] = EMPTY;
			}
		}
		playing = true;
		turn = X;
			
	}
	
	// pop-out window asking user wants to play again
	public void playAgain(int num){
		
		String won;
		if (num == 1){
			won = "X has won. Do you wish to play again?";
		} else if (num == -1){
			won = "O has won. Do you wish to play again?";
		} else {
			won = "TIE GAME, play again?";
		}
		
		//default icon, custom title
		int n = JOptionPane.showConfirmDialog(
		    this,
		    won,
		    "Tic-Tac-Toe",
		    JOptionPane.YES_NO_OPTION);

		if (n == JOptionPane.YES_OPTION){
			setUp();
			repaint();
		} else if (n == JOptionPane.NO_OPTION){
			System.exit(1);
		}
		

	}
	
	
	// checks to see if a player has won, returns 0 if no player has won
	public int checkWin(){
		
		int numEmpty = 1;
		
		// 1 for loop for horizontal wins and another for verticals
		for (int i = 0; i < 3; i++){
			// horizontal
			if ((board[i][0] + board[i][1] + board[i][2]) == -3){
				// X wins
				return 1;
				
			}
			if ((board[i][0] + board[i][1] + board[i][2]) == 3){
				// O wins
				return -1;
			}
			
			// vertical
			if ((board[0][i] + board[1][i] + board[2][i]) == -3){
				// X wins
				return 1;
			}
			if ((board[0][i] + board[1][i] + board[2][i]) == 3){
				// O wins
				return -1;
			}
				
		}
		
		// check both diagonals
		if (board[0][0] + board[1][1] + board[2][2] == -3){
			// X wins
			return 1;
		}
		if (board[0][0] + board[1][1] + board[2][2] == 3){
			// O wins
			return -1;
		}
		
		if (board[2][0] + board[1][1] + board[0][2] == -3){
			// X wins
			return 1;
		}
		
		if (board[2][0] + board[1][1] + board[0][2] == 3){
			// O wins
			return -1;
		}
		
		
		// checking for tie
		for (int i1 = 0; i1 < 3; i1++){
			for (int j = 0; j < 3; j++){
				if (board[i1][j] == EMPTY){
					numEmpty++;
				}
			}
		}
		
		if (numEmpty == 0){
			// draw
			return -99;
		}
		
		return 0;
	}
	
	// updates the board depending on where the user clicked	
	public void updateMove(int x, int y){
		boolean moved = false;
		if (turn == X && board[x][y] == EMPTY){
			board[x][y] = X;
			moved = true;
		} else if (turn == O && board[x][y] == EMPTY){
			board[x][y] = O;
			moved = true;
		}
		repaint();
		
		// check if anyone won this turn
		if (checkWin() != 0){
			playAgain(checkWin());
		}
		
		if (moved){
			if (turn == X){
				turn = O;
			} else {
				turn = X;
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.black);
		for (int i = 0; i < 2; i++){
			// vertical lines
			g.drawLine(200 + (i * 200), 0, 200 + (i * 200), 600);
			// horizontal lines
			g.drawLine(0, 200 + (i * 200), 600, 200 +(i * 200));
		}
		
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (board[i][j] == O){
					// drawing the O's
					g.setColor(Color.blue);
					g.drawOval(50 + (j * 200), 50 + (i * 200), 100, 100);
				}
				if (board[i][j] == X){
					// drawing the X's
					g.setColor(Color.RED);
					g.drawLine(30 + (j * 200), 30 + (i * 200 ), (30 + (j * 200) + 130),( 30 + (i * 200 ) + 120 ));
					g.drawLine((30 + (j * 200) + 130), 30 + (i * 200 ), 30 + (j * 200), ( 30 + (i * 200 ) + 120 ));
				}
			}
		}
		
	
	}

	
	// if the user clicks a square
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		int xCord = arg0.getX();
		int yCord = arg0.getY();
		
		// corresponding to the board
		int x1 = -1;
		int y1 = -1;
		
		// find out what box was clicked
			
		if (xCord < 200){
			y1 = 0;
		} else if (xCord < 400){
			y1 = 1;
		} else if (xCord < 600){
			y1 = 2;
		}
		
		if (yCord <200){
			x1 = 0;
		} else if (yCord < 400){
			x1 = 1;
		} else if (yCord < 600){
			x1 = 2;
		}
		if (x1 != -1 && y1 != -1){
			updateMove(x1, y1);
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {	
	}

	@Override
	public void mousePressed(MouseEvent arg0) {		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {	
	}
	
	
	
}
