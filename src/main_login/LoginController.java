package main_login;

import java.awt.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private Label lblStatus;

	private TextField txtUserName;

	private TextField txtPassword;

	public void Login(ActionEvent event) throws Exception {
		try {

			if (txtUserName.getText().equals("user") && txtPassword.getText().equals("pass")) {
				lblStatus.setText("Login Success");
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/main/admin_login.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
<<<<<<< HEAD:src/main_login/LoginController.java
	/*
	public void main(String[] args) {
		launch(args);
	}
	*/
=======

>>>>>>> e664a404303716519fc4ffce39ff3cfba8354e4d:src/main/LoginController.java
}
