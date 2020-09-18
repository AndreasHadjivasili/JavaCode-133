package ahadji08.hw2;

/**
 * This class is responsible for printing out the chessboard.
 * 
 * 
 * In this class there are two methods the constructor and the 
 * show method. The constructor creates the print object and 
 * the show method takes the array that represents the chees board
 * and it prints it out in a real chess form.
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 11/2/19
 * 
 *
 */

public class Print {
	
	private char[][] board;
	
	
	
	/**
	 * This is the only constructor of the Print object.
	 * 
	 * This constructor creates Print object that is basically
	 * a character array that presents the chess board that the
	 * users play on the game.
	 * 
	 * @param x Is a character array that presents the chess board.  
	 * 
	 */

	public Print(char[][] x) {
		
		board = x;
		
	}
	
	
	
	/**
	 * This is the method that prints out the chess board.
	 * 
	 * 
	 * Its basically takes the character array and based on its 
	 * size and what it contains its printing out a real form 
	 * of the chess board current statement.
	 *
	 * 
	 */
	
	public void show() {
		
		for (int row = 0; row < board.length; row++)
		  {
		      System.out.println("");
		     
		      for (int i=0; i<board.length;i++)
		      System.out.print("----");
		      System.out.println();

		      for (int column = 0; column < board.length; column++)
		      {
		    	
		          System.out.print("| " + board[row][column] + " ");
		      }       
		      System.out.print("|");
		    }
		    System.out.println("");
		    for (int i=0; i<board.length;i++)
			      System.out.print("----");
		    System.out.println();
	
		    System.out.println();
	}

}
