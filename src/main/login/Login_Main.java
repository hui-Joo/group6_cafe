package main.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login_Main extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_login.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		LoginController ctl = loader.getController();
		ctl.setRoot(root);

		arg0.setScene(scene);
		arg0.setTitle("관리자 로그인");
		arg0.show();

	}

}
