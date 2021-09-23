package order;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menuPan.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Controller ctl = loader.getController();
		ctl.setRoot(root);

		arg0.setScene(scene);
		arg0.setTitle("orderpage");
		arg0.show();
	}
}
