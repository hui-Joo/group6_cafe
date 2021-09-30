package main.loading;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import common.commonStage.StageStore;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WaitingMain extends Application {

	public void start(Stage primaryStage) throws Exception {
		StageStore.stage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("loading.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		WaitController ctl = loader.getController();
		ctl.setRoot(root);

		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	

}
