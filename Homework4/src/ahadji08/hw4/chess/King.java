package ahadji08.hw4.chess;

/**
 * This the class that represents the King in our chess board. It contains a
 * constructor method , the method algebraicName and the method movesFrom that
 * calculates all the possible moves the square that we are now.
 * 
 * @author Andreas Hadjivasili
 * @since 25/3/19
 *
 */

public class King extends Piece {

	/**
	 * 
	 * This is the only constructor that takes as a parameter a color that describes
	 * our Piece.
	 * 
	 * @param x The color of the King.
	 *
	 */

	public King(Color x) {
		super(x);

	}

	/*
	 * 
	 * This is a method that returns a character that represents the name of the
	 * piece that are using.
	 * 
	 */

	public String algebraicName() {

		return ("K");

	}

	/*
	 * 
	 * This method is responsible for finding and collecting all the possible
	 * squares that our piece can move to based on which square we are on now and
	 * put them in an array of Squares.
	 * 
	 * @returns The array with the squares that we can access.
	 * 
	 */

	public Square[] movesFrom(Square square) {

		Square t[] = new Square[8];
		int count = 0;

		int[][] offsets = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };

		for (int[] w : offsets) {

			int x = (int) (square.getRow()) - 48 + w[0];
			int y = (int) (square.getColumn()) - 96 + w[1];

			// count valid moves
			if (x > 0 && y > 0 && x < 9 && y < 9) {

				t[count] = new Square( (char) (y + 96), (char) (x + 48));
				count++;

			}
		}

		return t;

	}

}
