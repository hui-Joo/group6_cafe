package manager.chart;

import java.net.URL;
import java.util.ResourceBundle;

import common.commonStage.StageStore;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Chart_Controller implements Initializable {

	Parent root;
	public static common.commonDB.DBClass db;
	private Chart_DB chartDB;
	private Chart chartImpl;
	
	Chart_Main cahrtmain;
	Stage stage = StageStore.stage;
	String fxmlName;
	


	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new common.commonDB.DBClass();
		chartDB = new Chart_DB();
		chartImpl = new Chart_Impl();
		
	}
	
	public void clickMenuChart() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("chart_Menu.fxml"));
		try {
			root=loader.load();
			chartImpl.menuChart(root);
			Scene scene = new Scene(root);
			stage= new Stage();
			stage.setScene(scene);
			stage.setTitle("chart_Menu");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickHISChart() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("chart_HIS.fxml"));
		try {
			root=loader.load();
			chartImpl.HISChart(root);
			Scene scene = new Scene(root);
			stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("chart_Hot/Ice,Size");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickTotalChart() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("chart_Total.fxml"));
		try {
			root=loader.load();
			chartImpl.totalChart(root);
			Scene scene = new Scene(root);
			stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("chart_Total");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
