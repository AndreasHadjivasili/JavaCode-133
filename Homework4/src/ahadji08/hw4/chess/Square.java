package ahadji08.hw4.chess;

/**
 * 
 * This is the class that represents the squares of a chess 
 * board. A Square is described b its coordinates the column 
 * character and the row number. In this class we have two constructors,
 * an equals and a toString method.
 * On the two constructors as you can see we have an Invalid Square Exception.
 * This exception is unchecked because its a run time Exception. 
 * 
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 24/3/19
 *
 */
public class Square {

	private char row;
	private char column;
	

	
	
	/**
	 * 
	 * This is a square constructor that takes as parameters 
	 * two characters the row and the column. In case that the coordinates
	 *  do not exist we throw an Invalid Square Exception.
	 * 
	 * @param col The column letter
	 * @param row The row number
	 * @throws  InvalidSquareException
	 * 
	 */
	
	public Square(char col, char row) {
		

			
			this.row=row;
			column = col; 
			
			if(((column > 'h') || ( row > '8') ||( row < '1'))) {
				
				throw new InvalidSquareException();
			}

		
	}
	
	

	/**
	 * 
	 * This is a square constructor that takes as parameter 
	 * a String that contains two characters the row number
	 *  and the column character. In case that the coordinates
	 *  do not exist we throw an Invalid Square Exception.
	 * 
	 * 
	 * @param col The column letter
	 * @param row The row number
	 * @throws  InvalidSquareException
	 * 
	 */
	
	
	public Square(String name)throws InvalidSquareException{
		

		
		try {
			
			row = name.charAt(1);
			column = name.charAt(0);
			
			if(( column > 'h' || row >'8' || row < '1' )) {
				
				throw new InvalidSquareException();
			}
				
		}
		catch(InvalidSquareException x){ 
			
			System.out.println(x.getMessage());
			System.exit(0);
		}
		
		
		
	}
	
	
	
	
	/* 
	 * This is a toString method that returns the coordinates 
	 * of the square.
	 * 
	 * 
	 */
	
	
	public String toString() {
		
		return ("" + column +row);
		
		
	}
	
	
	
	
	
	/* 
	 * 
	 * This is an equals method that checks if
	 * two squares are equals and returns a 
	 * boolean statement.
	 * 
	 * 
	 */
	
	
	public boolean equals(Object object) {
		
		if (object == null)
			return false;
		
		if(this.getClass() != object.getClass())
			return false;
		
		Square x = (Square)object;
		
		return((x.row == this.row) && (x.column == this.column));
		
	}



	public char getRow() {
		return row;
	}




	public char getColumn() {
		return column;
	}



	
	
	
	
	
	
	
}
