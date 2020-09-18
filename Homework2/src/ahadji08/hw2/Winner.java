package ahadji08.hw2;


/**
 * This class is responsible for checking if we have a winner!
 * 
 * In this class there are two methods that both of them are about
 * checking if one of the characters is the winner. In each case 
 * we run over the winning rules for each hero and check if its
 * compatible we the winning statements. Finally if we have a
 * winner we call the toString method of our winner object to 
 * print out the results. 
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 11/2/19
 * 
 *
 */


public class Winner {
	
	
	private String WinnerName;
	private boolean win;
	
	
	
	
	/**
	 * This is the only constructor of the Winner object.
	 * 
	 * This constructor creates Winner objects that are basically
	 * a boolean statement that presents if we have a winner and
	 * a String that presents the winner game.
	 * 
	 * 
	 */
	
	public Winner() {
		
		win = false;
		WinnerName = "Angel";
		
	}
	
	
	
	/**
	 * This is the method that check if angel is the winner.
	 * 
	 * In this method we have an if statement that it checks the only 
	 * way that the angel can win the game if its current position
	 * is a square on the edge of the chess board. If this is correct
	 * we have a winner so we stop the game and we print out the winner. 
	 * 
	 * 
	 * 
	 * @param w  This parameter is Gametable that is running and from
	 * 			 where we will take our information about the current
	 * 			 state of the game and decide if the coordinates are
	 * 			 compatible or not.
	 * 
	 */
	
	public void angelWins(Gametable w) {

		if (((w.getx2() == 0) || (w.getx2() == w.getboard().length - 1)) || ((w.gety2() == 0) || (w.gety2() == w.getboard().length - 1))) {
			
			win = true;
			System.out.println(this);
			System.exit(1);
		}
	}
	
	
	
	/**
	 * This is the method that check if Devil is the winner.
	 * 
	 * 
	 * In this method we have two if statements that checks the two
	 * ways that the devil can win the game:
	 *   First, if all the squares that are on the edge of the chess 
	 * board are taken by the devil then it won.
	 *   Second, The demon wins if he encircles the Angel with a ditch 
	 * of blocked squares of at least the power of the angel. 
	 * If one of this is correct we have a winner so we stop the game
	 * and we print out the winner. 
	 * 
	 * 
	 * 
	 * @param w  This parameter is Gametable that is running and from
	 * 			 where we will take our information about the current
	 * 			 state of the game and decide if the coordinates are
	 * 			 compatible or not.
	 * 
	 */
	
	public void DevilWins(Gametable w) {
		boolean flag = true;
		boolean Wins = true;
		

		for (int i = 0; i < w.getboard().length; i++) {

			if (!( w.getboard()[0][i] == 'D' &&  w.getboard()[ w.getboard().length - 1][i] == 'D'
					&&  w.getboard()[i][ w.getboard().length - 1] == 'D' &&  w.getboard()[i][0] == 'D')) {

				flag = false;

			}
		}

		for (int i = 0; i <  w.getboard().length; i++) {
			for (int j = 0; j <  w.getboard().length; j++) {

				if (Math.abs(i - w.getx2()) <= w.getpower() && Math.abs(j - w.gety2()) <= w.getpower() &&  w.getboard()[i][j] == '+') {
					Wins = false;
				}
			}
		}

		if (flag || Wins) {
			win = true;
			WinnerName = "Devil";
			System.out.println(this);
			System.exit(1);
		}

		flag = true;
		Wins = true;

	}

	
	
	/* 
	 * This is the toString method for the Winner object that 
	 * its called when we have a winner to print out the winner.
	 * 
	 * @see java.lang.Object#toString()
	 */
	
	
	public String toString() {
		
		return(WinnerName +" Wins.  \nEnd of the Game");
	}
}
