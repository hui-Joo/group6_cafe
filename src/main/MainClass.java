
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.order.OrderController;

public class MainClass extends Application {

	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("./order/order_Main.fxml"));
		Parent root = loader.load();

		OrderController con = loader.getController();
		con.setRoot(root);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("orderpage");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
