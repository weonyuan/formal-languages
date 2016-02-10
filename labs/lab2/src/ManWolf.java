/**
 * file: ManWolf.java
 * author: Weon Yuan
 * course: CMPT 440
 * assignment: Lab 2
 * due date: February 5, 2016
 * version: 1.0
 * 
 * This file contains an abstract class of the man-wolf-goat-cabbage problem.
 * 
*/

public class ManWolf {
  
  // Constants q0 through q10 represent possible states
  private static final int q0 = 0;
  private static final int q1 = 1;
  private static final int q2 = 2;
  private static final int q3 = 3;
  private static final int q4 = 4;
  private static final int q5 = 5;
  private static final int q6 = 6;
  private static final int q7 = 7;
  private static final int q8 = 8;
  private static final int q9 = 9;
  private static final int q10 = 10;
  
  // Initialize the current state to the starting state
  private int currentState = 0;
  
  /* 
   * Transition function expressed as an array.
   */
  static private int[][] delta =
      {
        {}
      };
  
  static void process(String input) {
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i++);
      //currentState = delta[state, c];
    }
  }
}
