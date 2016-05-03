import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EspabloDriver extends JPanel 
 implements KeyListener {
  
  private static final long serialVersionUID = 1L;
  public JTextPane textPane = new JTextPane();
  public JEditorPane editorPane = new JEditorPane();
  final public Color[] colors = {
    new Color(186, 218, 85),
    new Color(96, 189, 244),
    new Color(97, 97, 97)
  };
  
  public EspabloDriver() {
    setLayout(new BorderLayout());

    // Set up the text pane for coding (hah)
    textPane.setFont(new Font("Consolas", Font.PLAIN, 12));
    textPane.setBackground(new Color(51, 51, 51));
    textPane.setForeground(new Color(255, 255, 255));
    textPane.setCaretColor(new Color(255, 255, 255));
    JScrollPane paneScrollPane = new JScrollPane(textPane);
    paneScrollPane.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    paneScrollPane.setPreferredSize(new Dimension(320, 420));
    paneScrollPane.setMinimumSize(new Dimension(10, 10));
    
    // Set up the editor pane for logging
    editorPane.setFont(new Font("Consolas", Font.PLAIN, 12));
    editorPane.setBackground(new Color(51, 51, 51));
    editorPane.setForeground(new Color(255, 255, 255));
    JScrollPane editorScrollPane = new JScrollPane(editorPane);
    editorScrollPane.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    editorScrollPane.setPreferredSize(new Dimension(250, 420));
    editorScrollPane.setMinimumSize(new Dimension(10, 10));

    //Put everything together.
    JPanel leftPane = new JPanel(new BorderLayout());
    leftPane.add(paneScrollPane);
    leftPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
    JPanel rightPane = new JPanel(new GridLayout(1,0));
    rightPane.add(editorScrollPane);
    rightPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    add(leftPane, BorderLayout.LINE_START);
    add(rightPane, BorderLayout.LINE_END);
    
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
    String buffer = textPane.getText();
    EspabloDFA dfa = new EspabloDFA();
    dfa.process(buffer);
    
    if (buffer.length() > 0) {
      //renderStyles(htmlContent);
    }
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
    // epsilon
    validate();
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    // epsilon
  }

  @Override
  public void keyTyped(KeyEvent e) {
    
  }
}