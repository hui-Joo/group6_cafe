package main.pay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.StageStore;

public class PayMain extends Application {
	public void start(Stage primaryStage) throws Exception {
		StageStore.stage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("pay.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		PayController ctl = loader.getController();
		ctl.setRoot(root);
		
		primaryStage.setTitle("결제 화면");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
