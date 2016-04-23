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
  
  private static int currentState = q0;
  
  private static int [][] navDFA =
  {
    {q25, q25, q25, q25, q25, q25, q25, q25, q25, q25, q25, q25, q25, q25, q25,  q1, q25, q25, q25, q25, q25, q20, q25, q25, q25, q25, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q37, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43,  q2, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q26},
    {q43, q43, q43, q43, q43, q43, q43, q43,  q3, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43,  q4, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43,  q5, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43,  q6},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43,  q7, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43,  q8},
    {q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13, q13,  q9,  q9,  q9,  q9,  q9,  q9,  q9,  q9,  q9,  q9, q43, q43, q15, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q10},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q11, q43, q43, q43, q43, q12, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43,  q8},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q14},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q12, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q16},
    {q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q17},
    {q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q16, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q18, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q19},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q12, q43, q43},
    {q21, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q26},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q22, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q23},
    {q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q24, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q26},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q27, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q28},
    {q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q32, q29, q29, q29, q29, q29, q29, q29, q29, q29, q29, q43, q43, q33, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q30},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q31, q43, q43, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q28},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q34},
    {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q35},
    {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q34, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q36, q43, q43, q43, q43, q35},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q38, q43, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q39},
    {q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q40},
    {q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q39, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q41, q43, q43, q43, q43, q43, q40},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q42, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43},
    {q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43, q43}  
  };
  
  public void process(String input) {
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      int moveInput = -1;
      
      if (c - 'a' >= 0 && c - 'a' <= 25) {
        // Character is {a-z}
        moveInput = c - 'a';
      } else if (c - '0' >= 0 && c - '0' <= 9) {
        // Character is {0-9}
        moveInput = c - '0';
      } else if (c == '+') {
        // Character is a plus sign
        moveInput = 36;
      } else if (c == '-') {
        // Character is a minus sign
        moveInput = 37;
      } else if (c == '"') {
        // Character is a double quote
        moveInput = 38;
      } else if (c == '*') {
        // Character is an asterisk
        moveInput = 39;
      } else if (c == '(') {
        // Character is an open paren
        moveInput = 40;
      } else if (c == ')') {
        // Character is a closed paren
        moveInput = 41;
      } else if (c == '=') {
        // Character is an equal sign
        moveInput = 42;
      } else if (c == ' ') {
        // Character is a whitespace
        moveInput = 43;
      }
      
      try {
        currentState = navDFA[currentState][moveInput];
        System.out.println(currentState);
      } catch (ArrayIndexOutOfBoundsException ex) {
        currentState = q43;
      }
      
    }
  }
}