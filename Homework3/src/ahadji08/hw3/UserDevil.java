package ahadji08.hw3;


/**
 * This is the main class that plays the game that the user is playing as Devil
 * and the Angel moves are automated. 
 * 
 * In this class we have a constructor that creates the object UserAngel and its only prints
 * a reminder message because all the needed attributes are inherit from the class Gametable.
 * The method gameplay is the main method that connects all the game. This method is responsible
 * for taking from the user the coordinates for the square that he wants to move the Devil to and check
 * if this move is possible based on the rules and if is not ask for new coordinates. When the 
 * coordinates are correct the method check if we have a winner. For the Angel side we have automated
 * moves that are trying to escape from Devil blocked squares.
 * 
 *  
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 1/3/19
 * 
 *
 */


public class UserDevil extends Gametable {
	
	
	/**
	 * 
	 *  This is the only constructor with no parameters.
	 * 
	 * This constructor that creates the object UserDevil and its only prints
	 * a reminder message because all the needed attributes are inherit from the 
	 * SUPER class.
	 * 
	 */
	
	public UserDevil() {
		
		System.out.println("Reminder: You playing as Devil");
		System.out.println();
	}
	
	
	
	/**
	 * This method is responsible for running the game, checking the user inputs
	 * and finding the winner(using other classes)
	 * 
	 * 
	 * The current method starts running when the Game table is ready. Firstly, it
	 * creates 3 new objects that are the connections for the other classes that we 
	 * use later. Later on, we have the first move that it comes from the Angel side,
	 * the automated side. The logic behind the Angel moves is simple. Angel is trying 
	 * to find the square that it can move to firstly and later on it checks which of the 
	 * possible move is closest to the edge and its not blocked by devil.
	 * After this is the Devils turn where the user has to give us the coordinates that he wants
	 * to move to and check them if they are compatible with the board that we are playing on.
	 * If its compatible we do the move and we check if we have a winner.
	 * 
	 * 
	 * 
	 */
	public void gameplay() {
		
		Print show = new Print(chessboard);
		Winner win = new Winner();
		Movecheck check = new Movecheck();
		
		

		
		while (true) {
			
			int min = chessboard.length;
			int minx=0 , miny=0;
			
			
			// Moving The Angel
		
			for (int i = 0; i < chessboard.length; i++) {
				for (int j = 0; j < chessboard.length; j++) {

					if (Math.abs(i - x1) <=power && Math.abs(j - y1) <=power && chessboard[i][j] == '+') {
						if( (chessboard.length-i)<= min) {
							minx = i;
							miny = j;
							
						}
					}
				}
			}

			x2 = minx;
			y2 = miny;
			
			chessboard[x1][y1] = '+';

			x1 = x2;
			y1 = y2;

			chessboard[x1][y1] = 'A';
			
			show.show();
			
			win.angelWins(this);

			
			
			
			// ----------------------------------------------------------------------------------
		
					//Moving The Devil
					
					

					System.out.print(" x ?  Devil =  ");
					
					while(!sc.hasNextInt()) {
						String s;
						System.out.println("Give a Number");
						System.out.print(" x ?  Devil =  ");
						s = sc.next();
					}
					
					devilx = sc.nextInt();
					System.out.println();
					
					
					if(x2<0) {
						System.out.println("The Game Stops");
						System.exit(0);
					}

					System.out.print(" y ?  Devil =  ");
					
					while(!sc.hasNextInt()) {
						String s;
						System.out.println("Give a Number");
						System.out.print("y ?  Devil =  ");
						s = sc.next();
					}
					
					
					devily = sc.nextInt();
					System.out.println();

					System.out.println("x = " + devilx + "   y = " + devily);

					devilx = devilx - 1; 
					devily = devily - 1; 
					

					while (!check.Devilcheck(this)) {

						System.out.print(" x ?  Devil =  ");
						
						while(!sc.hasNextInt()) {
							String s;
							System.out.println("Give a Number");
							System.out.print(" x ?  Devil =  ");
							s = sc.next();
						}
						
						devilx = sc.nextInt();
						System.out.println();
						
						if(x2<0) {
							System.out.println("The Game Stops");
							System.exit(0);
						}

						System.out.print(" y ?  Devil =  ");
						
						while(!sc.hasNextInt()) {
							String s;
							System.out.println("Give a Number");
							System.out.print("y ?  Devil =  ");
							s = sc.next();
						}
						
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
}
