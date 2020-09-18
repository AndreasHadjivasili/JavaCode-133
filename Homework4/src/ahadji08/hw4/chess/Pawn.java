package ahadji08.hw4.chess;

/**
 * This the class that represents the Pawn in our chess board. It contains a
 * constructor method , the method algebraicName and the method movesFrom that
 * calculates all the possible moves the square that we are now.
 * 
 * @author Andreas Hadjivasili
 * @since 25/3/19
 *
 */

public class Pawn extends Piece {

	/**
	 * 
	 * This is the only constructor that takes as a parameter a color that describes
	 * our Piece.
	 * 
	 * @param x The color of the Pawn.
	 *
	 */

	public Pawn(Color x) {
		super(x);
	}

	/*
	 * 
	 * This is a method that returns a character that represents the name of the
	 * piece that are using.
	 * 
	 */
	public String algebraicName() {

		return ("P");

	}

	/*
	 * 
	 * This method is responsible for finding and collecting all the possible
	 * squares that our piece can move to based on which square we are on now and
	 * put them in an array of Squares. We also check if the Pawn is in row 2
	 * it is able to move 2 squares from and Moreover a Pawn can not be in row 1
	 * and also can not move anywhere after its achieve row 8.
	 * 
	 * @returns The array with the squares that we can access.
	 * 
	 */

	public Square[] movesFrom(Square square) {

		Square t[];

		if (square.getRow() == '8') {
			return null;

		}
		
		if (square.getRow() == '1') {
			return null;

		}

		if (square.getRow() == '2') {
			t = new Square[2];

			t[0] = new Square(square.getColumn(),'3');
			t[1] = new Square( square.getColumn(),'4');

			return t;
		}

		else {
			t = new Square[1];
			t[0] = new Square(square.getColumn(),(char)(((int)square.getRow()) + 1));
			return t;
		}

	}
}
