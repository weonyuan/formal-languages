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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class EspabloDriver extends Application {

  @Override
  public void start(Stage stage) {
    stage.setTitle("Espablo");
    stage.setWidth(400);
    stage.setHeight(300);
    
    final HTMLEditor htmlEditor = new HTMLEditor();
    htmlEditor.setPrefHeight(245);
    
    htmlEditor.setStyle(
      ""
    );
    
    Scene scene = new Scene(htmlEditor);
    stage.setScene(scene);
    stage.show();
  }
  
  public static void main(String[] args) {
    //launch(args);
    EspabloDFA dfa = new EspabloDFA();
    
    dfa.process("*- pablo is the man -*");
  }

}
