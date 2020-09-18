package ahadji08.hw3;

/**
 * This is the main class that plays the game that the Angel
 * and the Devil moves are automated. 
 * 
 * In this class we have a constructor that creates the object AutoPlay and its only prints
 * a reminder message because all the needed attributes are inherit from the class Gametable.
 * The method gameplay is the main method that connects all the game. This method is responsible
 * for moving both of our characters because they are both automated in this game type.
 * Later on, we have the first move that it comes from the Angel side, that is trying to 
 * escape with automated moves. For the Devil side we have automated moves that are trying
 * to close the Angel from escaping. 
 * 
 *  
 * @author Andreas Hadjivasili
 * @since 1/3/19
 * 
 *
 */

public class AutoPlay extends Gametable {

	
	/**
	 * 
	 *  This is the only constructor with no parameters.
	 * 
	 * This constructor that creates the object UserAngel and its only prints
	 * a reminder message because all the needed attributes are inherit from the 
	 * SUPER class.
	 * 
	 */
	
	public AutoPlay() {

		System.out.println("Reminder: The game is fully automated");
		System.out.println();
	}
	
	
	/**
	 * This method is responsible for running the game
	 * and finding the winner(using other classes)
	 * 
	 * 
	 * The current method starts running when the Game table is ready. Firstly, it
	 * creates two new objects that are the connections for the other classes that we 
	 * use later. Later on, we have the first move that it comes from the Angel side,
	 * the automated side. The logic behind the Angel moves is simple. Angel is trying 
	 * to find the square that it can move to firstly and later on it checks which of the 
	 * possible move is closest to the edge and its not blocked by devil.  For the Devil side
	 * we have automated moves that are trying to close the Angel from escaping based on its 
	 * current move and where it tends to move to. For example if its moved right side we block 
	 * a square on its right side to block it from escaping from the right side.
	 * 
	 * 
	 * 
	 */

	public void gameplay() {

		Print show = new Print(chessboard);
		Winner win = new Winner();

		while (true) {

			int min = chessboard.length;
			int minx = 0, miny = 0;

			// Moving The Angel

			for (int i = 0; i < chessboard.length; i++) {
				for (int j = 0; j < chessboard.length; j++) {

					if (Math.abs(i - x1) <= power && Math.abs(j - y1) <= power && chessboard[i][j] == '+') {
						if ((chessboard.length - i) <= min) {
							minx = i;
							miny = j;

						}
					}
				}
			}

			x2 = minx;
			y2 = miny;

			chessboard[x1][y1] = '+';

			chessboard[x2][y2] = 'A';

			show.show();

			win.angelWins(this);

			// ----------------------------------------------------------------------------------

			// Moving The Devil

			if ((y1 == y2) && ((x1 - x2) > 0) && (chessboard[1][y2] != 'A') && (chessboard[1][y2] != 'D')) {

				chessboard[1][y2] = 'D';
			}

			else if ((y1 == y2) && ((x1 - x2) < 0) && (chessboard[chessboard.length - 2][y2] != 'A')
					&& (chessboard[chessboard.length - 2][y2] != 'D')) {
				chessboard[chessboard.length - 2][y2] = 'D';

			}

			else if ((x1 == x2) && ((y1 - y2) > 0) && (chessboard[x2][1] != 'A') && (chessboard[x2][1] != 'D')) {

				chessboard[x2][1] = 'D';
			}

			else if ((x1 == x2) && ((y1 - y2) < 0) && (chessboard[x2][chessboard.length - 2] != 'A')
					&& (chessboard[x2][chessboard.length - 2] != 'D')) {

				chessboard[x2][chessboard.length - 2] = 'D';
			}

			else if (((x1 - x2) > 0) && ((y1 - y2) < 0) && (chessboard[1][y2] != 'A') && (chessboard[1][y2] != 'D')) {
				chessboard[1][y2] = 'D';
			}

			else if (((x1 - x2) > 0) && ((y1 - y2) > 0) && (chessboard[x2][1] != 'A') && (chessboard[x2][1] != 'D')) {
				chessboard[x2][1] = 'D';

			}

			else if (((x1 - x2) < 0) && ((y1 - y2) < 0) && (chessboard[x2][chessboard.length - 2] != 'A')
					&& (chessboard[x2][chessboard.length - 2] != 'D')) {
				chessboard[x2][chessboard.length - 2] = 'D';
			}

			else if (((x1 - x2) < 0) && ((y1 - y2) > 0) && (chessboard[chessboard.length - 2][y2] != 'A')
					&& (chessboard[chessboard.length - 2][y2] != 'D')) {
				chessboard[chessboard.length - 2][y2] = 'D';
			}

			else
				chessboard[x2 + 1][y2] = 'D';

			x1 = x2;
			y1 = y2;

			show.show();
			win.DevilWins(this);

		}

	}

}
