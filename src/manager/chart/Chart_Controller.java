package manager.chart;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class Chart_Controller implements Initializable {

	Parent root;
	public static common.commonDB.DBClass db;
	private Chart chartImpl;


	public void setRoot(Parent root) {
		this.root = root;
		chartImpl.chart(root);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new common.commonDB.DBClass();
		chartImpl = new Chart_Impl();
		
	}

}
