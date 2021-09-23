package manager.admin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
<<<<<<< HEAD
=======

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/*
public class Admin_Controller implements Initializable {
	private Parent root;
	private Object txtPassword;
*/	
	

>>>>>>> 13b49320d16001d8d8c672efec5de5dd6a05cb44
import javafx.stage.Stage;
import manager.chart.Chart_Main;
import manager.stock.StockMain;

public class Admin_Controller implements Initializable {
	
//}
	private Parent root;
	private Object txtPassword;
	StockMain sm ;
	Stage stage;
	Chart_Main cm;
<<<<<<< HEAD
=======

>>>>>>> 13b49320d16001d8d8c672efec5de5dd6a05cb44

	public void setRoot(Parent root) {
		this.root = root;
	};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		sm = new StockMain();
		cm = new Chart_Main();
		stage = new Stage();
	}

	public void StockBtn() {
try {
	sm.start(stage);
} catch (Exception e) {
	e.printStackTrace();
}

	}

	public void ChartBtn() {
		try {
			cm.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}