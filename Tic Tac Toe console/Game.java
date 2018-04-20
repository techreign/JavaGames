package package1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


// Tic-Tac-Toe game using a 2d array
public class Game {
	
	private char[][] array = new char[4][4];
	private int[][] arrayInt = new int[4][4];
	private static boolean done = false;
	private static int wins = 0;
	private static int losses = 0;
	private static int draws = 0;
	private char player;
	private char enemy;
	private ArrayList<Integer> used = new ArrayList<Integer>();
	private Random r = new Random();
	private String positions = " " + 1 + " | " + 2 + " | " + 3 + "\n" 
			+ "-----------" + "\n"
			+ " " + 4 + " | " + 5 + " | " + 6 + "\n"
			+ "-----------" + "\n"
			+ " " + 7 + " | " + 8 + " | " + 9;
	private Scanner reader = new Scanner(System.in);
	
	public Game(){
		
		int randy = r.nextInt(2);
		if (randy == 1){
			player = 'X';
			enemy = 'O';
		} else {
			player = 'O';
			enemy = 'X';
		}
		// setting the character 2d array to all white spaces
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[i].length; j++){
				array[i][j] = ' ';
			}
		}
		// setting the int array to all 0's
		for (int i = 0; i < arrayInt.length; i++){
			for (int j = 0; j < arrayInt[i].length; j++){
				arrayInt[i][j] = 0;
			}
		}
	}
	
	public String showBoard(){
		return " " + array[0][0] + " | " + array[0][1] + " | " + array[0][2] + "\n" 
				+ "-----------" + "\n"
				+ " " + array[1][0] + " | " + array[1][1] + " | " + array[1][2] + "\n"
				+ "-----------" + "\n"
				+ " " + array[2][0] + " | " + array[2][1] + " | " + array[2][2];
	}
	
	public void play(){
		System.out.println("Where do you wish to place your symbol?");
		String pos = reader.next();
		while ( (Integer.valueOf(pos) != 1) && (Integer.valueOf(pos) != 2) && (Integer.valueOf(pos) != 3) && (Integer.valueOf(pos) != 4)
				&& (Integer.valueOf(pos) != 5) && (Integer.valueOf(pos) != 6) && (Integer.valueOf(pos) != 7) && (Integer.valueOf(pos) != 8)
				&& (Integer.valueOf(pos)!= 9) || (used.contains(Integer.valueOf(pos))) ) {
					System.out.println("Please enter a valid response.");
					pos = reader.next();
				}
		int pos2 = Integer.valueOf(pos);
		used.add(pos2);
		if (pos2 <= 3){
			array[0][pos2-1] = player;
			arrayInt[0][pos2-1] = 1;
		} else if (pos2 <= 6) {
			array[1][pos2-4] = player;
			arrayInt[1][pos2-4] = 1;
		} else {
			array[2][pos2-7] = player;
			arrayInt[2][pos2-7] = 1;
		}
		System.out.println("\n");
		System.out.println(showBoard());
	}
	
	public void playEnemy(){
		int enemyPos = r.nextInt(9) + 1;
		while ( used.contains(enemyPos) ){
			enemyPos = r.nextInt(9) + 1;
		} 
		used.add(enemyPos);
		if (enemyPos <= 3){
			array[0][enemyPos-1] = enemy;
			arrayInt[0][enemyPos-1] = -1;
		} else if (enemyPos <= 6) {
			array[1][enemyPos-4] = enemy;
			arrayInt[1][enemyPos-4] = -1;
		} else {
			array[2][enemyPos-7] = enemy;
			arrayInt[2][enemyPos-7] = -1;
		}
		System.out.println("\n");
		System.out.println(showBoard());
		
	} 
	
	public void evaluate(){
		// evaluating the horizontals
		arrayInt[0][3] = arrayInt[0][0] + arrayInt[0][1] + arrayInt[0][2];
		arrayInt[1][3] = arrayInt[1][0] + arrayInt[1][1] + arrayInt[1][2];
		arrayInt[2][3] = arrayInt[2][0] + arrayInt[2][1] + arrayInt[2][2];
		
		// evaluating the verticals
		arrayInt[3][0] = arrayInt[0][0] + arrayInt[1][0] + arrayInt[2][0];
		arrayInt[3][1] = arrayInt[0][1] + arrayInt[1][1] + arrayInt[2][1];
		arrayInt[3][2] = arrayInt[0][2] + arrayInt[1][2] + arrayInt[2][2];
		
		// evaluating the rightward diagonal
		arrayInt[3][3] = arrayInt[0][0] + arrayInt[1][1] + arrayInt[2][2];
	}
	
	public int gameWon(){
		// -1 means the game is still going, 0 means the game has been loss
		// 1 means the game has been drawn, and 2 means the game has been won
		int won = -1;
		evaluate();
		for (int[] items: arrayInt){
			for (int item : items){
				if (item == 3){
					won = 2;
				} else if (item == -3){
					won = 0;
				} 
			}
		}
		if (arrayInt[0][2] + arrayInt[1][1] + arrayInt[2][0] == 3){
			won = 2;
		} else if (arrayInt[0][2] + arrayInt[1][1] + arrayInt[2][0] == -3){
			won = 0;
		} else if (used.size() == 9){
			won = 1;
		}
		return won;
	}
	
	public void gameEnd(int result){
		if (result == 0) {
			losses++;
			done = true;
			System.out.println("You have lost!");
		} else if (result == 1){
			draws++;
			done = true;
			System.out.println("You have drawn.");
		} else if (result == 2){
			wins++;
			done = true;
			System.out.println("You win!");
		} 
	}
	
	public String showStats(){
		return "Wins: " + getWins() + " " + "Losses: " + getLosses() + " " + "Draws: " + getDraws();
	}



	public boolean playAgain(){
		boolean play = false;
		System.out.println("Do you wish to play again?");
		String again = reader.next();
		//while ( (!(again.toLowerCase().equals("yes"))) || (!(again.toLowerCase().equals("y"))) ||
				//(!(again.toLowerCase().equals("no"))) || (!(again.toLowerCase().equals("yes"))) ); {
				//	System.out.println("Please enter a valid response.");
					//again = reader.next();
				//}
		if ((again.toLowerCase().equals("yes")) || (again.toLowerCase().equals("y"))){
			play = true;
		}
		return play;
	}
	
	public String getPositions(){
		return positions;
	}
	
	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		Game.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		Game.losses = losses;
	}
	
	public void setDraws(int draws) {
		Game.draws = draws;
	}

	public int getDraws() {
		return draws;
	}
	
	public static void main (String[] arg){
		
		System.out.println("Welcome to Tic-Tac-Toe. \nYou will randomly be chosen to be either player X or player O.");
		System.out.println("When prompted, enter the position you wish to place your symbol, corresponding to the board below. \n");
		
		while (Game.done == false){
			Game game = new Game();
			System.out.println(game.getPositions() + "\n");
			System.out.println(game.showBoard());
			System.out.println("You are player " + game.player + ".");
			while (Game.done == false){
				if (game.player == 'X') {
					game.play();
					game.gameEnd(game.gameWon());
					if (Game.done == false){
						game.playEnemy();
						game.gameEnd(game.gameWon());
					}
				} else {
					game.playEnemy();
					game.gameEnd(game.gameWon());
					if (Game.done == false){
						game.play();
						game.gameEnd(game.gameWon());
					}
				}
			}
			System.out.println(game.showStats());
			if (game.playAgain()){
				Game.done = false;
			}
		}
		System.out.println("Thanks for playing!");
		}
}
