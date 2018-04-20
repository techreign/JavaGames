package hanoi;

import java.util.Stack;

public class Stacker extends Stack<Piece> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// checks to see if the piece being added is smaller than the top piece
	public Boolean check(Piece toAdd){
		Boolean works = false;
		
		// if this stack is not empty
		if (!isEmpty()){
			if (toAdd.lessThan(lastElement())){
				works = true;
			} 
		}
		return works;
	}
	
	
	

}
