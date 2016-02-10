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
  private static final int q9 = 9;    // accepted state
  private static final int q10 = 10;  // error state
  
  // Constants that represent the movable objects in this problem
  // which will be used to navigate through the delta array
  private static final int CABBAGE = 0;
  private static final int GOAT = 1;
  private static final int MAN = 2;
  private static final int WOLF = 3;
  
  // Initialize the current state to the starting state
  private static int currentState = 0;
  
  /* 
   * Transition function expressed as an array.
   */
  static private int[][] delta =
      {
        {q10,  q1, q10,  q10},
        {q10,  q0,  q2,  q10},
        { q4, q10,  q1,   q3},
        {q10,  q5, q10,   q2},
        { q2,  q6, q10,  q10},
        { q7,  q3, q10,  q10},
        {q10,  q4, q10,   q7},
        { q5, q10,  q8,   q6},
        {q10,  q9,  q7,  q10},
        {q10,  q8, q10,  q10},
        {q10, q10, q10,  q10}
      };
  
  public void process(String input) {
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      int moveObject;
      
      switch (c) {
        case 'c':
          moveObject = CABBAGE;
          break;
        case 'g':
          moveObject = GOAT;
          break;
        case 'm':
          moveObject = MAN;
          break;
        case 'w':
          moveObject = WOLF;
          break;
        default:
          moveObject = -1;
          break;
      }
      try {
        currentState = delta[currentState][moveObject];
      } catch (ArrayIndexOutOfBoundsException ex) {
        currentState = q10;         
      }
    }
  }
  
  public boolean isCorrect() {
    return currentState == q9;
  }
}
