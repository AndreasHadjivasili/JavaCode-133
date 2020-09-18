package ahadji08.hw4.chess;

/**
 * 
 * This is an exception class that creates Invalid Square 
 * Exceptions in case that the user give as input coordinates
 * that are not exist on a chess board. This class extends 
 * the java class Exception.
 * This exception we decided to do it unchecked because its 
 * coming from a RunTime Exception and not from a compile error.
 * We are checking if the string/coordinates that the user give
 * us are exist on a chess board. 
 * 
 * @author Andreas Hadjivasili
 * @since 25/3/19
 *
 */
public class InvalidSquareException extends RuntimeException {

	
	
	/**
	 * This a default constructor for creating  Invalid Square Exceptions
	 */
	public InvalidSquareException() {
		super("Invalid Square Coordinates");
	}
	
	
	 
	/**
	 *  This a constructor for creating  Invalid Square Exceptions
	 *  with a String as parameter that represents the square coordinates.
	 * 
	 * @param s   The square coordinates
	 */
	public InvalidSquareException(String s) {
		
		super(s);
		
		
	}
	
	
	
	/*
	 * This method is responsible for showing the following message
	 * when we have an exception.
	 * 
	 *
	 */
	
	
	public String getMessage() {
		
		return("Invalid Square Coordinates");
	}
	
	
	
	
	
	
	
	

	
}
	