package ahadji08.hw4.squarelotron;

/**
 * 
 * This class is contains only one main method and as its
 * named it used from me to check all my methods step by step
 * that are all working properly. For all the flips i print out
 * first how the squarelotron is in the start and then how it changes.
 * At the end of these runs i call the start method to check that it
 * can runs also independedly. 
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 28/3/19
 *
 */
public class test {

	public static void main(String[] args) {
		
		
		int[] c = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int[] s = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		
		
		System.out.println("UpsideDown  OUTER");
		
		SmallSquarelotron q = new SmallSquarelotron(c);
		LargeSquarelotron w = new LargeSquarelotron(s);
		

		
		
		Squarelotron t  = q.upsideDownFlip("outer");
		Squarelotron p  = w.upsideDownFlip("outer");
		


		
		System.out.println(q);
		System.out.println(w);
		System.out.println(t);
		System.out.println(p);
		
		
		
		System.out.println("UPSIDE DOWN INNER");
		
		q = new SmallSquarelotron(c);
		w = new LargeSquarelotron(s);
		

		
		
		t  = q.upsideDownFlip("inner");
		p  = w.upsideDownFlip("inner");
		

		

		
		System.out.println(q);
		System.out.println(w);
		System.out.println(t);
		System.out.println(p);
		
		
		
		
		
		
		
		
		System.out.println("LeftRight - OUTER");
		
		q = new SmallSquarelotron(c);
		w = new LargeSquarelotron(s);
		

		
		t  = q.leftRightFlip("outer");
		p  = w.leftRightFlip("outer");
		

		

		
		System.out.println(q);
		System.out.println(w);
		System.out.println(t);
		System.out.println(p);
		
		
		
		
		
		
		System.out.println("LeftRight - inner");
		
		q = new SmallSquarelotron(c);
		w = new LargeSquarelotron(s);
		

		
		
		t  = q.leftRightFlip("inner");
		p  = w.leftRightFlip("inner");
		


		
		System.out.println(q);
		System.out.println(w);
		System.out.println(t);
		System.out.println(p);
		
		
		
		
		
		
		System.out.println("Reverse Diagonal - outer");
		
		q = new SmallSquarelotron(c);
		w = new LargeSquarelotron(s);
		

		
		
		t  = q.inverseDiagonalFlip("outer");
		p  = w.inverseDiagonalFlip("outer");
		

		

		
		System.out.println(q);
		System.out.println(w);
		System.out.println(t);
		System.out.println(p);
		
		
		
		
		
		
		
		System.out.println("Reverse Diagonal - inner");
		
		q = new SmallSquarelotron(c);
		w = new LargeSquarelotron(s);
		

		
		
		t  = q.inverseDiagonalFlip("inner");
		p  = w.inverseDiagonalFlip("inner");
		

		

		
		System.out.println(q);
		System.out.println(w);
		System.out.println(t);
		System.out.println(p);
		
		
		
		
		
		
		
		
		System.out.println("Main Diagonal - outer");
		
		q = new SmallSquarelotron(c);
		w = new LargeSquarelotron(s);
		

		
		
		t  = q.mainDiagonalFlip("outer");
		p  = w.mainDiagonalFlip("outer");
		

		

		
		System.out.println(q);
		System.out.println(w);
		System.out.println(t);
		System.out.println(p);
		
		
		
		
		System.out.println("Main Diagonal - inner");
		
		q = new SmallSquarelotron(c);
		w = new LargeSquarelotron(s);
		

		
		
		t  = q.mainDiagonalFlip("inner");
		p  = w.mainDiagonalFlip("inner");
		

		
		System.out.println(q);
		System.out.println(w);
		System.out.println(t);
		System.out.println(p);
		
		
		
		
		
		System.out.println("Side flip - Right-left");
		
		q = new SmallSquarelotron(c);
		w = new LargeSquarelotron(s);
		
		
		
		t  = q.sideFlip("left");
		p  = w.sideFlip("left");
		

		

		
		System.out.println(q);
		System.out.println(w);
		System.out.println(t);
		System.out.println(p);
		
		
		
		
		
		
		System.out.println("Side flip - Up Down");
		
		q = new SmallSquarelotron(c);
		w = new LargeSquarelotron(s);
		

		
		
		t  = q.sideFlip("top");
		p  = w.sideFlip("Bottom");
		

		

		
		System.out.println(q);
		System.out.println(w);
		System.out.println(t);
		System.out.println(p);
		
		
		
		
		System.out.println("Rotate Right");
		
		q = new SmallSquarelotron(c);
		w = new LargeSquarelotron(s);
		

		
		System.out.println(q);
		System.out.println(w);
		
		q.rotateRight(1);
		w.rotateRight(1);
		
		
		System.out.println(q);
		System.out.println(w);

		
		
		System.out.println("Rotate Left");
		
		q = new SmallSquarelotron(c);
		w = new LargeSquarelotron(s);
		
		System.out.println(q.numbers());
		
		System.out.println(q);
		System.out.println(w);
		
		q.rotateRight(-1);
		w.rotateRight(-2);
		
		System.out.println(q);
		System.out.println(w);
		
		
		
		
		Squarelotron.start();
		
		

	}

}
