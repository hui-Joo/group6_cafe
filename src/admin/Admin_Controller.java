package admin;

import java.net.URL;
import java.util.ResourceBundle;

import adminDB.Admin_DB;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class Admin_Controller implements Initializable {
	private Parent root;
	public static Admin_DB db;

	public void setRoot(Parent root) {
		this.root = root;
	};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new Admin_DB();
	}

	public void StockBtn() {
		db.insert();

	}

	public void ChartBtn() {
		db.select();
	}
}
