package ahadji08.hw4.squarelotron;
import java.util.Scanner;





/**
 * This is an abstract class that controls both Small an Large Squarelotrons.
 * 
 * 
 * This class houses any variables and methods that are common to both SmallSquarelotron 
 * and LargeSquarelotron. This class declares the instance variable public int[][] squarelotron,
 * which is inherited by each of the two subclasses. It contains the start method which interacts
 * with the user, and is the only method that does input/output. Also it contains an equals and
 * a toString method.  
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 22/3/19
 *
 *
 */



public abstract class Squarelotron implements SquarelotronMethods {

	
	public int[][] squarelotron;

	
	
	
	/**
	 * This is a Squarelotron constructor.
	 * 
	 * 
	 * Constructs and returns a squarelotron with the given numbers,
	 * not just 1 to 16 or 2 in order. The following conditions are 
	 * have to be met to create the Sqauarelotron : (1) The given array 
	 * is either 16 or 25 in length, and (2) all the numbers in the 
	 * array are nonnegative and less than or equal to 99. If either 
	 * of these conditions is violated,execute throw 
	 * new IllegalArgumentException(message).
	 * 
	 * 
	 * @param array   Is an array that contains the starting numbers of the Squarelotron that we will create..
	 * @return   	  Returns the Squarelotron that we created.
	 * @throws IllegalArgumentException
	 * 
	 *
	 *
	 */
	public static Squarelotron makeSquarelotron(int[] array) throws IllegalArgumentException {

		if ((array.length != 16) && (array.length != 25)) {

			throw new IllegalArgumentException();
		}

		for (int i = 0; i < array.length; i++) {

			if ((array[i] > 99) || (array[i] < 0)) {
				throw new IllegalArgumentException();
			}
		}

		if (array.length == 16) {
			return new SmallSquarelotron(array);

		}

		else
			return new LargeSquarelotron(array);

	}
	
	
	

	/**
	 *  This is the method that runs the game.
	 *  
	 *  This method runs the whole game and its doing the 
	 *  following things:
	 *  
	 * 	1. Asks the user for the size of the Squarelotron that 
	 *  he wants to play with.
	 * 	2. It prints the Starting Squarelotron and the Menu
	 *  with the moves that he has to choose from to play.
	 *  3. It takes the input from the user for the type of
	 *  the Flip that he wants to do, it does the flip and
	 *  printing out the new Squarelotron.
	 * 	4. It asks the user if he wants to ply again or
	 *  if he wants to stop the game.
	 * 
	 * 
	 */
	public static void start() {

		Scanner sc = new Scanner(System.in);
		int[] table;
		String ring;
		Boolean replay = true;
		Squarelotron sq2 ;
		
		

		
		while (replay) {
		System.out.print(" Give the Squarelotron size that you want to play with (4 or 5) :  ");
		int s = sc.nextInt();
		System.out.println();

		while (s != 4 && s != 5) {

			System.out.println("Please give a valid number 5 or 4:  ");
			s = sc.nextInt();

		}

		if (s == 5)
			table = new int[25];
		else
			table = new int[16];

		for (int i = 1; i <= (s * s); i++) {
			table[i - 1] = i;

		}

		Squarelotron sq = makeSquarelotron(table);
		System.out.println(sq);

		System.out.println(" The movement choices:");
		System.out.println("");
		System.out.println(" 1. Upside-Down Flip");
		System.out.println(" 2. Left-Right Flip");
		System.out.println(" 3. Main Inverse Diagonal Flip");
		System.out.println(" 4. Main  Diagonal Flip");
		System.out.println(" 5. Side Flip");
		System.out.println(" 6. Rotate Right Flip");

		System.out.println("");
		System.out.print(" Please choose one the six by entering the number of it :  ");

		int choice = sc.nextInt();
		System.out.println("");

		while (choice > 6 || choice < 1) {

			System.out.print("Please give a valid number 1 to 6:  ");
			System.out.println("");
			choice = sc.nextInt();
		}
		
		
		

		switch (choice) {

		case 1:
			System.out.print(" Which ring do you want to flip the inner or the outer ? ");
			ring = sc.next();
			System.out.println("");
			while (!ring.equals("inner") && !ring.equals("outer")) {
				System.out.print("Please give a valid ring outer or inner:  ");
				System.out.println("");
				ring = sc.next();
			}
			sq2 = sq.upsideDownFlip(ring);
			System.out.println(sq2);
			break;

			
			
		case 2:
			System.out.print(" Which ring do you want to flip the inner or the outer ? ");
			ring = sc.next();
			System.out.println("");
			while (!ring.equals("inner") && !ring.equals("outer")) {
				System.out.print("Please give a valid ring outer or inner:  ");
				System.out.println("");
				ring = sc.next();
			}
			sq2 =sq.leftRightFlip(ring);
			System.out.println(sq2);
			break;

			
			
		case 3:
			System.out.print(" Which ring do you want to flip the inner or the outer ? ");
			ring = sc.next();
			System.out.println("");
			while (!ring.equals("inner") && !ring.equals("outer")) {
				System.out.print("Please give a valid ring outer or inner:  ");
				System.out.println("");
				ring = sc.next();
			}
			sq2 =sq.inverseDiagonalFlip(ring);
			System.out.println(sq2);
			break;

			
			
		case 4:
			System.out.print(" Which ring do you want to flip the inner or the outer ? ");
			ring = sc.next();
			System.out.println("");
			while (!ring.equals("inner") && !ring.equals("outer")) {
				System.out.print("Please give a valid ring outer or inner:  ");
				ring = sc.next();
				System.out.println("");
			}
			sq2 =sq.mainDiagonalFlip(ring);
			System.out.println(sq2);
			break;

			
			
		case 5:
			System.out.print(" Which side do you want to flip  left , right , bottom or top ? ");
			ring = sc.next();
			System.out.println("");
			while (!ring.equals("left") && !ring.equals("right")&& !ring.equals("bottom")&& !ring.equals("top")) {
				System.out.print("Please give a valid side:  ");
				System.out.println("");
				ring = sc.next();
			}
			sq2 = sq.sideFlip(ring);
			System.out.println(sq2);

			break;

			
			
		case 6:
			System.out.print(" Give the number of rotations that you want:  ");
			int z = sc.nextInt();
			System.out.println("");
			sq.rotateRight(z);
			System.out.println(sq);
			break;

		}
		
		
		System.out.print(" Do you want to play again yes or no ?");
		String r = sc.next();
		System.out.println("");
		
		while( !r.equals("no") && !r.equals("yes")) {
			System.out.println("please give a valid answer yes or no? ");
			r = sc.next();
			System.out.println("");
		}
		
		if(r.equals("yes"))
			replay = true;
		else {replay= false;
			System.out.println(" THE GAME ENDS ! ");
		}
		
		
		
		}
		
		

	}

	public abstract int[] numbers();

	public abstract Squarelotron upsideDownFlip(String ring);

	public abstract Squarelotron leftRightFlip(String ring);

	public abstract Squarelotron inverseDiagonalFlip(String ring);

	public abstract Squarelotron mainDiagonalFlip(String ring);

	public abstract Squarelotron sideFlip(String side);

	public abstract void rotateRight(int numberOfTurns);

	
	
	/* 
	 * 
	 * This is an equals method that checks if two
	 * any sizes Squarelotron are equals.
	 * 
	 * 
	 */
	
	
	public boolean equals(Object object) {

		boolean s = true;

		if (object == null)
			return false;

		if (this.getClass() != object.getClass())
			return false;

		Squarelotron x = (Squarelotron) object;

		if (this.squarelotron.length != x.squarelotron.length)
			return false;

		for (int i = 0; i < x.squarelotron.length; i++)
			for (int j = 0; j < x.squarelotron.length; j++) {
				if (x.squarelotron[i][j] != this.squarelotron[i][j])
					s = false;

			}

		return s;

	}

	
	
	
	/* 
	 * 
	 * This is a toStrong method that prints out a
	 * printable version of a Squarelotron.
	 * 
	 */
	
	public String toString() {

		String s = "";

		for (int i = 0; i < this.squarelotron.length; i++) {

			s = s + ("\n");

			if (this.squarelotron.length == 5)
				s = s + ("------------------------");

			else
				s = s + ("-------------------");

			s = s + ("\n");

			for (int j = 0; j < this.squarelotron.length; j++) {

				if (this.squarelotron[i][j] < 10)
					s = s + (this.squarelotron[i][j] + "  | ");

				else
					s = s + (this.squarelotron[i][j] + " | ");
			}
		}

		s = s + ("\n");
		if (this.squarelotron.length == 5)
			s = s + ("------------------------");

		else
			s = s + ("-------------------");

		s = s + ("\n");

		return s;

	}

}
