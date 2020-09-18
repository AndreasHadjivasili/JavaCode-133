package ahadji08.hw3;

/**
 * This is the main class that plays the game that the user is playing as Angel
 * and the Devil moves are automated. 
 * 
 * In this class we have a constructor that creates the object UserAngel and its only prints
 * a reminder message because all the needed attributes are inherit from the class Gametable.
 * The method gameplay is the main method that connects all the game. This method is responsible
 * for taking from the user the coordinates for the square that he wants to move the Angel to and check
 * if this move is possible based on the rules and if is not ask for new coordinates. When the 
 * coordinates are correct the method check if we have a winner. For the Devil side we have automated
 * moves that are trying to close the Angel from escaping.
 *  
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 1/3/19
 * 
 *
 */


public class UserAngel extends Gametable{
	
	

	/**
	 * 
	 *  This is the only constructor with no parameters.
	 * 
	 * This constructor that creates the object UserAngel and its only prints
	 * a reminder message because all the needed attributes are inherit from the 
	 * SUPER class.
	 * 
	 */
	public UserAngel() {
		
		System.out.println("Reminder: You playing as Angel");
		System.out.println();
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
	 * these things if the angel did not won we are going forward for the devils move.
	 * In this stage is where the automation of the move come. Based on the Angel move
	 * we are trying to spot the edge that the user wants to achieve so the devil blocks
	 * square based on where the Angel move to. We are taking the Angels coordinates and
	 * we block the best possible square one row/column before the edge to start making 
	 * the blocking wall around the angel.
	 * 
	 * 
	 * 
	 */
	
	public void gameplay() {
		
		
		Print show = new Print(chessboard);
		Winner win = new Winner();
		Movecheck check = new Movecheck();
		
		

		
		while (true) {
			
			
			// Moving The Angel

			System.out.print(" x ?  Angel =  ");
			
			while(!sc.hasNextInt()) {
				String s;
				System.out.println("Give a Number");
				System.out.print(" x ?  Angel =   ");
				s = sc.next();
			}
			
			x2 = sc.nextInt();
			System.out.println();
			
			if(x2<0) {
				System.out.println("The Game Stops");
				System.exit(0);
			}

			System.out.print(" y ?  Angel =  ");
			
			while(!sc.hasNextInt()) {
				String s;
				System.out.println("Give a Number");
				System.out.print("y ?  Angel =   ");
				s = sc.next();
			}
			
			
			y2 = sc.nextInt();
			System.out.println();

			System.out.println("x = " + x2 + "   y = " + y2);
			

			x2 = x2 - 1; 
			y2 = y2 - 1; 
			

			while (!check.Angelcheck(this)) {

				System.out.print(" x ?  Angel =  ");
				
				while(!sc.hasNextInt()) {
					String s;
					System.out.println("Give a Number");
					System.out.print(" x ?  Angel =   ");
					s = sc.next();
				}
				
				x2 = sc.nextInt();
				System.out.println();
				
				if(x2<0) {
					System.exit(0);
				}

				System.out.print(" y ?  Angel =  ");
				
				while(!sc.hasNextInt()) {
					String s;
					System.out.println("Give a Number");
					System.out.print("y ?  Angel =   ");
					s = sc.next();
				}
				
				y2 = sc.nextInt();
				System.out.println();

				System.out.println("x = " + x2 + "   y = " + y2);

				x2 = x2 - 1;
				y2 = y2 - 1;

			}

			chessboard[x1][y1] = '+';

		
			chessboard[x2][y2] = 'A';

			show.show();
			
			win.angelWins(this);
			
			
			

			// Auto-Moving the Devil
			
			System.out.println("My Turn!");
			System.out.println();
			
			if((y1==y2)&&((x1-x2)>0)&&(chessboard[1][y2] != 'A')&&(chessboard[1][y2] != 'D')) {
				
				chessboard[1][y2] = 'D';
			}
			
			else if ((y1==y2)&&((x1-x2)<0)&&(chessboard[chessboard.length-2][y2] != 'A')&&(chessboard[chessboard.length-2][y2] != 'D')) {
				chessboard[chessboard.length-2][y2] = 'D';
				
			}
			
			else if ((x1==x2)&&((y1-y2)>0)&&(chessboard[x2][1] != 'A')&&(chessboard[x2][1] != 'D')) {
				
				chessboard[x2][1] = 'D';
			}
			
			else if ((x1==x2)&&((y1-y2)<0)&&(chessboard[x2][chessboard.length-2] != 'A')&&(chessboard[x2][chessboard.length-2] != 'D')) {
				
				chessboard[x2][chessboard.length-2] = 'D';
			}
			
			else if (((x1-x2)>0)&&((y1-y2)<0)&&(chessboard[1][y2] != 'A')&&(chessboard[1][y2] != 'D')) {
				chessboard[1][y2] = 'D';
			}
			
			else if (((x1-x2)>0)&&((y1-y2)>0)&&(chessboard[x2][1] != 'A')&&(chessboard[x2][1] != 'D')) {
				chessboard[x2][1] = 'D';
				
			}
			
			else if (((x1-x2)<0)&&((y1-y2)<0)&&(chessboard[x2][chessboard.length-2] != 'A')&&(chessboard[x2][chessboard.length-2] != 'D')) {
				chessboard[x2][chessboard.length-2] = 'D';
			}
			
			else if (((x1-x2)<0)&&((y1-y2)>0)&&(chessboard[chessboard.length-2][y2] != 'A')&&(chessboard[chessboard.length-2][y2] != 'D')) {
				chessboard[chessboard.length-2][y2] = 'D';
			}
			
			else chessboard[x2+1][y2+1] = 'D';
			
			x1 = x2;
			y1 = y2;

			show.show();
			win.DevilWins(this);
			
	}
		
		
		
	
		
	}
}
