package main_Main;


import javafx.application.Application;

public class PayController implements Initializable {

	
//	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	public void start(Stage primaryStage) throws Exception {

		   primaryStage.setTitle("결제 화면");

		   Parent root = FXMLLoader.load(getClass().getResource("pay.fxml");

		   Scene scene = new Scene(root);

		   primaryStage.setScene(scene);

		   primaryStage.show();

		}
	public void PayController(ActionEvent ae){

		   try{

		        Parent pay = FXMLLoader.load(getClass().getResource("payment.fxml");

		        Scene scene = new Scene(payment);

		        primaryStage.setScene(scene);

		   }catch(Exception e){

		      e.printStackTrace();

		  }

		}
}