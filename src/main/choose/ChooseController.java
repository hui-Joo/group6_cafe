package main.choose;

import common.commonStage.StageStore;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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
	int ice = 0;
	int size = 0;
	int total = 0;
	
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void chooseA() {
		
		
	}
	
	public void hot() {
		System.out.println("HOT");
	}
	
	public void ice() {
		System.out.println("ICE");
		ice = 1;
		
	}
	
	public void small() {
		
	}
	
	public void reguler() {
		size = 1;
		
	}
	
	public void large() {
		size = 2;
		
	}
	
}
