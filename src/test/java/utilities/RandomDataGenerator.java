package utilities;
import java.util.Random;
import java.math.*;

public class RandomDataGenerator {

	/*
	 * This class holds all the methods and variables which are required to generate random data 
	 */
	
	Random rand;
	
	
	int randomNumber() {
		int number = rand.nextInt();
		return number;
	}
	
	/*static String randomAlphaString() {
		//String randomString = rand;
		//return randomString;
	}
	*/
	
	public static void main(String[] args) { 
		//System.out.println(randomAlphaString());
	}
}
