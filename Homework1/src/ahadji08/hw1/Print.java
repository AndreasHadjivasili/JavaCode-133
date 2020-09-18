package ahadji08.hw1;



/**
 * This class is about printing out the probabilities.
 * 
 * This program is based on an object Print that is has two parameters 
 * the model name and the probability matching this model with the String.
 * We have a Single constructor that creates the objects with the two 
 * parameters as inputs. There is also a toString method and a method result
 * that calculates and prints outs with which model it looks like most the
 * String that we took.
 * 
 * @author Andreas Hadjivasili
 * @since 31/1/19
 * 
 *
 */
public class Print {

	private double probability;
	private String modelname;
	
	
	
	
	
	/**
	 * This is the print constructor.
	 * 
	 *  Its the constructor that creates the objects with the two 
	 *  parameters x that is the probability and y that is the model 
	 *  name as inputs.
	 * 
	 * @param x it represents the probability
	 * 
	 * @param y it represents the model name
	 */
	
	
	public  Print(double x, String y) {
		
		probability = x;
		modelname = y;	
		
	}
	
		
	/**
	 * This is the toString method for the Print object
	 * 
	 * It returns a String that is contain the model name and the 
	 * probability the test string is matching with this model.
	 * 
	 */
	
	public String toString() {
		return("Probability that test string is  " + modelname + ":  " + String.format( "%.2f", probability ));
		
	}
	
	
	
	
	/**
	 * This method calculates and print out the final result.
	 * 
	 * This method is taking as input an array of Print objects
	 * and its responsible for finding  the maximum possibility 
	 * from the table and returning the result that is contains 
	 * the name of the model that is most likely the string.
	 * 
	 * @param x  An array of Print objects.
	 * 
	 * @return It returns a String that is the final result 
	 * 		   with the  name of the model that is most likely.
	 */
	
	
	public static String Result(Print x[]) {
		
		double maxpr = 0;
		int max=0;
		int i;
		int le = x.length;
		
		for (i =0; i< le ; i++) {
			if (x[i].probability>maxpr) {
				max = i;
				maxpr = x[i].probability;
			}
		}
		
		return ("Test String is most likely " + x[max].modelname + ".");
		
		
	}
	
	
}
