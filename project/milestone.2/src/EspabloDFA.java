/**
 * @file EspabloDFA.java
 * @author Weon Yuan
 * @course CMPT 440
 * @assignment Project Milestone 2
 * @due date May 2, 2016
 * @version 1.0
 *
 * This file contains an abstract class of the DFA
 * for the Espablo compiler.
 *
 */

public class EspabloDFA {
  
  // Constants q0 through q43 represent possible states
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
  private static final int q11 = 11;
  private static final int q12 = 12;
  private static final int q13 = 13;
  private static final int q14 = 14;
  private static final int q15 = 15;
  private static final int q16 = 16;
  private static final int q17 = 17;
  private static final int q18 = 18;
  private static final int q19 = 19;
  private static final int q20 = 20;
  private static final int q21 = 21;
  private static final int q22 = 22;
  private static final int q23 = 23;
  private static final int q24 = 24;
  private static final int q25 = 25;
  private static final int q26 = 26;
  private static final int q27 = 27;
  private static final int q28 = 28;
  private static final int q29 = 29;
  private static final int q30 = 30;
  private static final int q31 = 31;
  private static final int q32 = 32;
  private static final int q33 = 33;
  private static final int q34 = 34;
  private static final int q35 = 35;
  private static final int q36 = 36;
  private static final int q37 = 37;
  private static final int q38 = 38;
  private static final int q39 = 39;
  private static final int q40 = 40;
  private static final int q41 = 41;
  private static final int q42 = 42;
  private static final int q43 = 43;
  private static final int q44 = 44;
  private static final int q45 = 45;
  private static final int q46 = 46;
  private static final int q47 = 47;
  private static final int q48 = 48;
  private static final int q49 = 49;
  
  private static int currentState = q0;
  
  private static int [][] navDFA =
  {
    {q27, q27, q27, q27, q27, q27, q27, q27, q27, q27, q27, q27, q27, q27, q27,  q1, q27, q27, q27, q27, q27, q22, q27, q27, q27, q27, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q41, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49,  q2, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q28},
    {q49, q49, q49, q49, q49, q49, q49, q49,  q3, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49,  q4, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49,  q5, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49,  q6},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49,  q7, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49,  q8},
    {q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13,  q9,  q9,  q9,  q9,  q9,  q9,  q9,  q9,  q9,  q9, q49, q49, q15, q49, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q10},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q11, q49, q49, q49, q49, q12, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49,  q8},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q14},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q12, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q16},
    {q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q21},
    {q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q18},
    {q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q19, q49, q49, q49, q49, q18},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q20},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q12, q49, q49},
    {q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q17, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q18},
    {q23, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q28},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q24, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q25},
    {q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q26, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q26},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q28},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q33, q49, q49, q49, q29, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q30},
    {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q31, q31, q31, q31, q31, q31, q31, q31, q31, q31, q49, q49, q35, q49, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q32},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q33, q49, q49, q49, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q30},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q36},
    {q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q40},
    {q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q38},
    {q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q39, q49, q49, q49, q49, q38},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49},
    {q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q37, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q38},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q42, q49, q49, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q43},
    {q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q48},
    {q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q45},
    {q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q46, q49, q49, q49, q49, q49, q45},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q47, q49, q49, q49, q49},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49},
    {q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q44, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q44},
    {q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49, q49}  
  };
  
  public void process(String input) {
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      int moveInput = -1;
      
      if (c - 'a' >= 0 && c - 'a' <= 25) {
        // Character is {a-z}
        System.out.println("character");
        moveInput = c - 'a';
      } else if (c - '0' >= 0 && c - '0' <= 9) {
        // Character is {0-9}
        System.out.println("integer");
        moveInput = (c - '0') + 26;
      } else if (c == '+') {
        // Character is a plus sign
        System.out.println("plus");
        moveInput = 36;
      } else if (c == '-') {
        // Character is a minus sign
        System.out.println("minus");
        moveInput = 37;
      } else if (c == '"') {
        // Character is a double quote
        System.out.println("quote");
        moveInput = 38;
      } else if (c == '*') {
        // Character is an asterisk
        System.out.println("asterisk");
        moveInput = 39;
      } else if (c == '(') {
        // Character is an open paren
        System.out.println("open paren");
        moveInput = 40;
      } else if (c == ')') {
        // Character is a closed paren
        System.out.println("closed paren");
        moveInput = 41;
      } else if (c == '=') {
        // Character is an equal sign
        System.out.println("equal");
        moveInput = 42;
      } else if (c == ' ') {
        // Character is a whitespace
        System.out.println("whitespace");
        moveInput = 43;
      }
      
      try {
        currentState = navDFA[currentState][moveInput];
        System.out.println(c + " " + currentState);
        System.out.println();
      } catch (ArrayIndexOutOfBoundsException ex) {
        currentState = q43;
      }
      
    }
  }
}