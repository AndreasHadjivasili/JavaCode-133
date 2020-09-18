package ahadji08.hw4.squarelotron;



/**
 * 
 * This is the Interface class that contains all the methods that we used to
 * create the classes Squarelotron , SmallSquarelotron and LargeSquarelotron.
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 22/3/19
 * 
 *
 */




public interface SquarelotronMethods {
	public int[] numbers();

	public Squarelotron upsideDownFlip(String ring);

	public Squarelotron leftRightFlip(String ring);

	public Squarelotron inverseDiagonalFlip(String ring);

	public Squarelotron mainDiagonalFlip(String ring);

	public Squarelotron sideFlip(String side);

	public void rotateRight(int numberOfTurns);

	@Override
	public boolean equals(Object object);

	@Override
	public String toString();

}
