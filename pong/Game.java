package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int length, height;
	private Boolean play;
	private int playerX, playerY, playerWidth, playerHeight;
	private int enemyX, enemyY, enemyWidth, enemyHeight;
	private int ballX, ballY, ballWidth, ballHeight, ballDirX, ballDirY, ballSpeed;
	private Timer timer;
	private int playerScore, enemyScore;
	
	public Game() {
	
		 
		setLength(600); setHeigh(600);
		playerScore = 0;
		enemyScore = 0;
		
		playerX = length/100;
		playerY =  height/2;
		playerWidth = 5; 
		playerHeight = 50;
		
		enemyX = length - 20;
		enemyY = height/2;
		enemyWidth = playerWidth;
		enemyHeight = playerHeight;
		
		ballX =  length/2;
		ballY = height/2;
		ballWidth = 15;
		ballHeight = 15;
		ballSpeed = 5;
		ballDirX = -1;
		ballDirY = -1;
		
		play = true;
		
		addKeyListener(this);
		timer = new Timer(ballSpeed, this);
		timer.start();
		setBackground(Color.BLACK);
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		// line across the centre of the game
		g.setColor(Color.white);
		for (int i = 0; i < 12; i++){
			g.drawLine(length/2, (i * 50), length/2, 20 + (i*50));
		}
		
		// the player's paddle
		g.fillRect(playerX, playerY, playerWidth, playerHeight);
		
		// the enemy's paddle
		g.fillRect(enemyX, enemyY, enemyWidth, enemyHeight);
		
		// the ball
		g.fillOval(ballX, ballY, ballWidth, ballHeight);
		
		// drawing the score
		g.setFont(new Font("Serif", Font.BOLD, 15));
		g.drawString("Score: " + playerScore + " - " + enemyScore, 500, 30);
		
	}
	
	public void moveUp() {
		
		if (playerY >= 5){
			playerY -= 10;
		}
		
	}
	
	public void moveDown() {
		
		if ( playerY <= height - playerHeight - 22){
			playerY += 10;
		}
		
	}
	
	public void enemyMove(){
		
		if (ballY > enemyY){
			enemyY += 1;
		} else if (ballY < enemyY){
			enemyY -= 1;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		timer.start();
		
		if (play) {
			
			enemyMove();
			
			if (ballY < height && ballY > 0 ) {
				ballY += ballDirY;
			} else if (ballY >= height - ballHeight - 22 || ballY <= 0) {
				ballDirY = -ballDirY;
				ballY += ballDirY;
			}
			
			if (ballX < height && ballX > 0 ) {
				ballX += ballDirX;
			} else if (ballX >= length) {
				playerScore++;
				ballX = height/2; ballY = length/2;
			}  else if (ballX <= 0) {
				enemyScore++;
				ballX = height/2; ballY = length/2;
			}
			
			
			// collision with the player paddle using Rectangle objects
			Rectangle ballRect = new Rectangle(ballX, ballY, ballHeight, ballWidth);
			Rectangle enemyRect = new Rectangle(enemyX, enemyY, enemyHeight, enemyWidth);
			Rectangle playerRect = new Rectangle(playerX, playerY, playerHeight, playerWidth);
			
			if (ballRect.intersects(playerRect) || ballRect.intersects(enemyRect)){
				ballDirX = -ballDirX;
				ballX += ballDirX;
			}
			
			
			
			
			repaint();			
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (play) {
			int code = e.getKeyCode();
			
			// user can move the paddle up or down
			if (code == KeyEvent.VK_W) {
				moveUp();
			}
			if (code == KeyEvent.VK_S) {
				moveDown();
			}
		}
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeigh() {
		return height;
	}

	public void setHeigh(int height) {
		this.height = height;
	}

	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	
	

}
