package ahadji08.hw3;

import static org.junit.Assert.*;

import org.junit.Test;

public class GametableTest {

	@Test
	public void testGametable() {
		
		Gametable x = new Gametable();
		Gametable y = new Gametable();
		
		assertEquals(8,x.chessboard.length);
		assertEquals(1,x.power);
		assertTrue(x.x1 == x.chessboard.length/2);
		assertFalse(x.equals(y));
		
		
	}

}
