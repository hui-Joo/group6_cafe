package stock;

import java.net.URL;
import java.util.ResourceBundle;

import commonDB.DBClass;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class Stock_Controller implements Initializable {
	public static DBClass db;
	Stock_serviceimpl sv;

	private Parent root;

	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new DBClass();
		sv = new Stock_serviceimpl();
	}
	public void beanbtn() {
		sv.insertBean(root);
		
	}

	public void milkbtn() {
	}

	public void waterbtn() {
	}

	public void syrupbtn() {
	}

}
