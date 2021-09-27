package manager.admin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.StageStore;

public class Admin_Main extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		StageStore.stage = arg0;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_Main.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		Admin_Controller ctl = loader.getController();
		ctl.setRoot(root);

		arg0.setTitle("관리자 모드");
		arg0.setScene(scene);
		arg0.show();
	}
	//씬빌더 수정 필요

//	public static void main(String[] args) {
//		launch(args);
//	}
	
}
