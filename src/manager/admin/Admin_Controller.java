package manager.admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import manager.chart.Chart_Main;
import manager.stock.StockMain;
import main.*;

public class Admin_Controller implements Initializable {

	private Parent root;
	StockMain sm;
	Stage stage;
	Chart_Main cm;
	MainClass main;

	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		sm = new StockMain();
		cm = new Chart_Main();
		stage = new Stage();
		main = new MainClass();
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
	
	public void ReturnBtn() {
		try {
			stage = StageStore.stage;
			stage.close();
			stage = new Stage();
			main.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
