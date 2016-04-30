/**
 * @file EspabloDriver.java
 * @author Weon Yuan
 * @course CMPT 440
 * @assignment Project Milestone 2
 * @due date May 2, 2016
 * @version 1.0
 *
 * This file serves as the driver for the user to interact
 * with the Espablo compiler.
 *
 */

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EspabloDriver extends Application {

  private Desktop desktop = Desktop.getDesktop();
  
  @Override
  public void start(Stage stage) {
    stage.setTitle("Espablo");
    stage.setWidth(400);
    stage.setHeight(300);
    
    final HTMLEditor htmlEditor = new HTMLEditor();
    htmlEditor.setPrefHeight(245);
    htmlEditor.setStyle("background-color: #000;");
    System.out.println(htmlEditor.getStyle());
    
    /*-- Set up menu bar --*/
    VBox optionPane = new VBox(10);
    MenuBar menuBar = new MenuBar();
    
    Menu menuFile = new Menu("File");
    
    /*-- New file menu item --*/
    MenuItem newFile = new MenuItem("New");
    FileChooser fileChooser = new FileChooser();
    
    /*-- Load file menu item --*/
    MenuItem loadFile = new MenuItem("Load");
    loadFile.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(final ActionEvent t) {
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
          htmlEditor.setHtmlText(openFile(file.getAbsolutePath()));
        }
      }
    });
    /*-- Save file menu item --*/
    MenuItem saveFile = new MenuItem("Save");

    /*-- Exit menu item --*/
    MenuItem exit = new MenuItem("Exit");
    exit.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(final ActionEvent t) {
        System.exit(1);
      }
    });
    
    menuFile.getItems().addAll(newFile, loadFile, saveFile, exit);
    
    Menu menuEdit = new Menu("Edit");
    
    Menu menuHelp = new Menu("Help");
    
    menuBar.getMenus().addAll(menuFile, menuEdit, menuHelp);
    optionPane.getChildren().addAll(menuBar);
    
    BorderPane layout = new BorderPane();
    layout.setTop(optionPane);
    layout.setCenter(htmlEditor);
    stage.setScene(new Scene(layout));
    stage.show();
  }
  
  public String openFile(String filename) {
    System.out.println(filename);
    String data = "<body style=\"background-color: gray;\"";
    
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line = null;
      
      while ((line = reader.readLine()) != null) {
        if (line.contains("\t")) {
          // Replace the tab characters for whitespaces
          line = line.replace("\t", "&nbsp;&nbsp;");
        }
        data += line + "<br />";
      }
      
      return data;
    } catch (IOException ex) {
      Logger.getLogger(
        EspabloDriver.class.getName(), null).log(
          Level.SEVERE, null, ex
      );
      
      return null;
    }
  }
  
  public static void main(String[] args) {
    launch(args);
    
    //EspabloDFA dfa = new EspabloDFA();
    //dfa.process("p = \"  \"");
  }

}