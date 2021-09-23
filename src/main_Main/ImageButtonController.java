package main_Main;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ImageButtonController extends Initializable{
	
	public void start(Stage primaryStage) throws Exception{
	
		ImageButtonController imageController = new ImageButtonController();
		primaryStage.setScene(new Scene(imageController));
		primaryStage.setTitle("Image Button Test");
		primaryStage.show();
	}


	public void button() {
		launch();
	}
}

