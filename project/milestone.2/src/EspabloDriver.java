import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * @file EspabloDriver.java
 * @author Weon Yuan
 * @course CMPT 440
 * @assignment Project Milestone 2
 * @due date May 2, 2016
 * @version 1.0
 *
 * This file contains the driver or interface
 * for the Espablo text editor.
 *
 */

public class EspabloDriver extends JPanel 
 implements KeyListener {
  
  private static final long serialVersionUID = 1L;
  
  public static StyleContext sc = new StyleContext();
  final static DefaultStyledDocument doc = new DefaultStyledDocument(sc);
  public static JTextPane textPane = new JTextPane(doc);
  public JEditorPane editorPane = new JEditorPane();
  
  // Set color constants for highlighting
  public static final Color[] colors = {
    Color.WHITE,
    new Color(186, 218, 85),
    new Color(96, 189, 244),
    new Color(200, 200, 200),
    new Color(255, 64, 64)
  };
  
  // Create and add the default style
  public Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
  public final Style mainStyle = sc.addStyle("MainStyle", defaultStyle);
  
  public EspabloDriver() {
    setLayout(new BorderLayout());

    // Add side indents to the text pane
    StyleConstants.setLeftIndent(mainStyle, 5);
    StyleConstants.setRightIndent(mainStyle, 5);

    // Set up the text pane for coding (hah)
    textPane.setFont(new Font("Consolas", Font.PLAIN, 18));
    JScrollPane paneScrollPane = new JScrollPane(textPane);
    paneScrollPane.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    paneScrollPane.setPreferredSize(new Dimension(320, 500));
    paneScrollPane.setMinimumSize(new Dimension(10, 10));
    
    // Set the logical style
    doc.setLogicalStyle(0, mainStyle);

    // Put everything together
    JPanel pane = new JPanel(new BorderLayout());
    pane.add(paneScrollPane);
    pane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    add(pane, BorderLayout.LINE_START);
    
    // Add a key listener to the text pane for validation
    textPane.addKeyListener(this);
  }

  /**
   * createAndShowGUI
   * 
   * Responsible for generating a JFrame and creating
   * the UI for the Espablo editor.
   * 
   * @return none
   */
  private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("Espablo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Add content to the window.
    frame.add(new EspabloDriver());

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  /*
   * validate
   * 
   * Validates the content inside the text panel
   * through the DFA defined in the EspabloDFA class.
   * 
   * @return none
   */
  public void validate() {
    EspabloDFA dfa = new EspabloDFA();
    dfa.process(textPane.getText());
  }
  
  /*
   * main
   * 
   * Main method. Initiates the GUI for Espablo.
   * 
   * @return none
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }

  /*
   * keyReleased
   * 
   * Automatically generated. Called when a key
   * is released.
   * 
   * @return none
   */
  @Override
  public void keyReleased(KeyEvent e) {
    validate();
  }
  
  /*
   * keyPressed
   * 
   * Automatically generated. Called when a key
   * is pressed.
   * 
   * @return none
   */
  @Override
  public void keyPressed(KeyEvent e) {
    // epsilon
  }

  /*
   * keyTyped
   * 
   * Automatically generated. Called when a key
   * is typed.
   * 
   * @return none
   */
  @Override
  public void keyTyped(KeyEvent e) {
    // epsilon
  }
}