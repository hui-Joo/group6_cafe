package manager.stock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StockMain extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("stock.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		Stock_Controller ctl = loader.getController();
		ctl.setRoot(root);

		arg0.setScene(scene);
		arg0.setTitle("재고 관리창");
		arg0.show();
		ctl.warningalert();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
