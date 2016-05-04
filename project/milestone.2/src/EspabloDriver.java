import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
 implements ActionListener, KeyListener {
  
  private static final long serialVersionUID = 1L;
  
  public static StyleContext sc = new StyleContext();
  final static DefaultStyledDocument doc = new DefaultStyledDocument(sc);
  public static JTextPane textPane = new JTextPane(doc);
  public JEditorPane editorPane = new JEditorPane();
  public static JMenuBar menuBar = new JMenuBar();
  
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

    // Set up the menu bar
    JMenu menuFile = new JMenu("File");
    menuBar.add(menuFile);
    
    /*-- New file menu item --*/
    JMenuItem newFile = new JMenuItem("New");
    KeyStroke ctrlN = KeyStroke.getKeyStroke(KeyEvent.VK_N,
      Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
    newFile.setAccelerator(ctrlN);
    newFile.addActionListener(this);
    menuFile.add(newFile);
    
    /*-- Load file menu item --*/
    JMenuItem loadFile = new JMenuItem("Load");
    KeyStroke ctrlO = KeyStroke.getKeyStroke(KeyEvent.VK_O,
      Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
    loadFile.setAccelerator(ctrlO);
    loadFile.addActionListener(this);
    menuFile.add(loadFile);
    
    /*-- Save file menu item --*/
    JMenuItem saveFile = new JMenuItem("Save");
    KeyStroke ctrlS = KeyStroke.getKeyStroke(KeyEvent.VK_S,
      Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
    saveFile.setAccelerator(ctrlS);
    saveFile.addActionListener(this);
    menuFile.add(saveFile);
    
    /*-- Exit menu item --*/
    JMenuItem exit = new JMenuItem("Exit");
    exit.addActionListener(this);
    menuFile.add(exit);
    
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
    frame.setJMenuBar(menuBar);
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

  /*
   * actionPerformed
   * 
   * Automatically generated. Called when a menu
   * item is selected.
   * 
   * @return none
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    
    if (command == "New") {
      // If there is content in the text pane, pop up a save confirmation
      if (textPane.getText().length() > 0) {
        int dialog = JOptionPane.showConfirmDialog(null, "This file has been modified. Save changes?");
        if (dialog == JOptionPane.YES_OPTION) {
          JFileChooser fileChooser = new JFileChooser();
          fileChooser.setDialogTitle("Save File");
          int fileDialog = fileChooser.showSaveDialog(null);
          if (fileDialog == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            saveFile(file);
            
            // Clear the text pane after saving
            textPane.setText("");
          }
        } else if (dialog == JOptionPane.NO_OPTION) {
          // The user chose not to save the file
          textPane.setText("");
        }
      } else {
        // Otherwise, just clear the text pane
        textPane.setText("");
      }
    } else if (command == "Load") {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setDialogTitle("Open File");
      int fileDialog = fileChooser.showOpenDialog(null);
      if (fileDialog == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        textPane.setText(openFile(file.getAbsolutePath()));
        validate();
      }
    } else if (command == "Save") {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setDialogTitle("Save File");
      int fileDialog = fileChooser.showSaveDialog(null);
      if (fileDialog == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        saveFile(file);
      }
    } else if (command == "Exit") {
      System.exit(1);
    }
  }
  
  /*
   * openFile
   * 
   * Opens the content of a text file and
   * writes them char by char into the text pane.
   * 
   * @param filename the filename
   * @return none
   */
  public String openFile(String filename) {    
    try {
      String data = "";
      
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line = reader.readLine();
      
      while (line != null) {
        data += line + "\n";
        
        // Read the next line
        line = reader.readLine();
      }
      
      reader.close();
      
      return data;
    } catch (IOException ex) {
      ex.printStackTrace();
      
      return null;
    }
  }
  
  /*
   * saveFile
   * 
   * Writes the content from the text pane over
   * to the destined filename.
   * 
   * @param file the File object
   * @return none
   */
  public void saveFile(File file) {    
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      writer.write(textPane.getText());
      writer.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}