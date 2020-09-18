package ahadji08.hw3;

/**
 * This class is responsible for checking the correctness of the
 * coordinates that the user give us.
 * 
 * In this class there are two methods that both of them are about
 * checking the coordinates that user wants to move to the Angel 
 * or the Devil. In each case we are checking if the coordinates 
 * are correct and satisfy the rules-settings of the game.
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 11/2/19
 * 
 *
 */

public class Movecheck {
	
	
	
	
	private boolean compatible;
	
	
	
	/**
	 * This is the only constructor of the Movecheck object.
	 * 
	 * This constructor creates Movecheck objects that are basically
	 * a boolean statement that presents if the coordinates that we 
	 * took are correct or not.
	 * 
	 * 
	 */
	public Movecheck() {
		
		compatible = true;
		
	}
	
	
	
	/**
	 * This method is responsible for checking if the ANGEL coordinates are 
	 * correctly given.
	 * 
	 * 
	 * This method is checking the coordinates if they are correctly 
	 * given by checking 5 statements:
	 * if the coordinates are positive numbers.
	 * if the coordinates are in the board limit.
	 * if the Angel has the power to do this step.
	 * if the square is blocked by the devil.
	 * if the coordinates are your current position.
	 * 
	 * 
	 * @param w  This parameter is Gametable that is running and from
	 * 			 where we will take our information about the current
	 * 			 state of the game and decide if the coordinates are
	 * 			 compatible or not.
	 * 
	 * 
	 * @return 	It returns if the coordinates are compatible with the
	 * 			current state of the board.
	 * 
	 * 
	 */
	public boolean Angelcheck(Gametable w) {
		compatible = true;
		
		
		
		if (w.getx2() < 0 || w.gety2() < 0) {
			System.out.println(" The Game Stops");
			System.exit(1);
			compatible =  false;
			return compatible;
			

		}
		
		
		
		if (w.getx2() >= w.getboard().length || w.gety2() >= w.getboard().length) {
			System.out.println("Error: inaccessible square.");
			compatible =  false;
			return compatible;
			
		}
		
		

		if (Math.abs(w.getx2() - w.getx1()) > w.getpower() || Math.abs(w.gety2() - w.gety1()) > w.getpower()) {

			System.out.println("You dont have enough power to do this step");
			compatible =  false;
			return compatible;
			
		}



		if (w.getboard()[w.getx2()][w.gety2()] == 'D') {

			System.out.println("Error: inaccessible square , Devil blocks you");
			compatible =  false;
			return compatible;
		}
		
		


		return compatible;
		

	}
	
	
	
	
	
	/**
	 * This method is responsible for checking if the DEVIL coordinates are 
	 * correctly given.
	 * 
	 * 
	 * This method is checking the coordinates if they are correctly 
	 * given by checking 4 statements:
	 * if the coordinates are positive numbers.
	 * if the coordinates are in the board limit.
	 * if the square is taken by the Angel.
	 * if you block already this square.
	 * 
	 * 
	 * 
	 * @param w  This parameter is Gametable that is running and from
	 * 			 where we will take our information about the current
	 * 			 state of the game and decide if the coordinates are
	 * 			 compatible or not
	 * 
	 * 
	 * @return 	It returns if the coordinates are compatible with the
	 * 			current state of the board.
	 * 
	 * 
	 */
	
	
	public boolean Devilcheck(Gametable w) {

		compatible = true;
		
		
		if (w.getdevilx() < 0 || w.getdevily()< 0) {
			System.out.println(" The Game Stops");
			System.exit(1);
			compatible =  false;
			return compatible;

		}

		if (w.getdevilx() >= w.getboard().length || w.getdevily() >= w.getboard().length) {
			System.out.println("Error: inaccessible square.");
			compatible =  false;
			return compatible;
		}

		if (w.getboard()[w.getdevilx()][w.getdevily()] == 'A') {

			System.out.println("Error: inaccessible square.");
			compatible =  false;
			return compatible;
		}
		
		if (w.getboard()[w.getdevilx()][w.getdevily()] == 'D') {

			System.out.println("Error: You already block this square");
			compatible =  false;
			return compatible;
		}

		return compatible;

	}

}
