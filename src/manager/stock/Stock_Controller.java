package manager.stock;

import java.net.URL;
import java.util.ResourceBundle;

import common.commonDB.DBClass;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class Stock_Controller implements Initializable {
	public static DBClass db;
	Stock_serviceimpl sv;
	private Parent root;

	public void setRoot(Parent root) {
		this.root = root;
		sv.selectlabel(root);
	}

	public void warningalert() {
		sv.warning();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new DBClass();
		sv = new Stock_serviceimpl();
	}

	public void beanbtn() {
		sv.updateBean(root);
	}

	public void milkbtn() {
		sv.updateMilk(root);
	}

	public void waterbtn() {
		sv.updateWater(root);
	}

	public void syrupbtn() {
		sv.updateVanila(root);
	}

}
