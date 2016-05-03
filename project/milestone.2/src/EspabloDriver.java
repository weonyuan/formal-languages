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
 * for the Espablo compiler.
 *
 */

public class EspabloDriver extends JPanel 
 implements KeyListener {
  
  private static final long serialVersionUID = 1L;
  
  public static StyleContext sc = new StyleContext();
  final static DefaultStyledDocument doc = new DefaultStyledDocument(sc);
  public static JTextPane textPane = new JTextPane(doc);
  public JEditorPane editorPane = new JEditorPane();
  
  public static final Color[] colors = {
    Color.WHITE,
    new Color(186, 218, 85),
    new Color(96, 189, 244),
    new Color(200, 200, 200),
    new Color(255, 64, 64)
  };
  
  //Create and add the default style
  public Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
  public final Style mainStyle = sc.addStyle("MainStyle", defaultStyle);
  
  public EspabloDriver() {
    setLayout(new BorderLayout());

    StyleConstants.setLeftIndent(mainStyle, 5);
    StyleConstants.setRightIndent(mainStyle, 5);

    // Set up the text pane for coding (hah)
    textPane.setFont(new Font("Consolas", Font.PLAIN, 18));
    JScrollPane paneScrollPane = new JScrollPane(textPane);
    paneScrollPane.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    paneScrollPane.setPreferredSize(new Dimension(320, 420));
    paneScrollPane.setMinimumSize(new Dimension(10, 10));
    
    // Set the logical style
    doc.setLogicalStyle(0, mainStyle);

    // Put everything together.
    JPanel leftPane = new JPanel(new BorderLayout());
    leftPane.add(paneScrollPane);
    leftPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    add(leftPane, BorderLayout.LINE_START);
    
    textPane.addKeyListener(this);
  }

  /**
   * For thread safety,
   * this method should be invoked from the
   * event dispatch thread.
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

  public void validate() {
    EspabloDFA dfa = new EspabloDFA();
    dfa.process(textPane.getText());
  }
  
  public static void main(String[] args) {
    //Schedule a job for the event dispatching thread:
    //creating and showing this application's GUI.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }

  @Override
  public void keyReleased(KeyEvent e) {
    validate();
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    // epsilon
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // epsilon
  }
}