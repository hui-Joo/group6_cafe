//package main;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class MainClass extends Application{
//	
//	public void start(Stage primaryStage) throws Exception{
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("coffee_loading.fxml"));
//		Parent root = loader.load();
//		
//		Controller con = loader.getController();
//		con.setRoot(root);
//		Scene scene = new Scene(root);
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//}
//////