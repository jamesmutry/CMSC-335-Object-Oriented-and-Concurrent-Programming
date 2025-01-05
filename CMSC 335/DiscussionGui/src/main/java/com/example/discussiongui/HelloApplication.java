package com.example.discussiongui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
@Override
public void start(Stage primaryStage) {
    // Create a TextArea
    TextArea textArea = new TextArea();
    textArea.setPromptText("Enter your text here...");

    // Create CheckBoxes
    CheckBox checkBox1 = new CheckBox("Option 1");
    CheckBox checkBox2 = new CheckBox("Option 2");

    // Create RadioButtons and a ToggleGroup
    RadioButton radioButton1 = new RadioButton("Choice A");
    RadioButton radioButton2 = new RadioButton("Choice B");
    ToggleGroup radioGroup = new ToggleGroup();
    radioButton1.setToggleGroup(radioGroup);
    radioButton2.setToggleGroup(radioGroup);

    // Create a Submit Button
    Button submitButton = new Button("Submit");

    // Layout setup
    VBox vbox = new VBox(10); // 10 is the spacing between elements
    HBox radioBox = new HBox(10); // Horizontal box for radio buttons
    radioBox.getChildren().addAll(radioButton1, radioButton2);
    vbox.getChildren().addAll(textArea, checkBox1, checkBox2, radioBox, submitButton);

    // Set up the Scene and Stage
    Scene scene = new Scene(vbox, 300, 250);
    primaryStage.setTitle("Simple JavaFX GUI");
    primaryStage.setScene(scene);
    primaryStage.show();
}

public static void main(String[] args) {
    launch(args);
}
}