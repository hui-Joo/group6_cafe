package manager.chart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Chart_Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("chart_Main.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		Chart_Controller ctl = loader.getController();
		ctl.setRoot(root);

		arg0.setScene(scene);
		arg0.setTitle("카페 차트");
		arg0.show();
	}
}
