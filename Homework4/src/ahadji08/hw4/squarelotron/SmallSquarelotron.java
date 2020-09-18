package ahadji08.hw4.squarelotron;


/**
 * 
 * This class implements 4x4 squarelotrons and
 * contains all the methods for the flips of a
 * 4x4 squarelotron.
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 22/3/16
 *
 */


public class SmallSquarelotron extends Squarelotron{

	

	/**
	 * It inherits the variable int[][] squarelotron from the Squarelotron
	 *  class, and fills it with the numbers that are included in the array
	 *  that we take as parameter.
	 *  
	 *  
	 * @param array Is an array that includes the starting number of the squarelotron
	 * 
	 */
	public SmallSquarelotron(int[] array) {
		
		squarelotron = new int[4][4];
		int counter =0;
		
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				squarelotron[i][j] = array[counter];
				counter++;
		}
	}
	}
		
	
	
		

	
		/* 
		 * Given a 4x4 squarelotron, numbers returns 
		 * an array of 16 numbers that are the number
		 * s that are on the squarelotron.
		 */
	
	
		public int[] numbers() {
			
			int arr[] = new int[16];
			int counter =0;
			
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					arr[counter] = squarelotron[i][j];
					counter++;
			}
		}
			
			return arr;
			
			
		}
	
		
		//---------------------------------------------------------------------------------------------------
		
		
		

		
		

		/* 
		 * 
		 * This method performs the Upside-Down Flip of the squarelotron
		 * that changes the rows to starting from the bottom to the top
		 * in the given ring.
		 * 
		 * 
		 * @returns     A new squarelotron with the flip on.
		 * @param ring  A String with the ring name that we are flip. 
		 */
		
		
		public Squarelotron upsideDownFlip(String ring) {
			 
			 SmallSquarelotron x = new SmallSquarelotron(this.numbers());
			 
			 
			 if (ring.equals("outer")) {
				 
				 for(int i=0; i<4; i++) {
					 
					 x.squarelotron[0][i] = this.squarelotron[3][i];
					 x.squarelotron[3][i] = this.squarelotron[0][i];
					 
				 }
				 
				 x.squarelotron[1][0] = this.squarelotron[2][0];
				 x.squarelotron[2][0] = this.squarelotron[1][0];	 
				 x.squarelotron[1][3] = this.squarelotron[2][3];
				 x.squarelotron[2][3] = this.squarelotron[1][3];	 
				 
			 }
			 
			 else {
				 x.squarelotron[1][1] = this.squarelotron[2][1];
				 x.squarelotron[2][1] = this.squarelotron[1][1];
				 x.squarelotron[1][2] = this.squarelotron[2][2];
				 x.squarelotron[2][2] = this.squarelotron[1][2];
			 }
			 
			
	 
			 return x;
		 }
		 

		 
		 
		 //-----------------------------------------------------------------------------------------
		 
		 
		 
		
		
		/* 
		 * 
		 * This method performs the Left-Right Flip of the squarelotron
		 * that changes the columns to starting from the right to the left
		 * in the given ring.
		 * 
		 * 
		 * @returns     A new squarelotron with the flip on.
		 * @param ring  A String with the ring name that we are flip. 
		 */
		
		
		 public Squarelotron leftRightFlip(String ring) {
			 
			 SmallSquarelotron x = new SmallSquarelotron(this.numbers());
			 int j = 3;
			 
			 
			 if (ring.equals("outer")) {
				 
				 for(int i=0; i<4; i++) {
					 
					 x.squarelotron[0][i] = this.squarelotron[0][j];
					 x.squarelotron[3][i] = this.squarelotron[3][j];
					 j--;
				 }
				 
				 x.squarelotron[1][0] = this.squarelotron[1][3];
				 x.squarelotron[1][3] = this.squarelotron[1][0];	 
				 x.squarelotron[2][0] = this.squarelotron[2][3];
				 x.squarelotron[2][3] = this.squarelotron[2][0];	 
			 
		 }
			 
			 else {
				 x.squarelotron[1][1] = this.squarelotron[1][2];
				 x.squarelotron[1][2] = this.squarelotron[1][1];	 
				 x.squarelotron[2][1] = this.squarelotron[2][2];
				 x.squarelotron[2][2] = this.squarelotron[2][1];	 
			 }
				 
		 return x;
		 
		 }

		 
	
	//-----------------------------------------------------------------------------------------------------------------	 
		 
		 
			/* 
			 * 
			 * This method performs the Main Inverse Diagonal of the squarelotron
			 * that changes the Squarelotron like mirroring the numbers based on the
			 * inverse Diagonal in the given ring.
			 * 
			 * 
			 * @returns     A new squarelotron with the flip on.
			 * @param ring  A String with the ring name that we are flip. 
			 * 
			 */
		 
		 public Squarelotron inverseDiagonalFlip(String ring) {
			 
			 SmallSquarelotron x = new SmallSquarelotron(this.numbers());
			 int j = 3;
			 
			 if (ring.equals("outer")) {
				 
				 for(int i=0; i<4; i++) {
					 
					 x.squarelotron[0][i] = this.squarelotron[j][3];
					 x.squarelotron[j][3] = this.squarelotron[0][i];
					 x.squarelotron[i][0] = this.squarelotron[3][j];
					 x.squarelotron[3][j] = this.squarelotron[i][0];
					 j--;
					 
					 
				 }
				 
				 
			 }
			 
			 
			 else {
				
				 x.squarelotron[1][1] = this.squarelotron[2][2];
				 x.squarelotron[2][2] = this.squarelotron[1][1];
	 
			 }
			 
			 
			 
			 return x;

		 }
		 
	
	//----------------------------------------------------------------------------------------------------------------------	 
		 
		 
			/* 
			 * 
			 * This method performs the Main Diagonal of the squarelotron
			 * that changes the Squarelotron like mirroring the numbers based on the
			 * inverse Diagonal in the given ring.
			 * 
			 * 
			 * @returns     A new squarelotron with the flip on.
			 * @param ring  A String with the ring name that we are flip. 
			 * 
			 */
		 
		 
		 public Squarelotron mainDiagonalFlip(String ring) {
			 
			 SmallSquarelotron x = new SmallSquarelotron(this.numbers());
			 
			 
			
			 if (ring.equals("outer")) {
				 
				 for(int i=0; i<4; i++) {
					 
					 x.squarelotron[0][i] = this.squarelotron[i][0];
					 x.squarelotron[i][0] = this.squarelotron[0][i];
					 x.squarelotron[3][i] = this.squarelotron[i][3];
					 x.squarelotron[i][3] = this.squarelotron[3][i];
					
					 
				 }
				 
				 
			 }
			 
			 else {
				 x.squarelotron[2][1] = this.squarelotron[1][2];
				 x.squarelotron[1][2] = this.squarelotron[2][1];
	 
				 
			 }
			 
			 
			 
			 return x;
		 }
		 
		 
		 
		 //---------------------------------------------------------------------------------------------------------------
		 
		 
		 
			/* 
			 * The argument side is one of the four strings "left", "right", "top", and "bottom".
			 * The two indicated columns (leftmost and rightmost), or the two indicated rows 
			 * (top two rows and bottom two rows) are interchanged.
			 * 
			 * 
			 * @returns     A new squarelotron with the flip on.
			 * @param side  A String with the side name that we will flip. 
			 * 
			 */
		  
		 public Squarelotron sideFlip(String side) {
			 
			 SmallSquarelotron x = new SmallSquarelotron(this.numbers());
			 
			 
			 if (side.equals("left")||side.equals("right")) {
				 
				 for(int i=0; i<4; i++) {
					 
					 x.squarelotron[i][0] = this.squarelotron[i][3];
					 x.squarelotron[i][3] = this.squarelotron[i][0];
				 }
			 }
			 
			 else {
				 
				 for(int i=0; i<4; i++) {
				 x.squarelotron[0][i] = this.squarelotron[3][i];
				 x.squarelotron[3][i] = this.squarelotron[0][i];
				 }
			 }

			 
			 		 
			 
			return x ;
			 
		 }
		 
		 
		 
		 //----------------------------------------------------------------------------------------------------
		 
		 
		 
			/* 
			 * The argument numberOfTurns indicates the number of times the squarelotron
			 * is rotated 90° clockwise. Any integer, including zero and negative 
			 * integers, is allowed. A value of -1 indicates a 90° counterclockwise rotation
			 * and zero indicates no rotation.
			 * 
			 * 
			 *@param  numberOfTurns  indicates the number of times the squarelotron will be rotated
			 * 
			 */
		 
		 
		 
		 
		 
		    public void rotateRight(int numberOfTurns) {
		    	
		    	
		    	int N = this.squarelotron.length;
		    	
		    
		    	
    
		    	
		    	if (numberOfTurns>0) {
		    		
		    		for(int q=0;q<numberOfTurns; q++) {
		    		
 
		    		    
		    			 for (int i = 0; i < N / 2; i++) 
		    			    { 
		    			        for (int j = i; j < N - i - 1; j++) 
		    			        { 
		    			  
		    			            // Swap elements of each ring
		    			            // in clockwise direction 
		    			            int temp =this.squarelotron[i][j]; 
		    			            this.squarelotron[i][j] =this.squarelotron[N - 1 - j][i]; 
		    			            this.squarelotron[N - 1 - j][i] =this.squarelotron[N - 1 - i][N - 1 - j]; 
		    			            this.squarelotron[N - 1 - i][N - 1 - j] =this.squarelotron[j][N - 1 - i]; 
		    			            this.squarelotron[j][N - 1 - i] = temp; 
		    			        } 
		    			    } 

		    		}	
		    		
		    	}
		    	
		    	else {
		    	
		    		for(int c = 1; c<=Math.abs(numberOfTurns); c++){
		    			
		    			
	    		        // Consider all squares one by one 
	    		        for (int i = 0; i < N / 2; i++) 
	    		        { 
	    		            // Consider elements in group of 4 in current square 
	    		            for (int y = i; y < N-i-1; y++) 
	    		            { 
	    		                // store current cell in temp variable 
	    		                int temp = this.squarelotron[i][y]; 
	    		       
	    		                // move values from right to top 
	    		                this.squarelotron[i][y] = this.squarelotron[y][N-1-i]; 
	    		       
	    		                // move values from bottom to right 
	    		                this.squarelotron[y][N-1-i] =this.squarelotron[N-1-i][N-1-y]; 
	    		       
	    		                // move values from left to bottom 
	    		                this.squarelotron[N-1-i][N-1-y] =this.squarelotron[N-1-y][i]; 
	    		       
	    		                // assign temp to left 
	    		                this.squarelotron[N-1-y][i] = temp; 
	    		            } 
	    		        }

		    		}
		    		
		    		
		    	}
		    	
		    	
		    }
		 
		 
		 
		 
		 
		 
	}

