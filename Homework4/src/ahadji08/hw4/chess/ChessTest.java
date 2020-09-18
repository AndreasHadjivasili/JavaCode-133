package ahadji08.hw4.chess;

import static org.junit.Assert.*;

import org.junit.Test;

import ahadji08.hw4.chess.Piece.Color;

public class ChessTest  {

	@Test
	public void test() throws InvalidSquareException {
		
		Piece knight = new Knight(Color.Black); 
		assert knight.algebraicName().equals("N"); 
		Square[] attackedSquares = knight.movesFrom(new Square("f6"));
		Square a1 = new Square("a1"); 
		Square otherA1 = new Square('a', '1'); 
		Square h8 = new Square("h8"); 
		assert a1.equals(otherA1);
		assert !a1.equals(h8); 
	}

}
