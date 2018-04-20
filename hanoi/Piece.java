package hanoi;

import java.awt.Color;

import java.awt.Color;

public class Piece {
	
	private int weight;		// for game purpose
	private int length;		// for animation purposes
	private Color colour;	// for animation purposes
	
	// constructor
	public Piece(int weight, int length){
		this.weight = weight;
		this.length = length;
	}
	
	// checks to see if this piece is smaller than another piece in terms of weight
	public Boolean lessThan(Piece other){
		Boolean smaller;
		if (weight < other.weight){
			smaller = true;
		} else{
			smaller = false;
		}
		return smaller;
	}
	
	public void setColour(Color colour){
		this.colour = colour;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public int getLength(){
		return length;
	}
	
	
	
}
