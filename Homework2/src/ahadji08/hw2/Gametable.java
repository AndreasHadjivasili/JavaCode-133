
package ahadji08.hw2;

import java.util.Scanner;

/**
 * This is the main class that creates the most important object of the game and
 * it contains the method that runs all the game.
 * 
 * In this class we have a constructor that creates the object Gametable it organize
 * the game by taking the necessary information from the user to create the board and 
 * find the starting square of the angel. Finally in prints out the starting image of
 * the board. 
 * The method move is the main method that connects all the game. This method is responsible
 * for taking from the user the coordinates for the square that he wants to move to and check
 * if this move is possible based on the rules and if is not ask for new coordinates. When the 
 * coordinates are correct the method check if we have a winner. The same logic it continues 
 * after with the devil.
 * At the end we have some getters (get methods) for the other classes.
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 11/2/19
 * 
 *
 */

public class Gametable {

	
	
	
	private char[][] chessboard;
	private int power;
	private int x1, y1, x2, y2, devilx, devily;
	Scanner sc = new Scanner(System.in);

	
	
	
	
	
	/**
	 * 
	 * This is the only constructor with no parameters.
	 * 
	 * This constructor creates the object Gametable that has all the valuable information
	 * (variables) for the game to run. The constructor is taking the 
	 * from the user the board size and the power of the angel to create the board and 
	 * find the starting square of the angel. Finally, when it creates the Gametable and we are
	 * ready to start the game it prints out a String to inform the user that the game starts
	 * and the starting image ofthe board. 
	 * 
	 * 
	 * 
	 */
	
	
	public Gametable() {
		
		int n;

		System.out.println("The Angel Game.");
		System.out.print("Size of the board?  ");

		n = sc.nextInt();
		System.out.println();
		
		while(n<3) {
			System.out.print("Wrong size, Give  a new one at least 3");
			System.out.println();
			n = sc.nextInt();
		}

		System.out.print("Power of Angel?  ");
		power = sc.nextInt();
		System.out.println();
		
		
		while((power<0)||(power>n)) {
			
			if((power<0)) {
			System.out.print("Wrong power, give a positive");
			System.out.println();
			power = sc.nextInt();
			}
			
			if((power>n)) {
				System.out.print("Wrong power, give a power between zero and size of the board");
				System.out.println();
				power = sc.nextInt();
			}
		}
		
		
		
		System.out.println("Begin the game");

		chessboard = new char[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				chessboard[i][j] = '+';
		
		
		
		if((n/2)!=0) {
		x1 = Math.round(n / 2);
		y1 = Math.round(n / 2);}
		
		else {
			
			x1 = Math.round(n / 2) +1;
			y1 = Math.round(n / 2) +1 ; }
			
		
		

		chessboard[x1][y1] = 'A';

		Print start = new Print(chessboard);
		start.show();

	}

	
	
	
	
	
	/**
	 * This method is responsible for running the game, checking the user inputs
	 * and finding the winner(using other classes)
	 * 
	 * 
	 * The current method starts running when the Game table is ready. Firstly, it
	 * creates 3 new objects that are the connections for the other classes that we 
	 * use later. Later on, it starts by asking the user the first step of the angel.
	 * After taking the coordinates it calls the method Angel Check from the class 
	 * Move check to check if the coordinates that we took is compatible with the 
	 * state of the board. If the coordinates are not correct we asking for new correct
	 * ones. As we took the correct coordinates we move forward calling the method
	 * angel wins from the class Winner to check if angel wins. After we finish with 
	 * these things if the angel did not won we are going forward for the devils move
	 * where we are repeating the same process but using the methods that are for the
	 * devils movement.
	 * 
	 * 
	 * 
	 */
	
	public void move() {

		
		Print show = new Print(chessboard);
		Winner win = new Winner();
		Movecheck check = new Movecheck();
		
		

		
		while (true) {
			
			
			// Moving The Angel

			System.out.print(" x ?  Angel =  ");
			x2 = sc.nextInt();
			System.out.println();

			System.out.print(" y ?  Angel =  ");
			y2 = sc.nextInt();
			System.out.println();

			System.out.println("x = " + x2 + "   y = " + y2);
			

			x2 = x2 - 1; 
			y2 = y2 - 1; 
			

			while (!check.Angelcheck(this)) {

				System.out.print(" x ?  Angel =  ");
				x2 = sc.nextInt();
				System.out.println();

				System.out.print(" y ?  Angel =  ");
				y2 = sc.nextInt();
				System.out.println();

				System.out.println("x = " + x2 + "   y = " + y2);

				x2 = x2 - 1;
				y2 = y2 - 1;

			}

			chessboard[x1][y1] = '+';

			x1 = x2;
			y1 = y2;

			chessboard[x1][y1] = 'A';

			show.show();
			
			win.angelWins(this);

			

			// ----------------------------------------------------------------------------------
			
			//Moving The Devil
			
			

			System.out.print(" x ?  Devil =  ");
			devilx = sc.nextInt();
			System.out.println();

			System.out.print(" y ?  Devil =  ");
			devily = sc.nextInt();
			System.out.println();

			System.out.println("x = " + devilx + "   y = " + devily);

			devilx = devilx - 1; 
			devily = devily - 1; 
			

			while (!check.Devilcheck(this)) {

				System.out.print(" x ?  Devil =  ");
				devilx = sc.nextInt();
				System.out.println();

				System.out.print(" y ?  Devil =  ");
				devily = sc.nextInt();
				System.out.println();

				System.out.println("x = " + devilx + "   y = " + devily);

				devilx = devilx - 1;
				devily = devily - 1;

			}

			chessboard[devilx][devily] = 'D';
			

			show.show();
			win.DevilWins(this);

		}

	}


	
	/**
	 * This is a getter method that returns the x1 coordinate
	 * 
	 * @return x1 The current coordinate of the angel
	 * 
	 */
	public int getx1() {
		return x1;
		
	}
	
	
	
	
	
	/**
	 * This is a getter method that returns the y1 coordinate
	 * 
	 * @return y1 The current coordinate of the angel
	 * 
	 */
	public int gety1() {
		return y1;
		
	}
	
	
	/**
	 * This is a getter method that returns the x1 coordinate
	 * 
	 * @return x2 The new coordinate of the angel
	 * 
	 */
	public int getx2() {
		return x2;
		
	}
	
	
	
	/**
	 * This is a getter method that returns the y2 coordinate
	 * 
	 * @return y2 The new coordinate of the angel
	 * 
	 */
	
	public int gety2() {
		return y2;
		
	}
	
	
	
	/**
	 * This is a getter method that returns the devilx coordinate
	 * 
	 * @return devilx  The current coordinate of the devil
	 * 
	 */
	
	public int getdevilx() {
		return devilx;
		
	}
	
	
	
	
	/**
	 * This is a getter method that returns the devily coordinate
	 * 
	 * @return devily  The current coordinate of the devil
	 * 
	 */
	
	public int getdevily() {
		return devily;
		
	}
	
	
	
	
	/**
	 * This is a getter method that returns the table chessboard
	 * 
	 * @return chessboard  The array that represent the chess board
	 * 
	 */
	
	public char[][] getboard() {
		return chessboard;
		
	}
	
	
	
	/**
	 * This is a getter method that returns the power of the angel.
	 * 
	 * @return power   The power of the angel.
	 * 
	 */
	
	public int getpower() {
		return power;
		
	}
	
		
	
	
	

}
