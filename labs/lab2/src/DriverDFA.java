import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * file: DriverDFA.java
 * author: Weon Yuan
 * course: CMPT 440
 * assignment: Lab 2
 * due date: February 5, 2016
 * version: 1.0
 * 
 * This file serves as a driver for the user to interact with ManWolf.java.
 * 
*/
public class DriverDFA {
  
	public static void main(String[] args)
	    throws IOException {
		ManWolf mw = new ManWolf();  // DFA
		
		try {
		  // Read the input string and process it for validation
	    String s = args[0];
	    
		  mw.process(s);
		  if (mw.isCorrect()) {
		    System.out.println("This is a solution.");
		  } else {
		    System.out.println("This is not a solution."); 
		  }
		} catch (ArrayIndexOutOfBoundsException ex) {
		  // Called when no parameter (input string) is given
		  System.out.println("Please enter a valid string.");
		  System.out.println("Usage: java DriverDFA <string>");
		}

		// Gracefully exit the program
		System.exit(1);
	}

}
