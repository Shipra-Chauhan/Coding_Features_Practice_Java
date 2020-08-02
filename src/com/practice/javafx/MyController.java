package com.practice.javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MyController implements Initializable {
	
	@FXML
	private TextField username;
	
	@FXML
	private PasswordField password;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void okAction(ActionEvent event) {
		System.out.println("Ok Clicked : "+username.getText());

	}

	public void cancelAction(ActionEvent event) {
		System.out.println("Cancel Clicked "+ password.getText());
	}

}
