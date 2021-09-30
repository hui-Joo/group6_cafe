package main.pay;


import java.net.URL;
import java.util.ResourceBundle;

import common.commonStage.StageStore;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.loading.WaitingMain;
import main.order.OrderDB;
import main.order.OrderDTO;
import manager.commonMA.ManagerDTO;

public class PayController implements Initializable {
	
	Parent root;
	Stage stage = StageStore.stage;
	WaitingMain loading;
	OrderDB db;
	OrderDTO orderDto ;
	ManagerDTO dto = OrderDTO.dto;
	String fxmlName;
	
	public void setRoot(Parent root) {
		this.root = root;
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		loading = new WaitingMain();
		db = new OrderDB();
		orderDto = new OrderDTO();

	}

	public void newOpen() {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
		Parent clickRoot = loader.load();
		Scene scene = new Scene(clickRoot);
		stage = StageStore.stage;
		
		stage.setTitle("결제 화면");
		stage.setScene(scene);
		stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickCard() {
		try {
			fxmlName = "payment.fxml";
			stage.close();
			stage = new Stage();
			newOpen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickKakao() {
		try {
			fxmlName = "payment_kakao.fxml";
			stage.close();
			stage = new Stage();
			newOpen();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void clickPayco() {
		try {
			fxmlName = "payment_payco.fxml";
			stage.close();
			stage = new Stage();
			newOpen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickLoading() {
		
		db.setManagerDTO();
		db.selectStock();
		
		dto = OrderDTO.dto;
	
		db.updateMenu(dto,orderDto);
		db.stockUpdate(dto,orderDto);
		
		try {
			stage = StageStore.stage;
			stage.close();
			stage = new Stage();
			loading.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}