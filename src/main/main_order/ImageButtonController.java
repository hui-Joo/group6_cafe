package main_Main;


import javafx.application.Application;

public class ImageButtonController implements Initializable {

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	public void handleButtonLogin(ActionEvent ae){

		   try{

		        Parent login = FXMLLoader.load(getClass().getResource("admin_login.fxml");

		        Scene scene = new Scene(login);

		        primaryStage.setScene(scene);

		   }catch(Exception e){

		      e.printStackTrace();

		  }

		}

}
