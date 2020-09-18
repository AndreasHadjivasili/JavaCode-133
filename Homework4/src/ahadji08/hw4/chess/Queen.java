package ahadji08.hw4.chess;

/**
 * This the class that represents the Queen in our chess board. It contains a
 * constructor method , the method algebraicName and the method movesFrom that
 * calculates all the possible moves the square that we are now.
 * 
 * @author Andreas Hadjivasili
 * @since 25/3/19
 *
 */
public class Queen extends Piece {

	/**
	 * 
	 * This is the only constructor that takes as a parameter a color that describes
	 * our Piece.
	 * 
	 * @param x The color of the Queen
	 *
	 */
	public Queen(Color x) {
		super(x);

	}

	/*
	 * 
	 * This is a method that returns a character that represents the name of the
	 * piece that are using.
	 * 
	 */

	public String algebraicName() {

		return ("Q");

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

		Square t[] = new Square[28];
		int count = 0;

		for (int i = 1; i <= 8; i++) {
			for (int j = 'a'; j <= 'h'; j++) {

				int sx = (int) (square.getRow()) - 48;
				int sy = (int) (square.getColumn()) - 96;

				int dx = i;
				int dy = (int) j - 96;

				if (Math.abs(sx - dx) == Math.abs(sy - dy) && (sx != dx)) {

					t[count] = new Square((char) (dy + 96),(char) (dx + 48));
					count++;
				}

			}
		}

		for (int i = 1; i <= 8; i++) {
			if (square.getRow() != (char) (i + 48)) {
				t[count] = new Square( square.getColumn(), (char) (i + 48));
				count++;
			}
		}

		for (int i = 'a'; i <= 'h'; i++) {
			if (square.getColumn() != (char) i) {
				t[count] = new Square( (char) i , square.getRow());
				count++;
			}
		}

		return t;

	}

}
