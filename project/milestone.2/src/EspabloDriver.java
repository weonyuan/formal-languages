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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EspabloDriver extends Application {

  final public HTMLEditor htmlEditor = new HTMLEditor();
  
  @Override
  public void start(Stage stage) {
    stage.setTitle("Espablo");
    stage.setWidth(400);
    stage.setHeight(300);
    
    htmlEditor.setPrefHeight(245);
    htmlEditor.setOnKeyReleased(new EventHandler<KeyEvent>() {
      private String buffer = "";
      
      @Override
      public void handle(KeyEvent event) {
        buffer = htmlEditor.getHtmlText().replaceAll("\\<[^>]*>", "");
        buffer = buffer.replace("&nbsp;", " ");
        System.out.println(buffer);
        validate(buffer);
      }
    });
    
    renderStyles("");
    
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
          System.out.println(htmlEditor.getHtmlText());
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
    
    Scene scene = new Scene(layout);
    
    stage.setScene(scene);
    stage.show();
  }
  
  public void renderStyles(String input) {
    String htmlContent =
        "<body style=\"background-color: #212121;"
        +             "color: #FFFFFF;"
        +             "font-family: Consolas;"
        +             "font-size: 10pt;\">";
    htmlContent += input;
    htmlContent += "</body>";
    htmlEditor.setHtmlText(htmlContent);
  }
  
  public void validate(String buffer) {
    String htmlContent = "";
    EspabloDFA dfa = new EspabloDFA();
    htmlContent = dfa.process(buffer);
    renderStyles(htmlContent);
  }
  
  public String openFile(String filename) {    
    try {
      String data = "<div>";
      
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line = reader.readLine();
      
      while (line != null) {
        if (line.contains("\t")) {
          // Replace the tab characters for whitespaces
          line = line.replace("\t", "&nbsp;&nbsp;");
        }
        data += line + "</div>";
        line = reader.readLine();
      }
      
      reader.close();
      
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
  }

}