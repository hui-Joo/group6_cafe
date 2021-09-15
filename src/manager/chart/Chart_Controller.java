package manager.chart;

import java.net.URL;
import java.util.ResourceBundle;

import commonDB.DBClass;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class Chart_Controller implements Initializable {

	Parent root;
	public static DBClass db;
	private Chart chartImpl;


	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new DBClass();
		chartImpl = new Chart_Impl();
		chartImpl.chart(root);
	}

}
