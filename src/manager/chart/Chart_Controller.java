package manager.chart;

import java.net.URL;
import java.util.ResourceBundle;

import common.commonDB.DBClass;
import common.commonStage.StageStore;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import manager.commonMA.ManagerDTO;

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
		chartImpl.setRoot(root);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new common.commonDB.DBClass();
		chartDB = new Chart_DB();
		chartImpl = new Chart_Impl();
		
	}

	public void clickOpen() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
			Parent clickRoot = loader.load();
			Scene scene = new Scene(clickRoot);
			
			stage=StageStore.stage;
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickMenuChart() {

		try {
			fxmlName="chart_Menu.fxml";
			stage = new Stage();
			clickOpen();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void clickHISChart() {
		try {
			fxmlName="chart_HIS.fxml";
			stage=new Stage();
			chartImpl.HISChart(root);
			clickOpen();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickTotalChart() {
		try {
			fxmlName = "chart_Total.fxml";
			stage=new Stage();
			clickOpen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
