package main.choose;

import common.commonStage.StageStore;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChooseMain extends Application {
	public void start(Stage primaryStage) throws Exception {
		StageStore.stage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseA.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		ChooseController ctl = loader.getController();
		ctl.setRoot(root);
		
		primaryStage.setTitle("선택 화면");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
