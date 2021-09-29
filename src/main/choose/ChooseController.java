package main.choose;

import common.commonStage.StageStore;
import javafx.scene.Parent;
import javafx.stage.Stage;
import main.loading.WaitingMain;
import main.order.OrderDB;
import main.order.OrderDTO;
import manager.commonMA.ManagerDTO;
import manager.stock.Stock_DB;



public class ChooseController {

	Parent root;
	Stage stage = StageStore.stage;
	WaitingMain loading;
	OrderDB db;
	OrderDTO orderDto ;
	ManagerDTO dto = OrderDTO.dto;
	Stock_DB stock;
	String fxmlName;
	
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void choose() {
		try {
			fxmlName = "choose.fxml";
			stage.close();
			stage = new Stage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
