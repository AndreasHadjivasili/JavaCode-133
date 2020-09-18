package ahadji08.hw4.chess;


/**
 * 
 * This is a class that represents the different Pieces of a chess
 * game. A Piece is described by its color white or black.
 * There is only one constructor that takes as parameter
 * a color. Also we have a get method for the color.
 * There are two more methods the algebraicName and the 
 * moves From that are abstract and they are completed in
 * each Piece differently.
 * 
 * @author Andreas Hadjivasili
 * @since 24/3/19
 * 
 *
 */

public abstract class Piece {

	
	enum Color{
		White,  Black;
	}
	
	private Color color;
	
	
	
	public Piece(Color x) {
		
		color = x;
		
	}



	public Color getColor() {
		return color;
	}



	public abstract String algebraicName();
	
	public abstract Square[] movesFrom(Square square);
	
}
