package oder;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Controller implements Initializable{
	@FXML Button americano, latte, cappuccino, vanilla;
	private Parent root;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}	
	Button btn = new Button();
	
		
	
}
