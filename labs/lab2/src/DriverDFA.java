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
 * This file contains an abstract class of the man-wolf-goat-cabbage problem.
 * 
*/
public class DriverDFA {
  
	public static void main(String[] args)
	    throws IOException {
		ManWolf mw = new ManWolf();  // The DFA
		
		try {
		  // Read and echo lines until EOF
	    String s = args[0];
	    
		  mw.process(s);
		  if (mw.isCorrect()) {
		    System.out.println("This is a solution.");
		  } else {
		    System.out.println("This is not a solution."); 
		  }
		} catch (ArrayIndexOutOfBoundsException ex) {
		  System.out.println("Please enter a valid string.");
		  System.out.println("Usage: java DriverDFA <string>");
		}

		System.exit(1);
	}

}
