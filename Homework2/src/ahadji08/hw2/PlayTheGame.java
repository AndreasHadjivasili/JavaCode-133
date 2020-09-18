package ahadji08.hw2;

/**
 * This is class that the user runs to play the game.
 * 
 * This class contains only one method, the main method that creates
 * a Game table to prepare the Game Settings and after it starts the 
 * game by running the move method from the class Gametable.
 * 
 * 
 * 
 *  @author Andreas Hadjivasili
 *  @since  11/2/19
 *  
 *
 */

public class PlayTheGame {

	
	/**
	 * This is the main method.
	 * 
	 * This method creates a Game table to prepare the Game 
	 * Settings as the user wants and after it starts the 
	 * game by running the move method from the class Gametable.
	 * 
	 * @param args    Is the default parameter that contains everything
	 * 				  that the user give as an input in the command line.
	 */
	
	public static void main(String[] args) {
		
		Gametable letspaly = new Gametable();
		letspaly.move();	

	}

}
