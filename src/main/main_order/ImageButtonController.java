package main.main_order;


import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

public class ImageButtonController implements Initializable {

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	public void handleButtonLogin(ActionEvent ae){

		   try{

		        Parent login = FXMLLoader.load(getClass().getResource("admin_login.fxml");

		        Scene scene = new Scene(login);

		        primaryStage.setScene(scene);

		   }catch(Exception e){

		      e.printStackTrace();

		  }

		}

}
