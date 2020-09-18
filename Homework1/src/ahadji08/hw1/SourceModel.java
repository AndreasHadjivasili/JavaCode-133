

package ahadji08.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



/**
 * This program is about machine-learning and how a language can be understandable by a computer.
 * 
 *  
 *  First, we have an object named SourceModel which is taking as inputs two  Strings: The first one is the Model name 
 *  that it represents basically the name of the language (ex. English, Fortran,Spanish e.t.c) and the second String is 
 *  the name of the corpus file (Its a text file for machine language learning) that we will train our Model.
 *  After, our constructor reads all the file and it converts it to a single String only with alphabetic letters and it 
 *  makes an array that includes how many times each letter was followed by the others and its own. Next an array of 
 *  possibilities about the letters created.
 *  This program also, it has the method probability that it takes a String and it calculates the probability of the 
 *  String matching with the model that we created (example: if the String "My car is Blue." is Spanish or Java e.t.c).
 *  Moreover this program contains an getName method that return the SaurceModel name and an toString method for our
 *  object.  There is also a method that calculates the final probabilities before we print the final results to the user.
 *  Finally, there is a main method that runs our program with many different Model and a String to check.
 *  
 * 
 * 
 * @author Andreas Hadjivasili
 * @since 31/1/19
 * 
 *
 */


public class SourceModel {


	

	private int count[][] = new int[26][26];
	private double probabilities[][] = new double[26][26];
	private String Modeltrain;
	private static int sum;
	private String modelname, filename;
	

	
	
	/**
	 * This is our only constructor that creates the SaurceModels that we are training.
	 * 
	 * This constructor is taking as inputs two  Strings: The first one is the Model name 
	 * and the second String is the name of the corpus file that we will train our Model.
	 * It continues reading  the corpus file using Scanner and it convert it into a String 
	 * with only letters and no spaces. After it creates a Matrix of the counts of how many
	 * times each letter was followed by the other letters. Later on it creates an other 
	 * Array with the probabilities of each letter followed by the others and if we did not 
	 * find somewhere a letter followed by one other (count = 0) then our probability it
	 * equals with 0.01 . 
 	 * 
 	 * 
	 * 
	 * @param mdname   It represents basically the name of the language (ex. English, Fortran,Spanish e.t.c)
	 * 
	 * @param flname   It represents the name of the corpus file (Its a text file for machine language learning) 
	 * 				   that we will train our Model.
	 * 
	 * @throws FileNotFoundException It throws this exception in case that the user give us as input a file name
	 * 								 that does not exist and we can not find the file that he mention.
	 * 
	 * 
	 * 
	 */
	
	
	public SourceModel(String mdname, String flname) throws FileNotFoundException {

		int length;
		int i, j, c = 0, a = 0, b = 0;

		modelname = mdname;
		filename = flname;

		File f = new File(filename);
		Scanner sc = new Scanner(f);
		sc.useDelimiter("\\Z");
		Modeltrain = sc.next();

		System.out.print("Training " + modelname + " model ...");

		Modeltrain = Modeltrain.replaceAll("\\W", "");
		length = Modeltrain.length();
		Modeltrain = Modeltrain.toLowerCase();

		for (i = 0; i < length - 1; i++) {
			for (j = 'a'; j <= 'z'; j++) {
				if (Modeltrain.charAt(i) == (char) j) {
					a = j - 'a';
				}
				if (Modeltrain.charAt(i + 1) == (char) j) {
					b = j - 'a';
				}

			}
			count[a][b]++;
		}

		for (i = 0; i < 26; i++) {
			sum = 0;

			for (j = 0; j < 26; j++) {
				sum = sum + count[i][j];

			}

			for (c = 0; c < 26; c++) {
				if ((count[i][c] == 0)) {
					probabilities[i][c] = 0.01;
				}

				else
					probabilities[i][c] = (double) count[i][c] / sum;
			}

		}

		System.out.println("done");

	}
	
	

	/**
	 * This is a get method that returns the name of the model.
	 * 
	 * @return the name of the model.
	 */
	
	
	
	public String getName() {
		return modelname;
	}

	
	
	
	/**
	 * This method calculate the probability of a String matching with the Model.
	 * 
	 * This method is responsible for taking as a parameter a String that its the String
	 * that the user give us as an input to check with which model it looks like matching.
	 * Then it takes this String and based on the array with the probabilities for the letters
	 * it calculates the final probability. 
	 * 
	 * @param test      its the String that the user give us as an input on the command line to 
	 * 					check with which model it looks like matching.
	 * 
	 * 
	 * @return It returns the probability this String matches with this Model.
	 * 
	 * 
	 */
	
	public double probability(String test) {

		int length, i, j, a = 0, b = 0;
		double prob = 1.0;

		System.out.println("Analyzing: " + test);

		test = test.replaceAll("\\W", "");
		length = test.length();
		test = test.toLowerCase();

		for (i = 0; i < length - 1; i++) {
			for (j = 'a'; j <= 'z'; j++) {
				if (test.charAt(i) == (char) j) {
					a = j - 'a';
				}
				if (test.charAt(i + 1) == (char) j) {
					b = j - 'a';
				}

			}

			prob = prob + Math.log10(probabilities[a][b]);
		}

		prob = Math.pow(10, prob); 

		

		return prob;

	}

	
	

	/**
	 * This is the toString method for the SourceModel object
	 * 
	 * It returns a String that is contain the model name and the file
	 * name that the model trained on.
	 * 
	 */
	
	public String toString() {

		return ("this model name is:  " + modelname + "  and it trained based on the file: " + filename);

	}
	
	
	

	/**
	 * This method is responsible for calculating the final probabilities.
	 * 
	 * This method is taking as a parameter an array that contains all the probabilities
	 * for each model that we had matching with the String that the user give us to check.
	 * But we have to print out to the user the probabilities summing to 1 so we also have
	 * to take probabilities and find the probability of each one to be the best match with
	 * the String.
	 * 
	 * @param x   An array that contains all the probabilities for each model that we had
	 * 			  matching with the String that the user give us to check.
	 * 
	 * @return    It returns an array with the final probabilities that we will print out.
	 * 
	 * 
	 */
	
	
	public static double[] calcFinalProb(double x[]) {
		double sum = 0;
		int i = 0;

		for (i = 0; i < x.length; i++) {
			sum = sum + x[i];
		}

		for (i = 0; i < x.length; i++) {
			x[i] = x[i] / sum;
		}
		return x;

	}

	
	
	/**
	 * This is the main method of the program.
	 * 
	 * This method is responsible for taking from the user as input the files that 
	 * we are going to use and the String that we have to check. Later it creates 
	 * the different SaurceModels by calling the constructor and makes an array 
	 * with them. Later we create also an array with the probabilities and we finally 
	 * call the class Print we the Print objects to print out to the user the final 
	 * results of our calculations. 
	 * 
	 * @param args It contains the inputs that the user give us at the command
	 * 			   line that contains the corpus files and the String that we 
	 * 			   are going to check.
	 * 
	 * 
	 * @throws FileNotFoundException  It throws this exception in case that the user give us as input a file name
	 * 								  that does not exist and we can not find the file that he mention.
	 * 
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		int i = 0;
		int le;
		String name;

		le = args.length;
		String testing = args[le - 1];
		double prob[] = new double[le - 1];

		Print[] f = new Print[le - 1];
		SourceModel[] s = new SourceModel[le - 1];

		for (i = 0; i < le - 1; i++) {
			name = args[i].split("\\.")[0];
			s[i] = new SourceModel(name, args[i]);
		}

		for (i = 0; i < le - 1; i++) {

			prob[i] = s[i].probability(testing);
		}

		prob = calcFinalProb(prob);

		for (i = 0; i < le - 1; i++) {

			f[i] = new Print(prob[i], s[i].getName());
			System.out.println(f[i]);

		}

		System.out.println(Print.Result(f));

	}

}
