package ahadji08.hw3;
import java.util.Scanner;

/**
 * This is class that the user runs to play the game.
 * 
 * This class contains only one method, the main method that creates
 * a Game table to prepare the Game Settings and after it starts the 
 * game type that the user chose from the menu by running the method 
 * from the different classes that run the specific game type.
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
	 * This method takes from the user the choice of the game that he wants
	 * to play and based on the choice we call the class that is responsible
	 * for running the specific type of game.
	 * 
	 * 
	 * @param args    Is the default parameter that contains everything
	 * 				  that the user give as an input in the command line.
	 */
	
	public static void main(String[] args) {
		
		int choice;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Choose one of the below Game types by writting the number:");
		System.out.println();
		System.out.println("Game Types Menu:");
		System.out.println();
		System.out.println("1. Two Players");
		System.out.println("2. You playing as Devil");
		System.out.println("3. You playing as Angel");
		System.out.println("4. The Game is fully automated");
		
		System.out.println();
		System.out.print("You choose:");
	
		choice = sc.nextInt();
		System.out.println();
		
		while(!((choice == 1)||(choice == 2)||(choice == 3)||(choice == 4))) {
			
			System.out.println("Wrong Input, Please give a correct number");
			System.out.print("You choose:");
			choice = sc.nextInt();
			System.out.println();
		}
		
		
		if(choice == 1) {
			Gametable letsplay = new Gametable();
			letsplay.move();	
		}
		
		if(choice == 2) {
			UserDevil letsplay = new UserDevil();
			letsplay.gameplay();	
		}
		
		if(choice == 3) {
			UserAngel letsplay = new UserAngel();
			letsplay.gameplay();;	
		}
		
		if(choice == 4) {
			AutoPlay letsplay = new AutoPlay();
			letsplay.gameplay();;	
		}
		
		
		
		

	}

}
