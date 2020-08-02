package com.practice.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Stage - Top Level Window. Can also be rectangular area in case of applet. Can also be full screen itself.
 * Scene - A stage must hold a scene. A scene must reside in a stage. A scene holds all the graphical components,
 * shapes, etc..
 * show() - called on stage to display the Stage*/

public class SimpleApplication extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// a simple UI
		
		//javacontrol.label
		Label label1 = new Label("Hello World!");
		label1.setFont(new Font(100));
		//primaryStage.setScene(new Scene(label1));
		
		Label label2 = new Label("Hello World!");
		label2.setFont(new Font(100));
		
		//java.scene.layout.VBox
		VBox vbox = new VBox(label1, label2);
		
		primaryStage.setScene(new Scene(vbox));
		primaryStage.setTitle("Hello");
		primaryStage.show(); // display UI on screen
	}

}
