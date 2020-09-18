package ahadji08.hw4.chess;

import ahadji08.hw4.chess.Piece.Color;



/**
 * 
 * This class is contains only one main method and as its
 * named it used from me to check all my methods step by step
 * that are all working properly. For all the Pieces i use the 
 * same square coordinates d3 and i check every piece's moves
 * that can achieve in the board. 
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 28/3/19
 *
 */



public class test {

	public static void main(String[] args) throws InvalidSquareException {

		Square[] q;

		Pawn A = new Pawn(Color.Black);
		Knight B = new Knight(Color.White);
		King C = new King(Color.White);
		Queen D = new Queen(Color.Black);
		Rook E = new Rook(Color.Black);
		Bishop F = new Bishop(Color.White);

		q = A.movesFrom(new Square('d', '3'));

		for (int i = 0; i < q.length; i++)
			System.out.print("  " + q[i]);

		System.out.println();

		q = B.movesFrom(new Square("d3"));

		for (int i = 0; i < q.length; i++)
			System.out.print("  " + q[i]);

		System.out.println();

		q = C.movesFrom(new Square("d3"));

		for (int i = 0; i < q.length; i++)
			System.out.print("  " + q[i]);

		System.out.println();

		q = D.movesFrom(new Square("d3"));

		for (int i = 0; i < q.length; i++)
			System.out.print("  " + q[i]);

		System.out.println();

		q = E.movesFrom(new Square("d3"));

		for (int i = 0; i < q.length; i++)
			System.out.print("  " + q[i]);

		System.out.println();

		q = F.movesFrom(new Square("d3"));

		for (int i = 0; i < q.length; i++)
			System.out.print("  " + q[i]);

		System.out.println();
		
		


	}

}
