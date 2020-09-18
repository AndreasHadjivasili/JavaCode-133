package ahadji08.hw4.squarelotron;

import static org.junit.Assert.*;

import org.junit.Test;



/**
 * This class is a JUnit test class that contains a test method for all the
 * classes included in the Interface class.
 *
 * @author Andreas Hadjivasilo
 * @since 23/3/19
 *
 */



public class SquarelotronMethodsTest {

	int q[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

	Squarelotron mySq = Squarelotron.makeSquarelotron(q);

	@Test
	public void testUpsideDownFlip() {
		int t[][] = { { 1, 2, 3, 4 }, { 5, 10, 11, 8 }, { 9, 6, 7, 12 }, { 13, 14, 15, 16 } };
		Squarelotron s = Squarelotron.makeSquarelotron(q);
		s.squarelotron = t;
		assertEquals(mySq.upsideDownFlip("inner"), s);

	}




	@Test
	public void testMainDiagonalFlip() {
		int t[][] = { { 1, 2, 3, 4 }, { 5, 6, 10, 8 }, { 9, 7, 11, 12 }, { 13, 14, 15, 16 } };
		Squarelotron s = Squarelotron.makeSquarelotron(q);
		s.squarelotron = t;
		assertEquals(mySq.mainDiagonalFlip("inner"), s);
	}


	@Test
	public void testRotateRight() {
		int t[][] = { { 13, 9, 5, 1 }, { 14, 10, 6, 2 }, { 15, 11, 7, 3 }, { 16, 12, 8, 4 } };
		Squarelotron s = Squarelotron.makeSquarelotron(q);
		s.squarelotron = t;
		mySq.rotateRight(1);
		assertEquals(mySq, s);
	}


	@Test
	public void testLeftRightFlip() {
		mySq = mySq.leftRightFlip("outer");
		assertEquals(mySq.squarelotron[0][3], 1);
		assertEquals(mySq.squarelotron[0][2], 2);
		assertEquals(mySq.squarelotron[0][1], 3);
		assertEquals(mySq.squarelotron[0][0], 4);
	}

	@Test
	public void testinverseDiagonalFlip() {
		mySq = mySq.inverseDiagonalFlip("outer");
		assertEquals(mySq.squarelotron[0][3], 4);
		assertEquals(mySq.squarelotron[0][2], 8);
		assertEquals(mySq.squarelotron[0][1], 12);
		assertEquals(mySq.squarelotron[0][0], 16);
	}

	@Test
	public void testsideFlip() {
		mySq = mySq.sideFlip("top");
		assertEquals(mySq.squarelotron[0][3], 16);
		assertEquals(mySq.squarelotron[0][2], 15);
		assertEquals(mySq.squarelotron[0][1], 14);
		assertEquals(mySq.squarelotron[0][0], 13);
	}

	@Test
	public void testequals() {
		Squarelotron s = Squarelotron.makeSquarelotron(q);
		assertTrue(mySq.equals(s));

	}

	@Test

	public void testnumbers() {
		int g[] = { 2, 4, 5, 2, 5, 1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Squarelotron s = Squarelotron.makeSquarelotron(g);
		int d[] = s.numbers();
		assertFalse(d.equals(g));

	}

	@Test
	public void testmakeSquarelotron() {

		SmallSquarelotron v = new SmallSquarelotron(q);
		Squarelotron s = Squarelotron.makeSquarelotron(q);
		assertEquals(v, s);

	}

	@Test
	public void testSmallSquarelotron() {

		SmallSquarelotron v = new SmallSquarelotron(q);
		Squarelotron s = Squarelotron.makeSquarelotron(q);
		assertEquals(v, s);

	}

	@Test
	public void testLargeSquarelotron() {

		int[] j = { 2, 4, 5, 2, 5, 1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		LargeSquarelotron v = new LargeSquarelotron(j);
		Squarelotron s = Squarelotron.makeSquarelotron(j);
		assertEquals(v, s);

	}

}
